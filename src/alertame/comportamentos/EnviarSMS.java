/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package alertame.comportamentos;

import alertame.moodle.MdlAlertameEnviados;
import alertame.moodle.MdlUser;
import alertame.utils.MailUtil;
import alertame.utils.Persistence;
import alertame.utils.SMSUtil;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import org.smslib.OutboundMessage;

/**
 *
 * @author Alert@ME
 */
public class EnviarSMS extends OneShotBehaviour {

    public EnviarSMS(Agent a) {
        super(a);
    }

    @Override
    public void action() {
        try {

            TransmitirSMS();

        } catch (Exception ex) {
            MailUtil.sendEmailError(ex);
            Logger.getLogger(EnviarSMS.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void TransmitirSMS() {


        try {
            List<MdlAlertameEnviados> SMSEnviarList = Persistence.Listar("from MdlAlertameEnviados e where e.transmitido = " + 0 + "");
            boolean empty = SMSEnviarList.isEmpty();

            if (!empty) {
                for (MdlAlertameEnviados sms : SMSEnviarList) {
                    try {
                        Long userid = sms.getUserid();
                        String mensagem = sms.getMensagem();
                        MdlUser User = (MdlUser) Persistence.carregar(userid, MdlUser.class);

                        String number = User.getPhone1();
                        String phone1 = User.getPhone1();

                        if (!phone1.equals("")) {
                            if (phone1.contains("(")) {
                                number = User.getPhone1().replaceAll(Pattern.quote("("), "").replaceAll(Pattern.quote(")"), "").replaceAll(Pattern.quote("-"), "").replaceAll(Pattern.quote(" "), "");
                            } else {
                                number = phone1;
                            }
                        } else {
                            String phone2 = User.getPhone2();
                            if (!phone2.equals("")) {
                                if (phone2.contains("(")) {
                                    number = User.getPhone2().replaceAll(Pattern.quote("("), "").replaceAll(Pattern.quote(")"), "").replaceAll(Pattern.quote("-"), "").replaceAll(Pattern.quote(" "), "");
                                } else {
                                    number = phone2;
                                }
                            } else {
                                MailUtil.sendEmailError("Usuario: " + User.toString() + " Sem numero de telefone cadastrado!");
                            }

                        }

                        if (!number.equals("")) {


                            System.out.println("###########################   Number: " + number);

                            OutboundMessage msg = SMSUtil.getInstance().sendMessage(number, mensagem);

                            String status = msg.getMessageStatus().name();

                            if (status.equalsIgnoreCase("SENT")) {
                                long currentTimeMillis = System.currentTimeMillis();
                                sms.setTransmitido(new Long(1));
                                sms.setHorario(currentTimeMillis);

                                Persistence.atualizar(sms);

                            } else if (status.equalsIgnoreCase("FAILED")) {

                                //executar um comportamento que verifica a causa do erro
                                //estudar todos os erros possiveis gerados pelo SMSLib
                                //pra tentar se auto corrigir
                                MailUtil.sendEmailError(msg.toString());
                            }
                        }
                        
                        
                    } catch (Exception ex) {
                        MailUtil.sendEmailError(ex);
                        Logger.getLogger(EnviarSMS.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else {
                System.out.println("Nada a ser enviado!");
                block();
            }
        } catch (Exception ex) {
            MailUtil.sendEmailError(ex);
            Logger.getLogger(EnviarSMS.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
}
