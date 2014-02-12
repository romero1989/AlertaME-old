package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlGroups generated by hbm2java
 */
public class MdlGroups  implements java.io.Serializable {


     private Long id;
     private long courseid;
     private String name;
     private String description;
     private String enrolmentkey;
     private long picture;
     private boolean hidepicture;
     private long timecreated;
     private long timemodified;

    public MdlGroups() {
    }

	
    public MdlGroups(long courseid, String name, long picture, boolean hidepicture, long timecreated, long timemodified) {
        this.courseid = courseid;
        this.name = name;
        this.picture = picture;
        this.hidepicture = hidepicture;
        this.timecreated = timecreated;
        this.timemodified = timemodified;
    }
    public MdlGroups(long courseid, String name, String description, String enrolmentkey, long picture, boolean hidepicture, long timecreated, long timemodified) {
       this.courseid = courseid;
       this.name = name;
       this.description = description;
       this.enrolmentkey = enrolmentkey;
       this.picture = picture;
       this.hidepicture = hidepicture;
       this.timecreated = timecreated;
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
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public String getEnrolmentkey() {
        return this.enrolmentkey;
    }
    
    public void setEnrolmentkey(String enrolmentkey) {
        this.enrolmentkey = enrolmentkey;
    }
    public long getPicture() {
        return this.picture;
    }
    
    public void setPicture(long picture) {
        this.picture = picture;
    }
    public boolean isHidepicture() {
        return this.hidepicture;
    }
    
    public void setHidepicture(boolean hidepicture) {
        this.hidepicture = hidepicture;
    }
    public long getTimecreated() {
        return this.timecreated;
    }
    
    public void setTimecreated(long timecreated) {
        this.timecreated = timecreated;
    }
    public long getTimemodified() {
        return this.timemodified;
    }
    
    public void setTimemodified(long timemodified) {
        this.timemodified = timemodified;
    }




}

