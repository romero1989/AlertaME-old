package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlContextTemp generated by hbm2java
 */
public class MdlContextTemp  implements java.io.Serializable {


     private long id;
     private String path;
     private byte depth;

    public MdlContextTemp() {
    }

    public MdlContextTemp(long id, String path, byte depth) {
       this.id = id;
       this.path = path;
       this.depth = depth;
    }
   
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    public String getPath() {
        return this.path;
    }
    
    public void setPath(String path) {
        this.path = path;
    }
    public byte getDepth() {
        return this.depth;
    }
    
    public void setDepth(byte depth) {
        this.depth = depth;
    }




}

