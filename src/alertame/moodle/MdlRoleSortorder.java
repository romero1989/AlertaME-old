package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlRoleSortorder generated by hbm2java
 */
public class MdlRoleSortorder  implements java.io.Serializable {


     private Long id;
     private long userid;
     private long roleid;
     private long contextid;
     private long sortoder;

    public MdlRoleSortorder() {
    }

    public MdlRoleSortorder(long userid, long roleid, long contextid, long sortoder) {
       this.userid = userid;
       this.roleid = roleid;
       this.contextid = contextid;
       this.sortoder = sortoder;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public long getUserid() {
        return this.userid;
    }
    
    public void setUserid(long userid) {
        this.userid = userid;
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
    public long getSortoder() {
        return this.sortoder;
    }
    
    public void setSortoder(long sortoder) {
        this.sortoder = sortoder;
    }




}


