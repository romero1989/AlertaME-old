package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlRoleAllowAssign generated by hbm2java
 */
public class MdlRoleAllowAssign  implements java.io.Serializable {


     private Long id;
     private long roleid;
     private long allowassign;

    public MdlRoleAllowAssign() {
    }

    public MdlRoleAllowAssign(long roleid, long allowassign) {
       this.roleid = roleid;
       this.allowassign = allowassign;
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
    public long getAllowassign() {
        return this.allowassign;
    }
    
    public void setAllowassign(long allowassign) {
        this.allowassign = allowassign;
    }




}


