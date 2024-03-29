package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlGradeOutcomesHistory generated by hbm2java
 */
public class MdlGradeOutcomesHistory  implements java.io.Serializable {


     private Long id;
     private long action;
     private long oldid;
     private String source;
     private Long timemodified;
     private Long loggeduser;
     private Long courseid;
     private String shortname;
     private String fullname;
     private Long scaleid;
     private String description;

    public MdlGradeOutcomesHistory() {
    }

	
    public MdlGradeOutcomesHistory(long action, long oldid, String shortname, String fullname) {
        this.action = action;
        this.oldid = oldid;
        this.shortname = shortname;
        this.fullname = fullname;
    }
    public MdlGradeOutcomesHistory(long action, long oldid, String source, Long timemodified, Long loggeduser, Long courseid, String shortname, String fullname, Long scaleid, String description) {
       this.action = action;
       this.oldid = oldid;
       this.source = source;
       this.timemodified = timemodified;
       this.loggeduser = loggeduser;
       this.courseid = courseid;
       this.shortname = shortname;
       this.fullname = fullname;
       this.scaleid = scaleid;
       this.description = description;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public long getAction() {
        return this.action;
    }
    
    public void setAction(long action) {
        this.action = action;
    }
    public long getOldid() {
        return this.oldid;
    }
    
    public void setOldid(long oldid) {
        this.oldid = oldid;
    }
    public String getSource() {
        return this.source;
    }
    
    public void setSource(String source) {
        this.source = source;
    }
    public Long getTimemodified() {
        return this.timemodified;
    }
    
    public void setTimemodified(Long timemodified) {
        this.timemodified = timemodified;
    }
    public Long getLoggeduser() {
        return this.loggeduser;
    }
    
    public void setLoggeduser(Long loggeduser) {
        this.loggeduser = loggeduser;
    }
    public Long getCourseid() {
        return this.courseid;
    }
    
    public void setCourseid(Long courseid) {
        this.courseid = courseid;
    }
    public String getShortname() {
        return this.shortname;
    }
    
    public void setShortname(String shortname) {
        this.shortname = shortname;
    }
    public String getFullname() {
        return this.fullname;
    }
    
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public Long getScaleid() {
        return this.scaleid;
    }
    
    public void setScaleid(Long scaleid) {
        this.scaleid = scaleid;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }




}


