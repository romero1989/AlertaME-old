package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlGradeSettings generated by hbm2java
 */
public class MdlGradeSettings  implements java.io.Serializable {


     private Long id;
     private long courseid;
     private String name;
     private String value;

    public MdlGradeSettings() {
    }

	
    public MdlGradeSettings(long courseid, String name) {
        this.courseid = courseid;
        this.name = name;
    }
    public MdlGradeSettings(long courseid, String name, String value) {
       this.courseid = courseid;
       this.name = name;
       this.value = value;
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
    public String getValue() {
        return this.value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }




}


