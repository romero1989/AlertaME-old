package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlRoleNames generated by hbm2java
 */
public class MdlRoleNames  implements java.io.Serializable {


     private Long id;
     private long roleid;
     private long contextid;
     private String name;

    public MdlRoleNames() {
    }

    public MdlRoleNames(long roleid, long contextid, String name) {
       this.roleid = roleid;
       this.contextid = contextid;
       this.name = name;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public long getRoleid() {
        return this.roleid;
    }
    
    public void setRoleid(long roleid) {
        this.roleid = roleid;
    }
    public long getContextid() {
        return this.contextid;
    }
    
    public void setContextid(long contextid) {
        this.contextid = contextid;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }




}

