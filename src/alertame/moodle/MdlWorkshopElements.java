package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlWorkshopElements generated by hbm2java
 */
public class MdlWorkshopElements  implements java.io.Serializable {


     private Long id;
     private long workshopid;
     private short elementno;
     private String description;
     private short scale;
     private short maxscore;
     private short weight;
     private double stddev;
     private long totalassessments;

    public MdlWorkshopElements() {
    }

    public MdlWorkshopElements(long workshopid, short elementno, String description, short scale, short maxscore, short weight, double stddev, long totalassessments) {
       this.workshopid = workshopid;
       this.elementno = elementno;
       this.description = description;
       this.scale = scale;
       this.maxscore = maxscore;
       this.weight = weight;
       this.stddev = stddev;
       this.totalassessments = totalassessments;
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
    public short getElementno() {
        return this.elementno;
    }
    
    public void setElementno(short elementno) {
        this.elementno = elementno;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public short getScale() {
        return this.scale;
    }
    
    public void setScale(short scale) {
        this.scale = scale;
    }
    public short getMaxscore() {
        return this.maxscore;
    }
    
    public void setMaxscore(short maxscore) {
        this.maxscore = maxscore;
    }
    public short getWeight() {
        return this.weight;
    }
    
    public void setWeight(short weight) {
        this.weight = weight;
    }
    public double getStddev() {
        return this.stddev;
    }
    
    public void setStddev(double stddev) {
        this.stddev = stddev;
    }
    public long getTotalassessments() {
        return this.totalassessments;
    }
    
    public void setTotalassessments(long totalassessments) {
        this.totalassessments = totalassessments;
    }




}


