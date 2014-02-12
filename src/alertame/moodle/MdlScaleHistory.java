package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlScaleHistory generated by hbm2java
 */
public class MdlScaleHistory  implements java.io.Serializable {


     private Long id;
     private long action;
     private long oldid;
     private String source;
     private Long timemodified;
     private Long loggeduser;
     private long courseid;
     private long userid;
     private String name;
     private String scale;
     private String description;

    public MdlScaleHistory() {
    }

	
    public MdlScaleHistory(long action, long oldid, long courseid, long userid, String name, String scale, String description) {
        this.action = action;
        this.oldid = oldid;
        this.courseid = courseid;
        this.userid = userid;
        this.name = name;
        this.scale = scale;
        this.description = description;
    }
    public MdlScaleHistory(long action, long oldid, String source, Long timemodified, Long loggeduser, long courseid, long userid, String name, String scale, String description) {
       this.action = action;
       this.oldid = oldid;
       this.source = source;
       this.timemodified = timemodified;
       this.loggeduser = loggeduser;
       this.courseid = courseid;
       this.userid = userid;
       this.name = name;
       this.scale = scale;
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
    public long getCourseid() {
        return this.courseid;
    }
    
    public void setCourseid(long courseid) {
        this.courseid = courseid;
    }
    public long getUserid() {
        return this.userid;
    }
    
    public void setUserid(long userid) {
        this.userid = userid;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getScale() {
        return this.scale;
    }
    
    public void setScale(String scale) {
        this.scale = scale;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }




}

