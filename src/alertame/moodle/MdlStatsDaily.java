package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlStatsDaily generated by hbm2java
 */
public class MdlStatsDaily  implements java.io.Serializable {


     private Long id;
     private long courseid;
     private long timeend;
     private long roleid;
     private String stattype;
     private long stat1;
     private long stat2;

    public MdlStatsDaily() {
    }

    public MdlStatsDaily(long courseid, long timeend, long roleid, String stattype, long stat1, long stat2) {
       this.courseid = courseid;
       this.timeend = timeend;
       this.roleid = roleid;
       this.stattype = stattype;
       this.stat1 = stat1;
       this.stat2 = stat2;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public long getCourseid() {
        return this.courseid;
    }
    
    public void setCourseid(long courseid) {
        this.courseid = courseid;
    }
    public long getTimeend() {
        return this.timeend;
    }
    
    public void setTimeend(long timeend) {
        this.timeend = timeend;
    }
    public long getRoleid() {
        return this.roleid;
    }
    
    public void setRoleid(long roleid) {
        this.roleid = roleid;
    }
    public String getStattype() {
        return this.stattype;
    }
    
    public void setStattype(String stattype) {
        this.stattype = stattype;
    }
    public long getStat1() {
        return this.stat1;
    }
    
    public void setStat1(long stat1) {
        this.stat1 = stat1;
    }
    public long getStat2() {
        return this.stat2;
    }
    
    public void setStat2(long stat2) {
        this.stat2 = stat2;
    }




}


