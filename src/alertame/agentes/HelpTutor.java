/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package alertame.agentes;

import alertame.comportamentos.ProrrogacaoPrazo;
import alertame.comportamentos.VerificaEncerramentoAtividades;
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

/**
 *
 * @author RomeroGomes
 */
public class HelpTutor extends Agent {

    private Integer STATUS = 0;
    private Integer CONECTADO = 1;
    private Integer DESCONECTADO = 0;
    private Integer MENSAGEM = 0;

    @Override
    public void setup() {
        registrarYellowPages();

        addBehaviour(new CyclicBehaviour(this) {
            @Override
            public void action() {
                ACLMessage msg = this.myAgent.receive();

                if (msg != null) {

                    ACLMessage reply = msg.createReply();
                    System.out.println("[" + myAgent.getLocalName() + "]: Recebeu uma mensagem de " + msg.getSender().getLocalName());

                    String content = msg.getContent();

                    if ("news".equals(content)) {

                        if (STATUS == CONECTADO) {
                            System.out.println("[" + myAgent.getLocalName() + "]: Verificando encerramento de atividades...");
                            addBehaviour(new VerificaEncerramentoAtividades(myAgent));

                            System.out.println("[" + myAgent.getLocalName() + "]: Verificando prorrogação de prazo para entrega de atividades...");
                            addBehaviour(new ProrrogacaoPrazo(myAgent));

                            reply.setPerformative(ACLMessage.INFORM);
                            myAgent.send(reply);
                        } else {

                            System.out.println("[" + myAgent.getLocalName() + "]: Conexão desativada, mandando mensagem para StarterAgent...");
                            comunicarAgente("SSH", "sessao", ACLMessage.REQUEST);
                            MENSAGEM = 1;
                            STATUS = DESCONECTADO;
                        }



                    } else if ("execute".equals(content) || "ok".equals(content)) {
                        System.out.println("[" + myAgent.getLocalName() + "]: Conexão ativada! atualizando a variavel STATUS...");
                        STATUS = CONECTADO;

                        reply.setPerformative(ACLMessage.CONFIRM);
                        send(reply);
                        MENSAGEM = 0;

                    } else if ("notok".equals(content)) {

                        System.out.println("[" + myAgent.getLocalName() + "]: Recebeu uma mensagem conexão desconectada");
                        STATUS = DESCONECTADO;
                        MENSAGEM = 0;
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
                block();
            }
        });

        //a cada 5 min verifica a base de dados do moodle
        addBehaviour(new TickerBehaviour(this, 300000) {
            @Override
            protected void onTick() {
                if (STATUS == CONECTADO) {
                    System.out.println("[" + myAgent.getLocalName() + "]: Verificando encerramento de atividades...");
                    addBehaviour(new VerificaEncerramentoAtividades(myAgent));

                    System.out.println("[" + myAgent.getLocalName() + "]: Verificando prorrogação de prazo para entrega de atividades...");
                    addBehaviour(new ProrrogacaoPrazo(myAgent));
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

    private void registrarYellowPages() {
        try {
            //Seu servi ̧co  ́e salvar vidas
            ServiceDescription sd = new ServiceDescription(); //Seu servi ̧co  ́e salvar vidas

            sd.setType("Tutor");
            sd.setName(this.getLocalName());

            DFAgentDescription dfd = new DFAgentDescription();
            dfd.addServices(sd);


            try {
                DFService.register(this, dfd);
            } catch (FIPAException ex) {
                Logger.getLogger(PostmanAgent.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception ex) {
            Logger.getLogger(PostmanAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
