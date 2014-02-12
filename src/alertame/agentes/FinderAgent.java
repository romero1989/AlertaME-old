package alertame.agentes;

import alertame.comportamentos.ProcuraAdicaoEventos;
import alertame.comportamentos.VerificarPublicacao;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author RomeroGomes
 */
public class FinderAgent extends Agent {

    private Integer STATUS = 0;
    private Integer CONECTADO = 1;
    private Integer DESCONECTADO = 0;
    private Integer MENSAGEM = 0;

    @Override
    protected void setup() {
        registrarYellowPages();


        addBehaviour(new CyclicBehaviour(this) {
            @Override
            public void action() {
                
                ACLMessage msg = this.myAgent.receive();
                System.out.println("[" + this.myAgent.getLocalName() + "]: Executando minhas atividades...");

                if (msg != null) {
                    ACLMessage reply = msg.createReply();
                    System.out.println("[" + myAgent.getLocalName() + "]: Recebi uma mensagem de " + msg.getSender().getLocalName() + " com conteudo: " + msg.getContent());

                    String content = msg.getContent();

                    if ("ok".equals(content) || "execute".equals(content)) {

                        System.out.println("[" + myAgent.getLocalName() + "]: Recebi uma mensagem conexão OK!");
                        STATUS = CONECTADO;
                        System.out.println("[" + myAgent.getLocalName() + "]: Respondendo um Confirm para " + msg.getSender().getLocalName() + "...");

                        MENSAGEM = 0;

                    } else if ("notok".equals(content)) {

                        System.out.println("[" + myAgent.getLocalName() + "]: Recebeu uma mensagem conexão desconectada");
                        STATUS = DESCONECTADO;
                        System.out.println("[" + myAgent.getLocalName() + "]: Respondendo um Confirm para " + msg.getSender().getLocalName() + "...");

                        MENSAGEM = 0;

                    }
                    
                    reply.setPerformative(ACLMessage.CONFIRM);
                    send(reply);

                } else {
                    if (MENSAGEM == 0) {
                        System.out.println("[" + myAgent.getLocalName() + "]: Conexão desativada, mandando mensagem para StarterAgent...");
                        comunicarAgente("SSH", "sessao", ACLMessage.REQUEST);
                        STATUS = DESCONECTADO;
                        MENSAGEM = 1;
                    }
                }
                block();
            }
        });

        //a cada 5 min verifica a base de dados do moodle
        addBehaviour(new TickerBehaviour(this, 300000) {
            @Override
            protected void onTick() {
                if (STATUS == CONECTADO) {
                    System.out.println("[" + myAgent.getLocalName() + "]: STATUS:" + STATUS + ", CONECTADO: " + CONECTADO);
                    System.out.println("[" + myAgent.getLocalName() + "]: Executando o comportamento \"ProcuraAdicaoEventos\"");

                    addBehaviour(new ProcuraAdicaoEventos(myAgent));
                    addBehaviour(new VerificarPublicacao());
                    System.out.println("Executou o comportamento  Procura... ###################################");
                } 
            }
        });
    }

    private void registrarYellowPages() {
        try {

            ServiceDescription sd = new ServiceDescription(); //Seu servi ̧co  ́e salvar vidas
            sd.setType("Procurador");
            sd.setName(this.getLocalName());

            DFAgentDescription dfd = new DFAgentDescription();
            dfd.addServices(sd);
            DFService.register(this, dfd);





        } catch (FIPAException ex) {
            Logger.getLogger(FinderAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método que realiza a busca nas pa ́ginas amarelas da plataforma
     */
    private String buscaAgenteResponsavel(final String Pedido) {
        String AgentName = "";

        ServiceDescription sd = new ServiceDescription();
        sd.setType(Pedido);

        DFAgentDescription dfd = new DFAgentDescription();
        dfd.addServices(sd);

        try {
            DFAgentDescription[] resultado = DFService.search(this, dfd);

            if (resultado.length != 0) {
                AgentName = resultado[0].getName().getLocalName();
            } else {
                AgentName = "-1";
            }

        } catch (FIPAException e) {
            e.getMessage();
        } finally {
            return AgentName;
        }

    }

    private void comunicarAgente(String Servico, String content, Integer performative) {
        String AgenteResponsavel = buscaAgenteResponsavel(Servico);

        if (!AgenteResponsavel.equals("-1")) {
            ACLMessage msg = new ACLMessage(performative);
            msg.addReceiver(new AID(AgenteResponsavel, AID.ISLOCALNAME));
            msg.setContent(content);
            send(msg);
        } else {
            System.out.println("Nao encontrou o agente responsavel...");
        }
    }
}
