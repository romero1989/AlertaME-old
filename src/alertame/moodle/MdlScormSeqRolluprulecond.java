package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlScormSeqRolluprulecond generated by hbm2java
 */
public class MdlScormSeqRolluprulecond  implements java.io.Serializable {


     private Long id;
     private long scoid;
     private long rollupruleid;
     private String operator;
     private String cond;

    public MdlScormSeqRolluprulecond() {
    }

    public MdlScormSeqRolluprulecond(long scoid, long rollupruleid, String operator, String cond) {
       this.scoid = scoid;
       this.rollupruleid = rollupruleid;
       this.operator = operator;
       this.cond = cond;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public long getScoid() {
        return this.scoid;
    }
    
    public void setScoid(long scoid) {
        this.scoid = scoid;
    }
    public long getRollupruleid() {
        return this.rollupruleid;
    }
    
    public void setRollupruleid(long rollupruleid) {
        this.rollupruleid = rollupruleid;
    }
    public String getOperator() {
        return this.operator;
    }
    
    public void setOperator(String operator) {
        this.operator = operator;
    }
    public String getCond() {
        return this.cond;
    }
    
    public void setCond(String cond) {
        this.cond = cond;
    }




}


