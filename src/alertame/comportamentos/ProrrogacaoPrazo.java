/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package alertame.comportamentos;

import alertame.moodle.*;
import alertame.utils.HibernateUtil;
import alertame.utils.MailUtil;
import alertame.utils.Module;
import alertame.utils.Persistence;
import alertame.utils.Role;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author RomeroGomes
 */
public class ProrrogacaoPrazo extends OneShotBehaviour {

    public ProrrogacaoPrazo(Agent a) {
        super(a);
    }

    @Override
    public void action() {

        String HQL = "FROM MdlAlertameEventos WHERE notificacaoid = 26 AND viewed = 0";
        try {
            List<MdlAlertameEventos> UpdateLista = Persistence.Listar(HQL);
            boolean empty = UpdateLista.isEmpty();

            if (!empty) {

                for (MdlAlertameEventos evento : UpdateLista) {
                    long logid = evento.getLogid();
                    long eventoid = evento.getId();

                    MdlLog Log = (MdlLog) Persistence.carregar(logid, MdlLog.class);
                    long cmid = Log.getCmid();

                    MdlCourseModules CourseModules = (MdlCourseModules) Persistence.carregar(cmid, MdlCourseModules.class);

                    long InstanceID = CourseModules.getInstance();
                    long ModuloID = CourseModules.getModule();
                    long cursoid = CourseModules.getCourse();

                    MdlAlertameAtividades atividade = (MdlAlertameAtividades) HibernateUtil.getSessionFactory().openSession()
                            .createCriteria(MdlAlertameAtividades.class)
                            .add(Restrictions.eq("instancia", InstanceID))
                            .add(Restrictions.eq("curso", cursoid))
                            .add(Restrictions.eq("modulo", ModuloID))
                            .add(Restrictions.eq("visivel", true))                            
                            .uniqueResult();

                    //long ModuloID = atividade.getModulo();
                    //long InstanceID = atividade.getInstancia();
                    long encerramentoSalvo = atividade.getEncerramento();
                    String nomeSalvo = atividade.getNome();
                    //long cursoid = atividade.getCurso();

                    long encerramentoAtual = 0;
                    //String nomeAtual = "";

                    //recupera a data de fechamento da atividade bem como seu respectivo nome
                    if (ModuloID == Module.ASSIGNMENT) {
                        MdlAssignment Assignment = (MdlAssignment) Persistence.carregar(InstanceID, MdlAssignment.class);
                        encerramentoAtual = Assignment.getTimedue();
                        //nomeAtual = Assignment.getName();

                    } else if (ModuloID == Module.HOTPOT) {
                        MdlHotpot Glossary = (MdlHotpot) Persistence.carregar(InstanceID, MdlHotpot.class);
                        encerramentoAtual = Glossary.getTimeclose();
                        //nomeAtual = Glossary.getName();

                    } else if (ModuloID == Module.DATA) {
                        MdlData Data = (MdlData) Persistence.carregar(InstanceID, MdlData.class);
                        encerramentoAtual = Data.getTimeavailableto();
                        //nomeAtual = Data.getName();

                    } else if (ModuloID == Module.CHAT) {
                        MdlChat Chat = (MdlChat) Persistence.carregar(InstanceID, MdlChat.class);
                        encerramentoAtual = Chat.getChattime();
                        //nomeAtual = Chat.getName();

                    } else if (ModuloID == Module.CHOICE) {
                        MdlChoice Choice = (MdlChoice) Persistence.carregar(InstanceID, MdlChoice.class);
                        encerramentoAtual = Choice.getTimeclose();
                        //nomeAtual = Choice.getName();
                    } else if (ModuloID == Module.FORUM) {
                        MdlForum Forum = (MdlForum) Persistence.carregar(InstanceID, MdlForum.class);
                        encerramentoAtual = Forum.getAssesstimefinish();
                        //nomeAtual = Forum.getName();

                    } else if (ModuloID == Module.GLOSSARY) {
                        MdlGlossary Glossary = (MdlGlossary) Persistence.carregar(InstanceID, MdlGlossary.class);
                        encerramentoAtual = Glossary.getAssesstimefinish();
                        //nomeAtual = Glossary.getName();

                    } else if (ModuloID == Module.WORKSHOP) {
                        MdlWorkshop Workshop = (MdlWorkshop) Persistence.carregar(InstanceID, MdlWorkshop.class);
                        encerramentoAtual = Workshop.getSubmissionend();
                        //nomeAtual = Workshop.getName();

                    } else if (ModuloID == Module.LESSON) {
                        MdlLesson Lesson = (MdlLesson) Persistence.carregar(InstanceID, MdlLesson.class);
                        encerramentoAtual = Lesson.getDeadline();
                        //nomeAtual = Lesson.getName();

                    } else if (ModuloID == Module.QUIZ) {
                        MdlQuiz Quiz = (MdlQuiz) Persistence.carregar(InstanceID, MdlQuiz.class);
                        encerramentoAtual = Quiz.getTimeclose();
                        //nomeAtual = Quiz.getName();

                    }



//                            if (!nomeAtual.equals(nomeSalvo)) {
//                                MdlCourse Curso = (MdlCourse) Persistence.carregar(cursoid, MdlCourse.class);
//                                String cursoNome = Curso.getFullname();
//                                System.out.println("Houve alteração de nome");
//                                mensagem += " A atividade " + nomeSalvo + " do curso " + cursoNome + " trocou de título, agora passa a ser " + nomeAtual + ".";
//
//                            } 

                    if (encerramentoAtual != encerramentoSalvo) {
                        atividade.setEncerramento(encerramentoAtual);
                        String mensagem = "Alert@ME Informa:";

                        MdlCourse Curso = (MdlCourse) Persistence.carregar(cursoid, MdlCourse.class);
                        String cursoNome = Curso.getFullname();
                        Date dataProrrogacao = new java.sql.Date(encerramentoAtual * 1000);
                        String data = dataProrrogacao.toLocaleString();

                        if (ModuloID == Module.CHAT) {
                            mensagem += " O Chat " + nomeSalvo + " do curso " + cursoNome + " foi prorrogado! Lembre-se desta data: " + data + ".";
                        } else {

                            mensagem += " A atividade " + nomeSalvo + " do curso " + cursoNome + " foi prorrogada até " + data + ".";
                        }

                        System.out.println("Houve alteração de data de encerramento");

                        mensagem += " Continue participando do curso!";
                        String SQLAlunoCurso = "SELECT DISTINCT rs FROM MdlRoleAssignments rs WHERE rs.roleid =" + Role.STUDENT + " AND rs.contextid = (SELECT id FROM MdlContext WHERE instanceid=" + cursoid + " AND contextlevel=50)";

                        List<MdlRoleAssignments> InteressadosLista = Persistence.Listar(SQLAlunoCurso);
                        boolean empty1 = InteressadosLista.isEmpty();

                        if (!empty1) {

                            for (MdlRoleAssignments AlunoCurso : InteressadosLista) {
                                long userid = AlunoCurso.getUserid();

                                MdlAlertameEnviados sms = new MdlAlertameEnviados();
                                sms.setEventoid(eventoid);
                                sms.setMensagem(mensagem);
                                sms.setHorario(new Long(0));
                                sms.setTransmitido(new Long(0));
                                sms.setTipo("prorrogacao-prazo");
                                sms.setUserid(userid);

                                Persistence.salvar(sms);
                            }
                        }
                    }

                    evento.setViewed(true);
                    Persistence.atualizar(atividade);
                    Persistence.atualizar(evento);
                }
                comunicarAgente("Carteiro", "news", ACLMessage.INFORM);
            }



        } catch (Exception ex) {
            MailUtil.sendEmailError(ex);
            Logger.getLogger(ProrrogacaoPrazo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Método que realiza a busca nas páginas amarelas da plataforma
     */
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
