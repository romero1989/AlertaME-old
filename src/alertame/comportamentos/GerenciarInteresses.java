/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package alertame.comportamentos;

import alertame.agentes.ManagerAgent;
import alertame.moodle.*;
import alertame.utils.MailUtil;
import alertame.utils.Persistence;
import alertame.utils.Role;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Alert@ME
 */
public class GerenciarInteresses extends OneShotBehaviour {

    private final int CHAT = 8;

    public GerenciarInteresses(Agent a) {
        super(a);
    }

    @Override
    public void action() {

        try {
            List<MdlAlertameEventos> ListaNovosEventos = getEventosCapturados();


            if (!ListaNovosEventos.isEmpty()) {
                System.out.println("Retornou " + ListaNovosEventos.size() + " novos eventos...");



                for (MdlAlertameEventos evento : ListaNovosEventos) {

                    Long eventoid = evento.getId();
                    Long logid = evento.getLogid();
                    Long horaCaptura = evento.getCriacao();
                    Long notificacaoid = evento.getNotificacaoid();

                    String descricao = getDescricaoNotificacao(notificacaoid);

                    MdlLog Log = (MdlLog) Persistence.carregar(logid, MdlLog.class);

                    Long userid = Log.getUserid();
                    MdlUser User = (MdlUser) Persistence.carregar(userid, MdlUser.class);
                    String firstname = User.getFirstname();
                    Long curso = Log.getCourse();

                    MdlAlertameAtividades atividade = (MdlAlertameAtividades) Persistence.getSession()
                            .createCriteria(MdlAlertameAtividades.class)
                            .add(Restrictions.eq("logid", logid))
                            .add(Restrictions.eq("visivel", true))
                            .add(Restrictions.eq("curso", curso))
                            .uniqueResult();

                    if (atividade != null) {
                        //Long curso = atividade.getCurso();
                        System.out.println("NullPointerException: " + logid + "," + true + "," + curso + "");
                        Long encerramento = atividade.getEncerramento();
                        String nome = atividade.getNome();

                        String funcaoCurso = getFuncaoCurso(userid, curso);

                        String SMS = formatarMensagem(nome, firstname, funcaoCurso, notificacaoid, descricao, curso, encerramento);

                        List<MdlAlertameInteresses> interessados = getInteressados(curso, notificacaoid);
                        boolean isEmpty = interessados.isEmpty();

                        if (!isEmpty) {
                            for (MdlAlertameInteresses interessado : interessados) {
                                Long horaInteresse = interessado.getInicio();
                                Long interessadoID = interessado.getUserid();

                                if (horaInteresse < horaCaptura) {

                                    MdlAlertameEnviados enviado = new MdlAlertameEnviados();
                                    enviado.setEventoid(eventoid);
                                    enviado.setUserid(interessadoID);
                                    enviado.setHorario(new Long(0));
                                    enviado.setMensagem(SMS);
                                    enviado.setTipo("novidade");
                                    enviado.setTransmitido(new Long(0));

                                    Persistence.salvar(enviado);

                                }
                            }
                        }

                        evento.setViewed(true);
                        Persistence.atualizar(evento);
                    } else {
                        System.out.println("Atividade == NULL, provavelmente Visibilidade 0.");
                    }




                }

                comunicarAgente("Carteiro", "news", ACLMessage.INFORM);

            }


        } catch (HibernateException ex) {
            MailUtil.sendEmailError(ex);
            Logger.getLogger(ManagerAgent.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        } catch (Exception ex) {
            MailUtil.sendEmailError(ex);
            Logger.getLogger(ManagerAgent.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        }
    }

    private List<MdlAlertameInteresses> getInteressados(Long curso, Long notificacaoid) throws Exception {
        String HQL = "FROM MdlAlertameInteresses WHERE course=" + curso + " and notificacaoid=" + notificacaoid + "";
        List<MdlAlertameInteresses> InteressadosLista = Persistence.Listar(HQL);
        return InteressadosLista;
    }

    private String formatarMensagem(String NomeAtividade,String NomeUsuario,String funcaoCurso, Long notificacaoid, String descricao, Long cursoid, Long encerramento) throws Exception {
        String SMS = "Alert@ME Informa: O ";

        SMS += funcaoCurso + " "+NomeUsuario;

        if (notificacaoid < 20) {
            SMS += " adicionou um(a) novo(a) ";
        }

        SMS += descricao +": "+NomeAtividade+", na sala ";

        MdlCourse curso = (MdlCourse) Persistence.carregar(cursoid, MdlCourse.class);

        String NomeCurso = curso.getFullname();

        SMS += NomeCurso + "";

        if (notificacaoid == CHAT) {
            Date d = new java.sql.Date(encerramento * 1000);
            String prazo = d.toLocaleString();
            SMS += ", para o dia " + prazo;
            SMS += ". Lembre-se esta data, não deixe de participar desta atividade!";
        } else {
            if (encerramento > 0) {
                Date d = new java.sql.Date(encerramento * 1000);
                String prazo = d.toLocaleString();
                SMS += ", com prazo até " + prazo;
            }

            SMS += ". Acesse o AVA/NE@D e confira!";
        }

        return SMS;
    }

    private String getDescricaoNotificacao(Long notificacaoid) throws Exception {

        String HQL = "SELECT descricao FROM mdl_alertame_notificacao WHERE id =" + notificacaoid + "";
        Object atributo = Persistence.getAtributo(HQL);

        return atributo.toString();
    }

    private Long getUserLog(Long logid) throws Exception {
        String sql = "SELECT userid FROM mdl_log WHERE id=" + logid + "";
        Object userid = Persistence.getAtributo(sql);

        return new Long(userid.toString());
    }

    private Long getCurso(Long logid) throws Exception {
        String sql = "SELECT course FROM mdl_log WHERE id=" + logid + "";
        Object userid = Persistence.getAtributo(sql);

        return new Long(userid.toString());
    }

    private List<MdlAlertameEventos> getEventosCapturados() throws Exception {
        String HQL = "FROM MdlAlertameEventos WHERE viewed = 0 AND notificacaoid != 26";
        List<MdlAlertameEventos> ListaNovosEventos = Persistence.Listar(HQL);
        return ListaNovosEventos;
    }

    public String getFuncaoCurso(Long UserID, Long CourseID) throws Exception {

        String funcao = "";

        String sql2 = "SELECT rs.roleid "
                + "FROM mdl_role_assignments rs "
                + "INNER JOIN mdl_context e ON rs.contextid = e.id "
                + "INNER JOIN mdl_user u ON u.id = rs.userid "
                + "INNER JOIN mdl_course c ON c.id = e.instanceid "
                + "WHERE e.contextlevel = 50 "
                + "AND e.instanceid = " + CourseID + " "
                + "AND u.id = " + UserID + "";

        Object object = Persistence.getAtributo(sql2);

        if (object != null) {
            Integer papel = new Integer(object.toString());
            if (papel == Role.TEACHER_COURSE_CREATOR) {
                funcao = "professor";
            } else if (papel == Role.TUTOR_TEACHER) {
                funcao = "tutor";
            } else if (papel == Role.ADMINISTRATOR) {
                funcao = "administrador da sala";
            }
        } else {
            funcao = "administrador da Moodle";
        }

        return funcao;

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
