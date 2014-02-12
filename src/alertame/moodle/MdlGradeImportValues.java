package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA


import java.math.BigDecimal;

/**
 * MdlGradeImportValues generated by hbm2java
 */
public class MdlGradeImportValues  implements java.io.Serializable {


     private Long id;
     private Long itemid;
     private Long newgradeitem;
     private long userid;
     private BigDecimal finalgrade;
     private String feedback;
     private long importcode;
     private Long importer;

    public MdlGradeImportValues() {
    }

	
    public MdlGradeImportValues(long userid, long importcode) {
        this.userid = userid;
        this.importcode = importcode;
    }
    public MdlGradeImportValues(Long itemid, Long newgradeitem, long userid, BigDecimal finalgrade, String feedback, long importcode, Long importer) {
       this.itemid = itemid;
       this.newgradeitem = newgradeitem;
       this.userid = userid;
       this.finalgrade = finalgrade;
       this.feedback = feedback;
       this.importcode = importcode;
       this.importer = importer;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public Long getItemid() {
        return this.itemid;
    }
    
    public void setItemid(Long itemid) {
        this.itemid = itemid;
    }
    public Long getNewgradeitem() {
        return this.newgradeitem;
    }
    
    public void setNewgradeitem(Long newgradeitem) {
        this.newgradeitem = newgradeitem;
    }
    public long getUserid() {
        return this.userid;
    }
    
    public void setUserid(long userid) {
        this.userid = userid;
    }
    public BigDecimal getFinalgrade() {
        return this.finalgrade;
    }
    
    public void setFinalgrade(BigDecimal finalgrade) {
        this.finalgrade = finalgrade;
    }
    public String getFeedback() {
        return this.feedback;
    }
    
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
    public long getImportcode() {
        return this.importcode;
    }
    
    public void setImportcode(long importcode) {
        this.importcode = importcode;
    }
    public Long getImporter() {
        return this.importer;
    }
    
    public void setImporter(Long importer) {
        this.importer = importer;
    }




}


