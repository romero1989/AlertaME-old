package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlContext generated by hbm2java
 */
public class MdlContext  implements java.io.Serializable {


     private Long id;
     private long contextlevel;
     private long instanceid;
     private String path;
     private byte depth;

    public MdlContext() {
    }

	
    public MdlContext(long contextlevel, long instanceid, byte depth) {
        this.contextlevel = contextlevel;
        this.instanceid = instanceid;
        this.depth = depth;
    }
    public MdlContext(long contextlevel, long instanceid, String path, byte depth) {
       this.contextlevel = contextlevel;
       this.instanceid = instanceid;
       this.path = path;
       this.depth = depth;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public long getContextlevel() {
        return this.contextlevel;
    }
    
    public void setContextlevel(long contextlevel) {
        this.contextlevel = contextlevel;
    }
    public long getInstanceid() {
        return this.instanceid;
    }
    
    public void setInstanceid(long instanceid) {
        this.instanceid = instanceid;
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

