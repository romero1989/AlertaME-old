package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlWorkshopStockcomments generated by hbm2java
 */
public class MdlWorkshopStockcomments  implements java.io.Serializable {


     private Long id;
     private long workshopid;
     private long elementno;
     private String comments;

    public MdlWorkshopStockcomments() {
    }

    public MdlWorkshopStockcomments(long workshopid, long elementno, String comments) {
       this.workshopid = workshopid;
       this.elementno = elementno;
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
    public long getElementno() {
        return this.elementno;
    }
    
    public void setElementno(long elementno) {
        this.elementno = elementno;
    }
    public String getComments() {
        return this.comments;
    }
    
    public void setComments(String comments) {
        this.comments = comments;
    }




}

