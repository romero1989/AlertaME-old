/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package alertame.agentes;

import alertame.utils.SSH;
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
public class StartAgent extends Agent {

    private int connect;
    private final SSH ssh = new SSH();

    @Override
    public void setup() {

        registrarYellowPages();

        estabelecerConexão();
        try {
            Thread.sleep(60000);
        } catch (InterruptedException ex) {
            Logger.getLogger(StartAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
        addBehaviour(new CyclicBehaviour(this) {
            @Override
            public void action() {
                
                ACLMessage msg = this.myAgent.receive();
                
                if (msg != null) {
                    
                    System.out.println("["+myAgent.getLocalName()+"] Recebi uma mensagem de "+msg.getSender().getLocalName()+" com conteudo: "+msg.getContent());
                    
                    ACLMessage reply = msg.createReply();
                    String content = msg.getContent();

                    //se houver uma mensagem solcitando informações sobre a conexão
                    //com o banco de dados
                    if ("sessao".equals(content)) {

                        System.out.println("[" + myAgent.getLocalName() + "]:"
                                + " Recebeu uma mensagem de [" + msg.getSender().getLocalName() + "] para verificar a Sessão SSH...");

                        Boolean connected = ssh.isConnected();

                        if (connected) {
                            reply.setContent("ok");
                            reply.setPerformative(ACLMessage.INFORM);
                            this.myAgent.send(reply);

                            System.out.println("[" + myAgent.getLocalName() + "]: Respondeu ao "
                                    + reply.getSender().getLocalName() + ": Conexão ativa.");
                        } else {
                            reply.setPerformative(ACLMessage.INFORM);
                            reply.setContent("notok");
                            this.myAgent.send(reply);

                            System.out.println("[" + myAgent.getLocalName() + "]: Respondeu ao "
                                    + reply.getSender().getLocalName() + ": Conexão desativada.");
                        }
                    }
                } else {
                    System.out.println("[" + myAgent.getLocalName() + "]: Nao recebi nenhuma mensagem... Block();");
                }
                block();
                //msg.reset();

            }
        });

        //a cada 1min verifica o Tunel
        addBehaviour(new TickerBehaviour(this, 60000) {
            @Override
            protected void onTick() {
                System.out.println("[" + myAgent.getLocalName() + "]: Verificando conexão SSH...");

                Boolean connected = ssh.isConnected();

                if (!connected) {
                    System.out.println("[" + myAgent.getLocalName() + "]: Sessão perdida...");
                    System.out.println("[" + myAgent.getLocalName() + "]: Reestabelecendo a conexão SSH...");

                    connect = ssh.connect();

                    if (connect == -1) {
                        System.out.println("[" + myAgent.getLocalName() + "]: Houve erro durante a construção do Tunnel SSH: JSchException.");
                    } else if (connect == 0) {
                        System.out.println("[" + myAgent.getLocalName() + "]: Houve erro durante a construção do Tunnel SSH: Connection failed.");
                    } else if (connect == 1) {
                        System.out.println("[" + myAgent.getLocalName() + "]: Conexão estabelecida com sucesso!");
                    }

                } else {
                    System.out.println("[" + myAgent.getLocalName() + "]: Sessão SSH ativa...");

                    String FinderAgent = buscaAgenteResponsavel("Procurador");
                    avisarAgente(FinderAgent, "ok");
                    String ManagerAgent = buscaAgenteResponsavel("Gerente");
                    avisarAgente(ManagerAgent, "ok");
                    String TutorAgent = buscaAgenteResponsavel("Tutor");
                    avisarAgente(TutorAgent, "ok");
                    String PostmanAgent = buscaAgenteResponsavel("Carteiro");
                    avisarAgente(PostmanAgent, "ok");
                    
                }
            }
        });

    }

    private void estabelecerConexão() {
        System.out.println("[" + this.getLocalName() + "]: Estabelendo conexão SSH com o Servidor...");
        connect = ssh.connect();

        if (connect == -1) {
            System.out.println("[" + this.getLocalName() + "]: Houve erro durante a construção do Tunnel SSH: JSchException.");
        } else if (connect == 0) {
            System.out.println("[" + this.getLocalName() + "]: Houve erro durante a construção do Tunnel SSH: Connection failed.");
        } else if (connect == 1) {
            System.out.println("[" + this.getLocalName() + "]: Conexão estabelecida com sucesso!");
            


            String FinderAgent = buscaAgenteResponsavel("Procurador");
            String ManagerAgent = buscaAgenteResponsavel("Gerente");
            String TutorAgent = buscaAgenteResponsavel("Tutor");
            String PostmanAgent = buscaAgenteResponsavel("Carteiro");

            System.out.println("[" + this.getLocalName() + "]: Avisando ao agente: "+FinderAgent);
            avisarAgente(FinderAgent, "execute");
            System.out.println("[" + this.getLocalName() + "]: Avisando ao agente: "+ManagerAgent);
            avisarAgente(ManagerAgent, "execute");
            System.out.println("[" + this.getLocalName() + "]: Avisando ao agente: "+TutorAgent);
            avisarAgente(TutorAgent, "execute");
            System.out.println("[" + this.getLocalName() + "]: Avisando ao agente: "+PostmanAgent);
            avisarAgente(PostmanAgent, "execute");
        }
    }

    private void registrarYellowPages() {
        try {
            System.out.println("[" + this.getLocalName() + "]: Registrando nas paginas amarelas... ");
            ServiceDescription sd = new ServiceDescription(); //Seu servi ̧co  ́e salvar vidas
            sd.setType("SSH");
            sd.setName(this.getLocalName());

            DFAgentDescription dfd = new DFAgentDescription();
            dfd.addServices(sd);
            DFService.register(this, dfd);

        } catch (FIPAException ex) {
            Logger.getLogger(StartAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void avisarAgente(String AgenteName, String content) {
        ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
        msg.addReceiver(new AID(AgenteName, AID.ISLOCALNAME));
        msg.setContent(content);
        send(msg);
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
}
