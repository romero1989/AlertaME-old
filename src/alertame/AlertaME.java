package alertame;

import alertame.utils.Module;
import java.util.Date;

/**
 * @author RomeroGomes
 */
public class AlertaME {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

//        String HQL = "FROM MdlLog ae ORDER BY ae.id DESC LIMIT 0,1";
//        List<MdlLog> Eventos = Persistence.Listar(HQL);
//        if (Eventos.isEmpty()) {
//            System.out.println("Empty");
//        } else {
//            MdlLog Ultimo = Eventos.get(0);
//            Long LastLog = Ultimo.getId();
//
//            System.out.println("Last: " + LastLog);
//        }
//        
//        long time = 1372466741;
//        Date d = new java.sql.Date(time * 1000);
//        
//        System.out.println(""+d.toLocaleString());
//        
//        System.out.println(""+Module.getModuloID("CHAT"));
        double a = Math.toRadians(60.0);
        double b = Math.toRadians(45.0);
        double c = Math.toRadians(30.0);
        
        System.out.println(""+(a+1.5708));    
        System.out.println(""+(b+1.5708));
        System.out.println(""+(c+1.5708));
    }
}
