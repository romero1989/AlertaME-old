package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlScale generated by hbm2java
 */
public class MdlScale  implements java.io.Serializable {


     private Long id;
     private long courseid;
     private long userid;
     private String name;
     private String scale;
     private String description;
     private long timemodified;

    public MdlScale() {
    }

    public MdlScale(long courseid, long userid, String name, String scale, String description, long timemodified) {
       this.courseid = courseid;
       this.userid = userid;
       this.name = name;
       this.scale = scale;
       this.description = description;
       this.timemodified = timemodified;
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
    public long getTimemodified() {
        return this.timemodified;
    }
    
    public void setTimemodified(long timemodified) {
        this.timemodified = timemodified;
    }




}


