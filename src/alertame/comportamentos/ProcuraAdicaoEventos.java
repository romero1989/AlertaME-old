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
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.classic.Session;

/**
 * *
 * SELECT * FROM `myfield` ORDER BY `id` DESC LIMIT 0,1
 *
 * @author RomeroGomes
 */
public class ProcuraAdicaoEventos extends OneShotBehaviour {

    private final Integer LAST_INDEX = 0;

    public ProcuraAdicaoEventos(Agent a) {
        super(a);
    }

    @Override
    public void action() {

        try {
            System.out.println("[" + myAgent.getLocalName() + "]: Executando meu comportamento de procurar novas atividades...");
            Long UltimoIndice = getUltimoIndiceEventos();
            System.out.println("[" + myAgent.getLocalName() + "]: Ultimo indice MdlAlertameEventos analisado: " + UltimoIndice);

            ArrayList<String> ModulosLista = getModulos();
            System.out.println("[" + myAgent.getLocalName() + "]: Carregando os modulos...");
            ArrayList<Long> cursosAlertaME = getCursosAlertaME();
            System.out.println("[" + myAgent.getLocalName() + "]: Carregando os Alert@ME`s registrado no Banco de Dados...");
            ArrayList<String> actions = getActions();
            System.out.println("[" + myAgent.getLocalName() + "]: Carregando os acoes dos modulos...");

            boolean isEmpty = cursosAlertaME.isEmpty();
            System.out.println("[" + myAgent.getLocalName() + "]: Ha instancias do Alert@ME? " + isEmpty);

            if (!isEmpty) {
                System.out.println("[" + myAgent.getLocalName() + "]: Carregando os modulos adicionados...");
                List<MdlLog> LogLista = getNovosModulos(UltimoIndice, ModulosLista, cursosAlertaME, actions);
                System.out.println("[" + myAgent.getLocalName() + "]: Modulos Adicionados: " + LogLista.size() + " unidades...");

                boolean empty = LogLista.isEmpty();
                System.out.println("[" + myAgent.getLocalName() + "]: Ha logs a serem analisados? "+empty);

                if (!empty) {
                    System.out.println("[" + myAgent.getLocalName() + "]: Percorrendo Logs encontrados...");

                    for (MdlLog Log : LogLista) {

                        System.out.println("[" + myAgent.getLocalName() + "]: " + Log.toString());

                        String modulo = Log.getModule().toUpperCase();
                        Long LogID = Log.getId();
                        Long time = Log.getTime();
                        String Info = Log.getInfo();
                        Long cmid = Log.getCmid();

                        Long ID = Long.valueOf(Info);
                        int moduloID = Module.getModuloID(modulo);
                        Long notificacaoID = null;

                        if ("update".equals(Log.getAction())) {
                            System.out.println("[" + myAgent.getLocalName() + "]: Update... Salvando somente na tabela de eventos... ");
                            notificacaoID = new Long(26);
                            salvarEvento(LogID, notificacaoID, time);

                            System.out.println("[" + myAgent.getLocalName() + "]: Avisando ao HelpTutor sobre os novos eventos...");
                            comunicarAgente("Tutor", "news", ACLMessage.REQUEST);
                            
                        } else if ("add".equals(Log.getAction())) {

                            notificacaoID = getNotificacaoID(Info, moduloID);

                            System.out.println("[" + myAgent.getLocalName() + "]: Add... Salvando somente na tabela de eventos... ");
                            salvarEvento(LogID, notificacaoID, time);
                            
                            MdlAlertameAtividades atividade = getAtividade(ID, cmid, LogID, moduloID);
                            
                            System.out.println("[" + myAgent.getLocalName() + "]: Add... Salvando somente na tabela de atividades... ");
                            salvarAtividade(atividade);
                            
                            System.out.println("[" + myAgent.getLocalName() + "]: Avisando ao ManagerAgent sobre os novos eventos...");
                            comunicarAgente("Gerente", "news", ACLMessage.REQUEST);
                        }
                    }

                } else {
                    System.out.println("[" + myAgent.getLocalName() + "]: Avisando ao ManagerAgent que nao ha novos eventos...");
                    comunicarAgente("Gerente", "nothing", ACLMessage.REQUEST);
                }
            } 
            

        } catch (NamingException ex) {
           MailUtil.sendEmailError(ex);
            Logger.getLogger(ProcuraAdicaoEventos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HibernateException ex) {
            MailUtil.sendEmailError(ex);
            Logger.getLogger(ProcuraAdicaoEventos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            MailUtil.sendEmailError(ex);
            Logger.getLogger(ProcuraAdicaoEventos.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }

    private List<MdlAlertameAtividades> getModulosInvisiveis() throws Exception {

        String HQL = "FROM MdlAlertameAtividades where visivel = 0";
        List<MdlAlertameAtividades> AtividadesLista = Persistence.Listar(HQL);

        return AtividadesLista;
    }

    private List<MdlLog> getNovosModulos(Long UltimoIndice, ArrayList<String> ModulosLista, ArrayList<Long> cursosAlertaME, ArrayList<String> actions) throws HibernateException {

        Session openSession = HibernateUtil.getSessionFactory().openSession();
        Query query = openSession.createQuery("FROM MdlLog log "
                + "WHERE log.id > " + UltimoIndice + " "
                + "AND log.action IN (:action) "
                + "AND log.module IN (:modulo) "
                + "AND log.course IN (:curso) ");

        query.setParameterList("action", actions);
        query.setParameterList("modulo", ModulosLista);
        query.setParameterList("curso", cursosAlertaME);

        //System.out.println("" + query.getQueryString());

        List<MdlLog> LogLista = query.list();
        return LogLista;
    }

    private ArrayList<String> getModulos() {
        //lista de módulos que tem prazo de entrega, Fechamento.
        ArrayList<String> ModulosLista = new ArrayList<String>();
        ModulosLista.add("assignment");
        ModulosLista.add("chat");
        ModulosLista.add("choice");
        ModulosLista.add("data");
        ModulosLista.add("forum");
        ModulosLista.add("glossary");
        ModulosLista.add("label");
        ModulosLista.add("lesson");
        ModulosLista.add("quiz");
        ModulosLista.add("resource");
        ModulosLista.add("scorm");
        ModulosLista.add("survey");
        ModulosLista.add("wiki");
        return ModulosLista;
    }

    private ArrayList<String> getActions() {
        //lista de módulos que tem prazo de entrega, Fechamento.
        ArrayList<String> ModulosLista = new ArrayList<String>();
        ModulosLista.add("add");
        ModulosLista.add("update");
        return ModulosLista;
    }

    private ArrayList<Long> getCursosAlertaME() throws Exception {
        List<MdlAlertame> AlertaMEList = Persistence.Listar("FROM MdlAlertame");

        ArrayList<Long> list = new ArrayList<Long>();

        for (MdlAlertame alertame : AlertaMEList) {
            list.add(alertame.getCourse());
        }

        return list;
    }

    private MdlAlertameAtividades getAtividade(Long ID, Long cmid, Long LogID, Integer ModuloID) throws Exception {
        MdlAlertameAtividades atividade = new MdlAlertameAtividades();
        String name;
        Long course;
        Long instancia;
        Long modulo = Long.valueOf(ModuloID);
        String tipo;
        Long criacao;
        Long edicao;
        Long encerramento;
        MdlCourseModules cm = (MdlCourseModules) Persistence.carregar(cmid, MdlCourseModules.class);
        Boolean visivel = cm.isVisible();


        switch (ModuloID) {
            case Module.ASSIGNMENT:
                System.out.println("Salvando atividade assignment..");

                MdlAssignment Assignment = (MdlAssignment) Persistence.carregar(ID, MdlAssignment.class);
                name = Assignment.getName();
                course = Assignment.getCourse();
                instancia = Assignment.getId();
                tipo = Assignment.getAssignmenttype();
                criacao = Assignment.getTimeavailable();
                edicao = Assignment.getTimemodified();
                encerramento = Assignment.getTimedue();

                atividade.setNome(name);
                atividade.setCurso(course);
                atividade.setInstancia(instancia);
                atividade.setModulo(modulo);
                atividade.setTipo(tipo);
                atividade.setCriacao(criacao);
                atividade.setEdicao(edicao);
                //atividade.setInicio(criacao);
                atividade.setEncerramento(encerramento);
                atividade.setCmid(cmid);
                atividade.setLogid(LogID);
                atividade.setVersao(new Long(0));
                atividade.setVisivel(visivel);

                break;
            case Module.CHAT:
                System.out.println("Salvando atividade chat..");
                MdlChat Chat = (MdlChat) Persistence.carregar(ID, MdlChat.class);

                name = Chat.getName();
                course = Chat.getCourse();
                instancia = Chat.getId();
                tipo = "chat";
                criacao = Chat.getTimemodified();
                edicao = criacao;
                encerramento = Chat.getChattime();

                atividade.setNome(name);
                atividade.setCurso(course);
                atividade.setInstancia(instancia);
                atividade.setModulo(modulo);
                atividade.setTipo(tipo);
                atividade.setCriacao(criacao);
                atividade.setEdicao(edicao);
                //atividade.setInicio(new Long(0));
                atividade.setEncerramento(encerramento);
                atividade.setCmid(cmid);
                atividade.setLogid(LogID);
                atividade.setVersao(new Long(0));
                atividade.setVisivel(visivel);

                break;
            case Module.CHOICE:
                System.out.println("Novo choice encontrado..");

                MdlChoice choice = (MdlChoice) Persistence.carregar(ID, MdlChoice.class);

                name = choice.getName();
                course = choice.getCourse();
                instancia = choice.getId();
                tipo = "choice";
                criacao = choice.getTimeopen();
                edicao = choice.getTimemodified();
                encerramento = choice.getTimeclose();

                atividade.setNome(name);
                atividade.setCurso(course);
                atividade.setInstancia(instancia);
                atividade.setModulo(modulo);
                atividade.setTipo(tipo);
                atividade.setCriacao(criacao);
                atividade.setEdicao(edicao);
                //atividade.setInicio(new Long(0));
                atividade.setEncerramento(encerramento);
                atividade.setCmid(cmid);
                atividade.setLogid(LogID);
                atividade.setVersao(new Long(0));
                atividade.setVisivel(visivel);

                break;
            case Module.DATA:
                System.out.println("Novo data encontrado..");

                MdlData data = (MdlData) Persistence.carregar(ID, MdlData.class);

                name = data.getName();
                course = data.getCourse();
                instancia = data.getId();
                tipo = "data";
                criacao = data.getTimeavailablefrom();
                encerramento = data.getTimeavailableto();

                atividade.setNome(name);
                atividade.setCurso(course);
                atividade.setInstancia(instancia);
                atividade.setModulo(modulo);
                atividade.setTipo(tipo);
                atividade.setCriacao(criacao);
                atividade.setEdicao(new Long(0));
                //atividade.setInicio(new Long(0));
                atividade.setEncerramento(encerramento);
                atividade.setCmid(cmid);
                atividade.setLogid(LogID);
                atividade.setVersao(new Long(0));
                atividade.setVisivel(visivel);

                break;
            case Module.FORUM:
                System.out.println("Novo forum encontrado..");

                MdlForum forum = (MdlForum) Persistence.carregar(ID, MdlForum.class);

                name = forum.getName();
                course = forum.getCourse();
                instancia = forum.getId();
                tipo = "forum";
                criacao = forum.getAssesstimestart();
                edicao = forum.getTimemodified();
                encerramento = forum.getAssesstimefinish();

                atividade.setNome(name);
                atividade.setCurso(course);
                atividade.setInstancia(instancia);
                atividade.setModulo(modulo);
                atividade.setTipo(tipo);
                atividade.setCriacao(criacao);
                atividade.setEdicao(edicao);
                //atividade.setInicio(criacao);
                atividade.setEncerramento(encerramento);
                atividade.setCmid(cmid);
                atividade.setLogid(LogID);
                atividade.setVersao(new Long(0));
                atividade.setVisivel(visivel);

                break;
            case Module.GLOSSARY:
                System.out.println("Novo glossary encontrado..");


                MdlGlossary glossary = (MdlGlossary) Persistence.carregar(ID, MdlGlossary.class);

                name = glossary.getName();
                course = glossary.getCourse();
                instancia = glossary.getId();
                tipo = "glossary";
                criacao = glossary.getAssesstimestart();
                edicao = glossary.getTimemodified();
                encerramento = glossary.getAssesstimefinish();

                atividade.setNome(name);
                atividade.setCurso(course);
                atividade.setInstancia(instancia);
                atividade.setModulo(modulo);
                atividade.setTipo(tipo);
                atividade.setCriacao(criacao);
                atividade.setEdicao(edicao);
                //atividade.setInicio(criacao);
                atividade.setEncerramento(encerramento);
                atividade.setCmid(cmid);
                atividade.setLogid(LogID);
                atividade.setVersao(new Long(0));
                atividade.setVisivel(visivel);

                break;
//                    case Module.HOTPOT:
//                        tipo = "hotpot";
//                        notificacaoID = getIDNotificacao(tipo);
//                        salvarEvento(LogID, notificacaoID, time);
//                        break;
//                    case Module.JOURNAL:
//                        tipo = "journal";
//                        notificacaoID = getIDNotificacao(tipo);
//                        salvarEvento(LogID, notificacaoID, time);
//                        break;
            case Module.LABEL:
                System.out.println("Novo label encontrado..");

                MdlLabel label = (MdlLabel) Persistence.carregar(ID, MdlLabel.class);

                name = label.getName();
                course = label.getCourse();
                instancia = label.getId();
                tipo = "label";
                edicao = label.getTimemodified();

                atividade.setNome(name);
                atividade.setCurso(course);
                atividade.setInstancia(instancia);
                atividade.setModulo(modulo);
                atividade.setTipo(tipo);
                atividade.setCriacao(new Long(0));
                atividade.setEdicao(edicao);
                //atividade.setInicio(new Long(0));
                atividade.setEncerramento(new Long(0));
                atividade.setCmid(cmid);
                atividade.setLogid(LogID);
                atividade.setVersao(new Long(0));
                atividade.setVisivel(visivel);

                break;
//                    case Module.LAMS:
//                        tipo = "lams";
//                        notificacaoID = getIDNotificacao(tipo);
//                        salvarEvento(LogID, notificacaoID, time);
//                        break;
            case Module.LESSON:
                System.out.println("Novo lesson encontrado..");

                MdlLesson lesson = (MdlLesson) Persistence.carregar(ID, MdlLesson.class);

                name = lesson.getName();
                course = lesson.getCourse();
                instancia = lesson.getId();
                tipo = "lesson";
                criacao = lesson.getAvailable();
                edicao = lesson.getTimemodified();
                encerramento = lesson.getDeadline();

                atividade.setNome(name);
                atividade.setCurso(course);
                atividade.setInstancia(instancia);
                atividade.setModulo(modulo);
                atividade.setTipo(tipo);
                atividade.setCriacao(criacao);
                atividade.setEdicao(edicao);
                //atividade.setInicio(criacao);
                atividade.setEncerramento(encerramento);
                atividade.setCmid(cmid);
                atividade.setLogid(LogID);
                atividade.setVersao(new Long(0));
                atividade.setVisivel(visivel);

                break;
            case Module.QUIZ:
                System.out.println("Novo quiz encontrado..");

                MdlQuiz quiz = (MdlQuiz) Persistence.carregar(ID, MdlQuiz.class);

                name = quiz.getName();
                course = quiz.getCourse();
                instancia = quiz.getId();
                tipo = "quiz";
                criacao = quiz.getTimecreated();
                edicao = quiz.getTimemodified();
                encerramento = quiz.getTimeclose();

                atividade.setNome(name);
                atividade.setCurso(course);
                atividade.setInstancia(instancia);
                atividade.setModulo(modulo);
                atividade.setTipo(tipo);
                atividade.setCriacao(criacao);
                atividade.setEdicao(edicao);
                //atividade.setInicio(criacao);
                atividade.setEncerramento(encerramento);
                atividade.setCmid(cmid);
                atividade.setLogid(LogID);
                atividade.setVersao(new Long(0));
                atividade.setVisivel(visivel);

                break;
            case Module.RESOURCE:
                System.out.println("Novo resource encontrado..");

                MdlResource resource = (MdlResource) Persistence.carregar(ID, MdlResource.class);

                name = resource.getName();
                course = resource.getCourse();
                instancia = resource.getId();
                tipo = resource.getType();
                edicao = resource.getTimemodified();

                atividade.setNome(name);
                atividade.setCurso(course);
                atividade.setInstancia(instancia);
                atividade.setModulo(modulo);
                atividade.setTipo(tipo);
                atividade.setCriacao(new Long(0));
                atividade.setEdicao(edicao);
                //atividade.setInicio(new Long(0));
                atividade.setEncerramento(new Long(0));
                atividade.setCmid(cmid);
                atividade.setLogid(LogID);
                atividade.setVersao(new Long(0));
                atividade.setVisivel(visivel);

                break;
            case Module.SCORM:
                System.out.println("Novo scorm encontrado..");

                MdlScorm scorm = (MdlScorm) Persistence.carregar(ID, MdlScorm.class);

                name = scorm.getName();
                course = scorm.getCourse();
                instancia = scorm.getId();
                tipo = "scorm";
                criacao = scorm.getLaunch();
                edicao = scorm.getTimemodified();

                atividade.setNome(name);
                atividade.setCurso(course);
                atividade.setInstancia(instancia);
                atividade.setModulo(modulo);
                atividade.setTipo(tipo);
                atividade.setCriacao(criacao);
                atividade.setEdicao(edicao);
                //atividade.setInicio(criacao);
                atividade.setEncerramento(new Long(0));
                atividade.setCmid(cmid);
                atividade.setLogid(LogID);
                atividade.setVersao(new Long(0));
                atividade.setVisivel(visivel);

                break;
            case Module.SURVEY:
                System.out.println("Novo survey encontrado..");

                MdlSurvey survey = (MdlSurvey) Persistence.carregar(ID, MdlSurvey.class);

                name = survey.getName();
                course = survey.getCourse();
                instancia = survey.getId();
                tipo = "survey";
                criacao = survey.getTimecreated();
                edicao = survey.getTimemodified();
                Integer days = survey.getDays();

                Date d = new Date(criacao * 1000);
                GregorianCalendar tempo_atividade = new GregorianCalendar();
                tempo_atividade.setTimeInMillis(d.getTime());
                tempo_atividade.add(Calendar.DAY_OF_MONTH, days);

                encerramento = tempo_atividade.getTimeInMillis();

                atividade.setNome(name);
                atividade.setCurso(course);
                atividade.setInstancia(instancia);
                atividade.setModulo(modulo);
                atividade.setTipo(tipo);
                atividade.setCriacao(criacao);
                atividade.setEdicao(edicao);
                //atividade.setInicio(criacao);
                atividade.setEncerramento(encerramento);
                atividade.setCmid(cmid);
                atividade.setLogid(LogID);
                atividade.setVersao(new Long(0));
                atividade.setVisivel(visivel);

                break;
            case Module.WIKI:
                System.out.println("Novo wiki encontrado..");

                MdlWiki wiki = (MdlWiki) Persistence.carregar(ID, MdlWiki.class);

                name = wiki.getName();
                course = wiki.getCourse();
                instancia = wiki.getId();
                tipo = "wiki";
                edicao = wiki.getTimemodified();

                atividade.setNome(name);
                atividade.setCurso(course);
                atividade.setInstancia(instancia);
                atividade.setModulo(modulo);
                atividade.setTipo(tipo);
                atividade.setCriacao(new Long(0));
                atividade.setEdicao(edicao);
                //atividade.setInicio(new Long(0));
                atividade.setEncerramento(new Long(0));
                atividade.setCmid(cmid);
                atividade.setLogid(LogID);
                atividade.setVersao(new Long(0));
                atividade.setVisivel(visivel);

                break;
//                    case Module.WORKSHOP:
//                        tipo = "workshop";
//                        notificacaoID = getIDNotificacao(tipo);
//                        salvarEvento(LogID, notificacaoID, time);
//                        break;
            default:
                System.out.println("Evento não classificado: " + ModuloID);
                break;
        }

        return atividade;
    }

    private void salvarAtividade(MdlAlertameAtividades atividade) throws Exception {
        Persistence.salvar(atividade);
        System.out.println("[" + myAgent.getLocalName() + "]: " + atividade.toString());
    }

    private Long getNotificacaoID(String Info, Integer ModuloID) throws Exception {

        String tipo;
        Long notificacaoID = new Long(0);

        switch (ModuloID) {
            case Module.ASSIGNMENT:
                System.out.println("Novo Assignment encontrado..");

                Long AssignmentID = Long.valueOf(Info);
                String assignmenttype = getAssignmentType(AssignmentID);
                notificacaoID = getID(assignmenttype);

                break;
            case Module.CHAT:
                System.out.println("Novo chat encontrado..");

                tipo = "chat";

                notificacaoID = getID(tipo);

                break;
            case Module.CHOICE:
                System.out.println("Novo choice encontrado..");

                tipo = "choice";
                notificacaoID = getID(tipo);

                break;
            case Module.DATA:
                System.out.println("Novo data encontrado..");

                tipo = "data";
                notificacaoID = getID(tipo);

                break;
            case Module.FORUM:
                System.out.println("Novo forum encontrado..");

                tipo = "forum";
                notificacaoID = getID(tipo);

                break;
            case Module.GLOSSARY:
                System.out.println("Novo glossary encontrado..");

                tipo = "glossary";
                notificacaoID = getID(tipo);

                break;
//                    case Module.HOTPOT:
//                        tipo = "hotpot";
//                        notificacaoID = getIDNotificacao(tipo);
//                        salvarEvento(LogID, notificacaoID, time);
//                        break;
//                    case Module.JOURNAL:
//                        tipo = "journal";
//                        notificacaoID = getIDNotificacao(tipo);
//                        salvarEvento(LogID, notificacaoID, time);
//                        break;
            case Module.LABEL:
                System.out.println("Novo label encontrado..");

                tipo = "label";
                notificacaoID = getID(tipo);

                break;
//                    case Module.LAMS:
//                        tipo = "lams";
//                        notificacaoID = getIDNotificacao(tipo);
//                        salvarEvento(LogID, notificacaoID, time);
//                        break;
            case Module.LESSON:
                System.out.println("Novo lesson encontrado..");

                tipo = "lesson";
                notificacaoID = getID(tipo);

                break;
            case Module.QUIZ:
                System.out.println("Novo quiz encontrado..");

                tipo = "quiz";
                notificacaoID = getID(tipo);

                break;
            case Module.RESOURCE:
                System.out.println("Novo resource encontrado..");

                Long ResourceID = Long.valueOf(Info);
                String resourceType = getResourceType(ResourceID);
                notificacaoID = getID(resourceType);

                break;
            case Module.SCORM:
                System.out.println("Novo scorm encontrado..");

                tipo = "scorm";
                notificacaoID = getID(tipo);

                break;
            case Module.SURVEY:
                System.out.println("Novo survey encontrado..");

                tipo = "survey";
                notificacaoID = getID(tipo);

                break;
            case Module.WIKI:
                System.out.println("Novo wiki encontrado..");

                tipo = "wiki";
                notificacaoID = getID(tipo);

                break;
//                    case Module.WORKSHOP:
//                        tipo = "workshop";
//                        notificacaoID = getIDNotificacao(tipo);
//                        salvarEvento(LogID, notificacaoID, time);
//                        break;
            default:
                System.out.println("Evento não classificado: " + ModuloID);
                break;
        }
        return notificacaoID;
    }

    private void salvarEvento(Long LogID, Long notificacaoID, Long time) throws Exception {
        MdlAlertameEventos evento = new MdlAlertameEventos();
        evento.setLogid(LogID);
        evento.setNotificacaoid(notificacaoID);
        evento.setCriacao(time);
        evento.setViewed(false);

        Persistence.salvar(evento);
        System.out.println("[" + myAgent.getLocalName() + "]: " + evento.toString());
    }

    private Long getID(String assignmenttype) throws Exception {

        Long NotificacaoID = new Long(0);

        String HQL = "FROM MdlAlertameNotificacao an WHERE an.tipo ='" + assignmenttype + "'";
        List<MdlAlertameNotificacao> Nofiticacao = Persistence.Listar(HQL);

        if (!Nofiticacao.isEmpty()) {
            MdlAlertameNotificacao noticacao = Nofiticacao.get(LAST_INDEX);
            NotificacaoID = noticacao.getId();
        }

        return NotificacaoID;
    }

    private String getAssignmentType(Long AssignmentID) throws Exception {
        System.out.println("Long AssignmentoID: " + AssignmentID);
        MdlAssignment Assignment = (MdlAssignment) Persistence.carregar(AssignmentID, MdlAssignment.class);
        String assignmenttype = Assignment.getAssignmenttype();
        return assignmenttype;
    }

    private String getResourceType(Long ResourceID) throws Exception {
        MdlResource Resource = (MdlResource) Persistence.carregar(ResourceID, MdlResource.class);
        String ResourceType = Resource.getType();
        return ResourceType;
    }

    private Long getUltimoIndiceEventos() throws Exception {
        //na hora que for rodar o sistema no NEAD
        //colocar o ultimo indice da tabela mdl_log
        Long UltimoIndex = new Long(0);

        String HQL = "FROM MdlAlertameEventos ae ORDER BY ae.logid DESC LIMIT 0,1";
        List<MdlAlertameEventos> Eventos = Persistence.Listar(HQL);

        if (!Eventos.isEmpty()) {
            MdlAlertameEventos UltimoEvento = Eventos.get(LAST_INDEX);
            UltimoIndex = UltimoEvento.getLogid();
            return UltimoIndex;
        } else {
            return UltimoIndex;
        }


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
