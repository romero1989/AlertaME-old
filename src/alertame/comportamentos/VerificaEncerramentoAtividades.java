/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package alertame.comportamentos;

import alertame.moodle.*;
import alertame.utils.*;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;
import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Alert@ME
 */
public class VerificaEncerramentoAtividades extends OneShotBehaviour {

    public VerificaEncerramentoAtividades(Agent a) {
        super(a);

    }

    @Override
    public void action() {
        try {

            //recupera os alertames associados aos cursos
            List<MdlAlertame> AlertaMEList = getInstanciasAlertaME();
            boolean empty = AlertaMEList.isEmpty();

            if (!empty) {

                for (MdlAlertame alertame : AlertaMEList) {

                    long course = alertame.getCourse();

                    String HQL = "SELECT a FROM MdlAlertameAtividades as a WHERE a.curso = '" + course + "' AND a.visivel = '1'";
                    //List<MdlAlertameAtividades> AtividadesLista = HibernateUtil.getSessionFactory().openSession().createCriteria(MdlAlertameAtividades.class).add(Restrictions.eq("curso", course)).add(Restrictions.eq("visivel", 1)).list();
                    List<MdlAlertameAtividades> AtividadesLista = Persistence.Listar(HQL);

                    boolean isEmptyAtividades = AtividadesLista.isEmpty();

                    if (!isEmptyAtividades) {

                        MdlCourse Curso = (MdlCourse) Persistence.carregar(course, MdlCourse.class);

                        String CourseName = Curso.getFullname();

                        for (MdlAlertameAtividades atividade : AtividadesLista) {

                            Long encerramento = atividade.getEncerramento();
                            //Long cmid = atividade.getCmid();
                            String NomeAtividade = atividade.getNome();

                            //se a atividade tiver um horario de fechamento
                            if (encerramento > 0) {
                                String mensagem = "Alert@ME Informa: Falta";

                                //converter o dado para um objeto do tipo date
                                Date d = new Date(encerramento * 1000);

                                //converte para um objeto gregorian calendar
                                GregorianCalendar tempo_atividade = new GregorianCalendar();

                                //seta o horario em millisegundos
                                tempo_atividade.setTimeInMillis(d.getTime());

                                //imprime
                                System.out.println(tempo_atividade.toString());

                                //recupera o instante de tempo em que o sistema esta executando
                                long currentTimeMillis = System.currentTimeMillis();
                                Date d2 = new Date(currentTimeMillis);

                                GregorianCalendar tempo_agora = new GregorianCalendar();
                                tempo_agora.setTimeInMillis(d2.getTime());

                                System.out.println(tempo_agora.toString());


                                //faz a diferença de tempo entre os dois horarios
                                long differenceMilliSeconds = d.getTime() - d2.getTime();


                                //calcula a diferente em dias, horas e segundos
                                long dias = (differenceMilliSeconds / 1000 / 60 / 60 / 24);
                                long horas = (differenceMilliSeconds / 1000 / 60 / 60) - (dias * 24);
                                long minutos = (differenceMilliSeconds / 1000 / 60) - (horas * 60) - (dias * 24 * 60);
                                Long EncerramentoID;

                                //imprime a diferença
                                System.out.println("diferenca em dias: " + dias);
                                System.out.println("diferenca em horas: " + horas);
                                System.out.println("diferenca em minutos: " + minutos);


                                //se ainda nao passou da data e horarios da atividade
                                if (tempo_agora.before(tempo_atividade)) {


                                    //se tiver faltando 7 dias
                                    if (dias == DIA.SETE_DIAS) {

                                        List<MdlAlertameEncerramento> Listar = Persistence.Listar("FROM MdlAlertameEncerramento WHERE notificacaoid=" + PRAZO.ENC_7_DIAS + " and atividade=" + atividade.getId() + "");
                                        boolean empty1 = Listar.isEmpty();

                                        if (empty1) {
                                            EncerramentoID = salvarLogPrazos(atividade, PRAZO.ENC_7_DIAS);


                                            if (atividade.getModulo() == Module.CHAT) {
                                                mensagem += " 7 dias";
                                                mensagem += (horas == 1) ? " " + horas + " hora " : " " + horas + " horas";
                                                mensagem += (minutos == 1) ? " e " + minutos + " minuto " : " e " + minutos + " minutos";
                                                mensagem += " para acontecer o chat: " + NomeAtividade + " do curso: " + CourseName + ".";
                                            } else {
                                                mensagem += " 7 dias";
                                                mensagem += (horas == 1) ? " " + horas + " hora " : " " + horas + " horas";
                                                mensagem += (minutos == 1) ? " e " + minutos + " minuto " : " e " + minutos + " minutos";
                                                mensagem += " para encerrar a atividade: " + NomeAtividade + " do curso: " + CourseName + ".";
                                            }

                                            salvarMensagem(mensagem, PRAZO.ENC_7_DIAS, EncerramentoID, course, encerramento);

                                        }



                                        //se tiver faltando 3 dias
                                    } else if (dias == DIA.TRES_DIAS) {
                                        List<MdlAlertameEncerramento> Listar = Persistence.Listar("FROM MdlAlertameEncerramento WHERE notificacaoid=" + PRAZO.ENC_3_DIAS + " and atividade=" + atividade.getId() + "");
                                        boolean empty1 = Listar.isEmpty();

                                        if (empty1) {
                                            EncerramentoID = salvarLogPrazos(atividade, PRAZO.ENC_3_DIAS);

                                            if (atividade.getModulo() == Module.CHAT) {
                                                mensagem += " 3 dias";
                                                mensagem += (horas == 1) ? " " + horas + " hora " : " " + horas + " horas";
                                                mensagem += (minutos == 1) ? " e " + minutos + " minuto " : " e " + minutos + " minutos";
                                                mensagem += " para acontecer o chat: " + NomeAtividade + " do curso: " + CourseName + ".";
                                            } else {
                                                mensagem += " 3 dias";
                                                mensagem += (horas == 1) ? " " + horas + " hora " : " " + horas + " horas";
                                                mensagem += (minutos == 1) ? " e " + minutos + " minuto " : " e " + minutos + " minutos";
                                                mensagem += " para encerrar a atividade: " + NomeAtividade + " do curso: " + CourseName + ".";
                                            }

                                            salvarMensagem(mensagem, PRAZO.ENC_3_DIAS, EncerramentoID, course, encerramento);

                                        }

                                        //se tiver faltando um dia, ou seja, no dia anterior.
                                    } else if (dias == DIA.UM_DIA) {
                                        List<MdlAlertameEncerramento> Listar = Persistence.Listar("FROM MdlAlertameEncerramento WHERE notificacaoid=" + PRAZO.ENC_1_DIA + " and atividade=" + atividade.getId() + "");
                                        boolean empty1 = Listar.isEmpty();

                                        if (empty1) {
                                            EncerramentoID = salvarLogPrazos(atividade, PRAZO.ENC_1_DIA);

                                            if (atividade.getModulo() == Module.CHAT) {
                                                mensagem += " 1 dia";
                                                mensagem += (horas == 1) ? " " + horas + " hora " : " " + horas + " horas";
                                                mensagem += (minutos == 1) ? " e " + minutos + " minuto " : " e " + minutos + " minutos";
                                                mensagem += " para acontecer o chat: " + NomeAtividade + " do curso: " + CourseName + ".";
                                            } else {
                                                mensagem += " 1 dia";
                                                mensagem += (horas == 1) ? " " + horas + " hora " : " " + horas + " horas";
                                                mensagem += (minutos == 1) ? " e " + minutos + " minuto " : " e " + minutos + " minutos";
                                                mensagem += " para encerrar a atividade: " + NomeAtividade + " do curso: " + CourseName + ".";
                                            }

                                            salvarMensagem(mensagem, PRAZO.ENC_1_DIA, EncerramentoID, course, encerramento);

                                        }

                                    } else if (dias == DIA.NO_DIA) {

                                        //verifica se ainda há horas e minutos para o encerramento da atividade
                                        if (horas > 0) {

                                            mensagem += "Alert@ME Informa: ";
                                            List<MdlAlertameEncerramento> Listar = Persistence.Listar("FROM MdlAlertameEncerramento WHERE notificacaoid=" + PRAZO.ENC_NO_DIA + " and atividade=" + atividade.getId() + "");
                                            boolean empty1 = Listar.isEmpty();

                                            if (empty1) {
                                                EncerramentoID = salvarLogPrazos(atividade, PRAZO.ENC_NO_DIA);
                                                if (atividade.getModulo() == Module.CHAT) {
                                                    mensagem = "Daqui a ";
                                                    mensagem += (horas == 1) ? " " + horas + " hora" : " " + horas + " horas";
                                                    mensagem += (minutos == 1) ? " e " + minutos + " minuto " : " e " + minutos + " minutos";
                                                    mensagem += " acontecerá o chat: " + NomeAtividade + " do curso: " + CourseName + ".";
                                                } else {
                                                    mensagem = "Daqui a ";
                                                    mensagem += (horas == 1) ? " " + horas + " hora" : " " + horas + " horas";
                                                    mensagem += (minutos == 1) ? " e " + minutos + " minuto " : " e " + minutos + " minutos";
                                                    mensagem += " encerra a atividade: " + NomeAtividade + " do curso: " + CourseName + ".";
                                                }


                                                salvarMensagem(mensagem, PRAZO.ENC_NO_DIA, EncerramentoID, course, encerramento);

                                            }


                                        }

                                        //se ja passou do dia
                                    } else if (tempo_agora.after(tempo_atividade)) {
                                        System.out.println("Ja passou... ");

                                        //verifica se a atividade encerra hoje (se o tempo da execução do sistema estiver na data de encerramento da atividade)

                                        List<MdlAlertameEncerramento> Listar = Persistence.Listar("FROM MdlAlertameEncerramento WHERE notificacaoid=" + PRAZO.ENCERROU + " and atividade=" + atividade.getId() + "");
                                        boolean empty1 = Listar.isEmpty();

                                        if (empty1) {
                                            EncerramentoID = salvarLogPrazos(atividade, PRAZO.ENCERROU);

                                            mensagem = " A atividade: " + NomeAtividade + " do curso: " + CourseName + ", encerrou.";

                                            salvarMensagem(mensagem, PRAZO.ENCERROU, EncerramentoID, course, encerramento);

                                        }

                                    }
                                }
                            }
                        }

                        comunicarAgente("Carteiro", "news", ACLMessage.INFORM);
                    }


                }


            } else {
                block();
                System.out.println("Não há instâncias de AlertaME para serem monitoradas!");
            }

        } catch (Exception ex) {
            MailUtil.sendEmailError(ex);
            Logger.getLogger(VerificaEncerramentoAtividades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Long salvarLogPrazos(MdlAlertameAtividades atividade, int NotificacaoID) throws Exception {
        MdlAlertameEncerramento atividadeEncerramento = new MdlAlertameEncerramento();
        atividadeEncerramento.setAtividade(atividade.getId());
        atividadeEncerramento.setNotificacaoid(new Long(NotificacaoID));

        Persistence.salvar(atividadeEncerramento);
        Long id = atividadeEncerramento.getId();
        return id;
    }

    private void salvarMensagem(String mensagem, Integer NotificacaoID, Long atividadeID, Long course, Long encerramento) throws Exception {
        String HQL = "FROM MdlAlertameInteresses i WHERE i.notificacaoid=" + NotificacaoID + " AND course =" + course;
        List<MdlAlertameInteresses> Interessados = Persistence.Listar(HQL);

        for (MdlAlertameInteresses interessado : Interessados) {

            Long inicio = interessado.getInicio();

            if (inicio < encerramento) {
                Long UserID = interessado.getUserid();

                MdlAlertameEnviados SMS = new MdlAlertameEnviados();
                SMS.setEventoid(atividadeID);
                SMS.setTransmitido(new Long(0));
                SMS.setUserid(UserID);
                SMS.setMensagem(mensagem);
                SMS.setTipo("encerramento");
                Persistence.salvar(SMS);
            }

        }
    }

    private List<MdlAlertame> getInstanciasAlertaME() throws Exception {
        List<MdlAlertame> AlertaMEList = Persistence.Listar("select al from MdlAlertame al");
        return AlertaMEList;
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
