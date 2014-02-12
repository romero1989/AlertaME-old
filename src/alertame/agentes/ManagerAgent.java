package alertame.agentes;

import alertame.comportamentos.GerenciarInteresses;
import alertame.comportamentos.GerenciarRecemPublicados;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author RomeroGomes
 */
public class ManagerAgent extends Agent {

    private Integer STATUS = 0;
    private Integer CONECTADO = 1;
    private Integer DESCONECTADO = 0;
    private Integer MENSAGEM = 0;

    @Override
    public void setup() {
        registraYellowPages();


        addBehaviour(new CyclicBehaviour(this) {
            @Override
            public void action() {
                ACLMessage msg = this.myAgent.receive();

                if (msg != null) {

                    ACLMessage reply = msg.createReply();
                    System.out.println("[" + myAgent.getLocalName() + "]: Recebeu uma mensagem de " + msg.getSender().getLocalName());

                    String content = msg.getContent();

                    if ("ok".equals(content) || "execute".equals(content)) {

                        System.out.println("[" + myAgent.getLocalName() + "]: Recebeu uma mensagem conexão OK!");
                        STATUS = CONECTADO;
                        reply.setPerformative(ACLMessage.CONFIRM);
                        send(reply);
                        MENSAGEM = 0;

                    } else if ("notok".equals(content)) {

                        System.out.println("[" + myAgent.getLocalName() + "]: Recebeu uma mensagem conexão desconectada");
                        STATUS = DESCONECTADO;
                        MENSAGEM = 0;

                    } else if ("news".equals(content)) {

                        if (STATUS == CONECTADO) {
                            System.out.println("[" + myAgent.getLocalName() + "]: Conexão ativa, executando o comportamento Gerenciar Interesses...");
                            addBehaviour(new GerenciarInteresses(myAgent));

                            reply.setPerformative(ACLMessage.INFORM);
                            myAgent.send(reply);
                        } else {
                            System.out.println("[" + myAgent.getLocalName() + "]: Conexão desativada, mandando mensagem para StarterAgent...");
                            comunicarAgente("SSH", "sessao", ACLMessage.REQUEST);
                            STATUS = DESCONECTADO;
                            MENSAGEM = 1;
                        }

                    } else if ("nothing".equals(content)) {

                        reply.setPerformative(ACLMessage.CONFIRM);
                        myAgent.send(reply);
                        System.out.println("[" + myAgent.getLocalName() + "]: Nothing, Confirm and Block();");


                    } else if ("visible".equals(content)) {
                        //implementar
                        System.out.println("Evento visible recebido de " + msg.getSender().getLocalName());
                        addBehaviour(new GerenciarRecemPublicados());
                    }

                } else {
                    if (MENSAGEM == 0) {
                        System.out.println("[" + myAgent.getLocalName() + "]: Conexão desativada, mandando mensagem para StarterAgent...");
                        comunicarAgente("SSH", "sessao", ACLMessage.REQUEST);
                        //MENSAGEM = 1;
                        STATUS = DESCONECTADO;
                        MENSAGEM = 1;
                    }

                }

                System.out.println("[" + myAgent.getLocalName() + "]: Block();");
                //40min
                //block(2400000);
                //10min
                block();
            }
        });

        addBehaviour(new TickerBehaviour(this, 350000) {
            @Override
            protected void onTick() {
                if (STATUS == CONECTADO) {
                    System.out.println("[" + myAgent.getLocalName() + "]: Conexão ativa, executando o comportamento Gerenciar Interesses...");
                    addBehaviour(new GerenciarInteresses(myAgent));
                    addBehaviour(new GerenciarRecemPublicados());

                }
            }
        });


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

    private void registraYellowPages() {
        try {

            ServiceDescription sd = new ServiceDescription(); //Seu servi ̧co  ́e salvar vidas
            sd.setType("Gerente");
            sd.setName(this.getLocalName());

            DFAgentDescription dfd = new DFAgentDescription();
            dfd.addServices(sd);
            DFService.register(this, dfd);


        } catch (FIPAException ex) {
            Logger.getLogger(FinderAgent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HibernateException ex) {
            Logger.getLogger(FinderAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
