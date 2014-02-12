/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package alertame.comportamentos;

import alertame.moodle.MdlAlertameAtividades;
import alertame.moodle.MdlCourseModules;
import alertame.utils.MailUtil;
import alertame.utils.Persistence;
import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alert@ME
 */
public class VerificarPublicacao extends OneShotBehaviour {

    @Override
    public void action() {
        try {
            System.out.println("[" + myAgent.getLocalName() + "]: Verificando se ha um modulo que se tornou visivel em uma sala...");
            System.out.println("[" + myAgent.getLocalName() + "]: Recuperando modulos nao publicados...");
            List<MdlAlertameAtividades> modulosInvisiveis = getModulosInvisiveis();

            Boolean isEmpty2 = modulosInvisiveis.isEmpty();
            System.out.println("[" + myAgent.getLocalName() + "]: Ha modulos nao publicados? " + isEmpty2);

            if (!isEmpty2) {
                System.out.println("[" + myAgent.getLocalName() + "]: Ha " + modulosInvisiveis.size() + " modulos nao publicados...");
                for (MdlAlertameAtividades atividade : modulosInvisiveis) {
                    try {

                        System.out.println("[" + myAgent.getLocalName() + "]: " + atividade.toString());

                        Long cmid = atividade.getCmid();
                        MdlCourseModules cm = (MdlCourseModules) Persistence.carregar(cmid, MdlCourseModules.class);

                        boolean VisAtividade = atividade.isVisivel();
                        System.out.println("[" + myAgent.getLocalName() + "]: Visibilidade da Atividade na tabela MdlAlertameAtividades: " + VisAtividade);
                        boolean ViscmID = cm.isVisible();
                        System.out.println("[" + myAgent.getLocalName() + "]: Visibilidade da Atividade na tabela Course Modules: " + ViscmID);

                        if (VisAtividade == false && ViscmID == true) {
                            System.out.println("[" + myAgent.getLocalName() + "]: Foi publicado...");
                            atividade.setVisivel(true);
                            atividade.setVersao(new Long(1)); //para dizer que foi recem publicado na sala
                        } else if (VisAtividade == true && ViscmID == false) {
                            atividade.setVisivel(false);
                            atividade.setVersao(new Long(2)); //para dizer que foi recem DESpublicado na sala
                            System.out.println("[" + myAgent.getLocalName() + "]: Foi despublicado...");
                        }

                        Persistence.atualizar(atividade);
                        System.out.println("[" + myAgent.getLocalName() + "]: " + atividade.toString());
                    } catch (Exception ex) {
                        MailUtil.sendEmailError(ex);
                        Logger.getLogger(VerificarPublicacao.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                System.out.println("[" + myAgent.getLocalName() + "]: Avisando que houve evento de visibilidade para o ManagerAgente..");
                comunicarAgente("Gerente", "visible", ACLMessage.INFORM);
            } else {
                System.out.println("[" + myAgent.getLocalName() + "]: Avisando que nao houve eventos para o ManagerAgente..");
                comunicarAgente("Gerente", "nothing", ACLMessage.INFORM);
            }
        } catch (Exception ex) {
            MailUtil.sendEmailError(ex);
            Logger.getLogger(VerificarPublicacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private List<MdlAlertameAtividades> getModulosInvisiveis() throws Exception {

        String HQL = "FROM MdlAlertameAtividades where visivel = 0";
        List<MdlAlertameAtividades> AtividadesLista = Persistence.Listar(HQL);

        return AtividadesLista;
    }

    private String buscaAgenteResponsavel(final String Pedido) {
        String AgentName = "";

        ServiceDescription sd = new ServiceDescription();
        sd.setType(Pedido);

        DFAgentDescription dfd = new DFAgentDescription();
        dfd.addServices(sd);

        try {
            DFAgentDescription[] resultado = DFService.search(myAgent, dfd);

            if (resultado.length != 0) {
                AgentName = resultado[0].getName().getLocalName();
            } else {
                AgentName = "-1";
            }

        } catch (FIPAException e) {
            MailUtil.sendEmailError(e);
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
            myAgent.send(msg);
        } else {
            System.out.println("Nao encontrou o agente responsavel...");
        }
    }
}
