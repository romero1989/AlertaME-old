/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package alertame.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.smslib.AGateway;
import org.smslib.IOutboundMessageNotification;
import org.smslib.Library;
import org.smslib.Message;
import org.smslib.OutboundMessage;
import org.smslib.SMSLibException;
import org.smslib.Service;
import org.smslib.helper.CommPortIdentifier;
import org.smslib.helper.SerialPort;
import org.smslib.modem.SerialModemGateway;

/**
 *
 * @author RomeroGomes
 */
public final class SMSUtil {

    private final String _NO_DEVICE_FOUND = "  no device found";
    private final Formatter _formatter = new Formatter(System.out);
    static CommPortIdentifier portId;
    private static Service Gateway;
    static Enumeration<CommPortIdentifier> portList;
    static int bauds[] = {9600, 14400, 19200, 28800, 33600, 38400, 56000, 57600, 115200};
    private static final SMSUtil instance = new SMSUtil();

    private SMSUtil() {
        startContext();
    }

    public static SMSUtil getInstance() {
        return instance;
    }

    private void startContext() {
        String portToConnection = getPortToConnection();
        String[] split = portToConnection.split(":");

        String porta = split[0];
        String velocidade = split[1];

        Gateway = EstabelecerConexao(porta, velocidade);
        if (Gateway != null) {
            System.out.println("Conexão estabelecida com sucesso!");
        } else {
            MailUtil.sendEmailError("Erro ao conectar o Modem 3G");
            System.out.println("Erro na conexão!!!");
        }

    }

    /**
     * Wrapper around {@link CommPortIdentifier#getPortIdentifiers()} to be
     * avoid unchecked warnings.
     */
    private Enumeration<CommPortIdentifier> getCleanPortIdentifiers() {
        return CommPortIdentifier.getPortIdentifiers();
    }

    private String getPortToConnection() {
        String porta = "ERROR";
        System.out.println("\nSearching for devices...");
        portList = getCleanPortIdentifiers();

        while (portList.hasMoreElements()) {
            portId = portList.nextElement();
            if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                _formatter.format("%nFound port: %-5s%n", portId.getName());
                for (int i = 0; i < bauds.length; i++) {
                    SerialPort serialPort = null;
                    _formatter.format("       Trying at %6d...", bauds[i]);
                    try {
                        InputStream inStream;
                        OutputStream outStream;
                        int c;
                        String response;
                        serialPort = portId.open("SMSLibCommTester", 1971);
                        serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_RTSCTS_IN);
                        serialPort.setSerialPortParams(bauds[i], SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
                        inStream = serialPort.getInputStream();
                        outStream = serialPort.getOutputStream();
                        serialPort.enableReceiveTimeout(1000);
                        c = inStream.read();
                        while (c != -1) {
                            c = inStream.read();
                        }
                        outStream.write('A');
                        outStream.write('T');
                        outStream.write('\r');
                        Thread.sleep(1000);
                        response = "";
                        StringBuilder sb = new StringBuilder();
                        c = inStream.read();
                        while (c != -1) {
                            sb.append((char) c);
                            c = inStream.read();
                        }
                        response = sb.toString();
                        if (response.indexOf("OK") >= 0) {
                            try {
                                System.out.print("  Getting Info...");
                                outStream.write('A');
                                outStream.write('T');
                                outStream.write('+');
                                outStream.write('C');
                                outStream.write('G');
                                outStream.write('M');
                                outStream.write('M');
                                outStream.write('\r');
                                response = "";
                                c = inStream.read();
                                while (c != -1) {
                                    response += (char) c;
                                    c = inStream.read();
                                }
                                System.out.println(" Found: " + response.replaceAll("\\s+OK\\s+", "").replaceAll("\n", "").replaceAll("\r", ""));
                            } catch (Exception e) {
                                System.out.println(_NO_DEVICE_FOUND);
                            }
                        } else {
                            System.out.println(_NO_DEVICE_FOUND);
                        }
                    } catch (Exception e) {
                        MailUtil.sendEmailError(e);
                        System.out.print(_NO_DEVICE_FOUND);
                        Throwable cause = e;
                        while (cause.getCause() != null) {
                            cause = cause.getCause();
                        }
                        System.out.println(" (" + cause.getMessage() + ")");
                        return porta;
                    } finally {
                        if (serialPort != null) {
                            porta = portId.getName() + ":" + bauds[i];
                            serialPort.close();
                        }
                    }
                }
            }
        }
        System.out.println("\nTest complete.");
        return porta;
    }

    private Service EstabelecerConexao(String port, String baud) {

        try {
            OutboundNotification outboundNotification = new OutboundNotification();

            System.out.println("Port1: " + port);
            System.out.println("Baud1: " + baud);

            System.out.println("Port2: " + "\"" + port + "\"");
            System.out.println("Baud2: " + "\"" + baud + "\"");

            System.out.println("Estabalecendo Conexao com o Modem...  Aguarde um momento!");
            System.out.println(Library.getLibraryDescription());

            //SerialModemGateway gateway = new SerialModemGateway("\"" + port + "\"", "\"" + port + "\"", Integer.valueOf(baud), "Huawei", "E226");
            SerialModemGateway gateway = new SerialModemGateway(port, port, Integer.valueOf(baud), "Huawei", "E226");
            gateway.setInbound(true);
            gateway.setOutbound(true);
            gateway.setSimPin("0000");

            Service.getInstance().setOutboundMessageNotification(outboundNotification);
            Service.getInstance().addGateway(gateway);
            Service.getInstance().startService();

            System.out.println("Service Status: " + Service.getInstance().getServiceStatus());

            System.out.println("Conexao estabelecida com sucesso!");
            System.out.println();
            System.out.println("Modem Information:");
            System.out.println("  Manufacturer: " + gateway.getManufacturer());
            System.out.println("  Model: " + gateway.getModel());
            System.out.println("  Serial No: " + gateway.getSerialNo());
            System.out.println("  SIM IMSI: " + gateway.getImsi());
            System.out.println("  Signal Level: " + gateway.getSignalLevel() + " dBm");
            System.out.println("  Battery Level: " + gateway.getBatteryLevel() + "%");
            System.out.println();

            return Service.getInstance();
        } catch (SMSLibException ex) {
            MailUtil.sendEmailError(ex);
            Logger.getLogger(SMSUtil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (IOException ex) {
            MailUtil.sendEmailError(ex);
            Logger.getLogger(SMSUtil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (InterruptedException ex) {
            MailUtil.sendEmailError(ex);
            Logger.getLogger(SMSUtil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public OutboundMessage sendMessage(String numero, String sms) throws Exception {
        OutboundMessage msg = new OutboundMessage("55" + numero, sms);
        msg.setEncoding(Message.MessageEncodings.ENCUCS2);
        Gateway.sendMessage(msg);
        System.out.println(msg);
        
        System.out.println("Status: " + msg.getMessageStatus().name());
        String status = msg.getMessageStatus().name();
        return msg;
        //Service.getInstance().stopService();
    }

    public class OutboundNotification implements IOutboundMessageNotification {

        public void process(AGateway gateway, OutboundMessage msg) {
            System.out.println("Outbound handler called from Gateway: " + gateway.getGatewayId());
            System.out.println(msg);
        }
    }
}
