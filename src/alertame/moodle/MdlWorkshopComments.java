package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlWorkshopComments generated by hbm2java
 */
public class MdlWorkshopComments  implements java.io.Serializable {


     private Long id;
     private long workshopid;
     private long assessmentid;
     private long userid;
     private long timecreated;
     private byte mailed;
     private String comments;

    public MdlWorkshopComments() {
    }

    public MdlWorkshopComments(long workshopid, long assessmentid, long userid, long timecreated, byte mailed, String comments) {
       this.workshopid = workshopid;
       this.assessmentid = assessmentid;
       this.userid = userid;
       this.timecreated = timecreated;
       this.mailed = mailed;
       this.comments = comments;
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
    public long getUserid() {
        return this.userid;
    }
    
    public void setUserid(long userid) {
        this.userid = userid;
    }
    public long getTimecreated() {
        return this.timecreated;
    }
    
    public void setTimecreated(long timecreated) {
        this.timecreated = timecreated;
    }
    public byte getMailed() {
        return this.mailed;
    }
    
    public void setMailed(byte mailed) {
        this.mailed = mailed;
    }
    public String getComments() {
        return this.comments;
    }
    
    public void setComments(String comments) {
        this.comments = comments;
    }




}


