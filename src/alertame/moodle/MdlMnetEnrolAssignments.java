package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlMnetEnrolAssignments generated by hbm2java
 */
public class MdlMnetEnrolAssignments  implements java.io.Serializable {


     private Long id;
     private long userid;
     private long hostid;
     private long courseid;
     private String rolename;
     private long enroltime;
     private String enroltype;

    public MdlMnetEnrolAssignments() {
    }

    public MdlMnetEnrolAssignments(long userid, long hostid, long courseid, String rolename, long enroltime, String enroltype) {
       this.userid = userid;
       this.hostid = hostid;
       this.courseid = courseid;
       this.rolename = rolename;
       this.enroltime = enroltime;
       this.enroltype = enroltype;
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
    public long getHostid() {
        return this.hostid;
    }
    
    public void setHostid(long hostid) {
        this.hostid = hostid;
    }
    public long getCourseid() {
        return this.courseid;
    }
    
    public void setCourseid(long courseid) {
        this.courseid = courseid;
    }
    public String getRolename() {
        return this.rolename;
    }
    
    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
    public long getEnroltime() {
        return this.enroltime;
    }
    
    public void setEnroltime(long enroltime) {
        this.enroltime = enroltime;
    }
    public String getEnroltype() {
        return this.enroltype;
    }
    
    public void setEnroltype(String enroltype) {
        this.enroltype = enroltype;
    }




}

