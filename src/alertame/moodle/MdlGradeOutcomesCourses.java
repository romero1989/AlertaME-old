package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlGradeOutcomesCourses generated by hbm2java
 */
public class MdlGradeOutcomesCourses  implements java.io.Serializable {


     private Long id;
     private long courseid;
     private long outcomeid;

    public MdlGradeOutcomesCourses() {
    }

    public MdlGradeOutcomesCourses(long courseid, long outcomeid) {
       this.courseid = courseid;
       this.outcomeid = outcomeid;
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
    public long getOutcomeid() {
        return this.outcomeid;
    }
    
    public void setOutcomeid(long outcomeid) {
        this.outcomeid = outcomeid;
    }




}

