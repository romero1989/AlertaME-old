package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlWorkshopSubmissions generated by hbm2java
 */
public class MdlWorkshopSubmissions  implements java.io.Serializable {


     private Long id;
     private long workshopid;
     private long userid;
     private String title;
     private long timecreated;
     private byte mailed;
     private String description;
     private short gradinggrade;
     private short finalgrade;
     private short late;
     private long nassessments;

    public MdlWorkshopSubmissions() {
    }

    public MdlWorkshopSubmissions(long workshopid, long userid, String title, long timecreated, byte mailed, String description, short gradinggrade, short finalgrade, short late, long nassessments) {
       this.workshopid = workshopid;
       this.userid = userid;
       this.title = title;
       this.timecreated = timecreated;
       this.mailed = mailed;
       this.description = description;
       this.gradinggrade = gradinggrade;
       this.finalgrade = finalgrade;
       this.late = late;
       this.nassessments = nassessments;
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
    public long getUserid() {
        return this.userid;
    }
    
    public void setUserid(long userid) {
        this.userid = userid;
    }
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
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
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public short getGradinggrade() {
        return this.gradinggrade;
    }
    
    public void setGradinggrade(short gradinggrade) {
        this.gradinggrade = gradinggrade;
    }
    public short getFinalgrade() {
        return this.finalgrade;
    }
    
    public void setFinalgrade(short finalgrade) {
        this.finalgrade = finalgrade;
    }
    public short getLate() {
        return this.late;
    }
    
    public void setLate(short late) {
        this.late = late;
    }
    public long getNassessments() {
        return this.nassessments;
    }
    
    public void setNassessments(long nassessments) {
        this.nassessments = nassessments;
    }




}


