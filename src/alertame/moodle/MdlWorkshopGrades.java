package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlWorkshopGrades generated by hbm2java
 */
public class MdlWorkshopGrades  implements java.io.Serializable {


     private Long id;
     private long workshopid;
     private long assessmentid;
     private long elementno;
     private String feedback;
     private short grade;

    public MdlWorkshopGrades() {
    }

    public MdlWorkshopGrades(long workshopid, long assessmentid, long elementno, String feedback, short grade) {
       this.workshopid = workshopid;
       this.assessmentid = assessmentid;
       this.elementno = elementno;
       this.feedback = feedback;
       this.grade = grade;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public long getWorkshopid() {
        return this.workshopid;
    }
    
    public void setWorkshopid(long workshopid) {
        this.workshopid = workshopid;
    }
    public long getAssessmentid() {
        return this.assessmentid;
    }
    
    public void setAssessmentid(long assessmentid) {
        this.assessmentid = assessmentid;
    }
    public long getElementno() {
        return this.elementno;
    }
    
    public void setElementno(long elementno) {
        this.elementno = elementno;
    }
    public String getFeedback() {
        return this.feedback;
    }
    
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
    public short getGrade() {
        return this.grade;
    }
    
    public void setGrade(short grade) {
        this.grade = grade;
    }




}

