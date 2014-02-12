package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlQuestion generated by hbm2java
 */
public class MdlQuestion  implements java.io.Serializable {


     private Long id;
     private String version;
     private long category;
     private long parent;
     private String name;
     private String questiontext;
     private byte questiontextformat;
     private String image;
     private String generalfeedback;
     private long defaultgrade;
     private double penalty;
     private String qtype;
     private long length;
     private String stamp;
     private boolean hidden;
     private long timecreated;
     private long timemodified;
     private Long createdby;
     private Long modifiedby;

    public MdlQuestion() {
    }

	
    public MdlQuestion(long category, long parent, String name, String questiontext, byte questiontextformat, String image, String generalfeedback, long defaultgrade, double penalty, String qtype, long length, String stamp, boolean hidden, long timecreated, long timemodified) {
        this.category = category;
        this.parent = parent;
        this.name = name;
        this.questiontext = questiontext;
        this.questiontextformat = questiontextformat;
        this.image = image;
        this.generalfeedback = generalfeedback;
        this.defaultgrade = defaultgrade;
        this.penalty = penalty;
        this.qtype = qtype;
        this.length = length;
        this.stamp = stamp;
        this.hidden = hidden;
        this.timecreated = timecreated;
        this.timemodified = timemodified;
    }
    public MdlQuestion(long category, long parent, String name, String questiontext, byte questiontextformat, String image, String generalfeedback, long defaultgrade, double penalty, String qtype, long length, String stamp, boolean hidden, long timecreated, long timemodified, Long createdby, Long modifiedby) {
       this.category = category;
       this.parent = parent;
       this.name = name;
       this.questiontext = questiontext;
       this.questiontextformat = questiontextformat;
       this.image = image;
       this.generalfeedback = generalfeedback;
       this.defaultgrade = defaultgrade;
       this.penalty = penalty;
       this.qtype = qtype;
       this.length = length;
       this.stamp = stamp;
       this.hidden = hidden;
       this.timecreated = timecreated;
       this.timemodified = timemodified;
       this.createdby = createdby;
       this.modifiedby = modifiedby;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public String getVersion() {
        return this.version;
    }
    
    public void setVersion(String version) {
        this.version = version;
    }
    public long getCategory() {
        return this.category;
    }
    
    public void setCategory(long category) {
        this.category = category;
    }
    public long getParent() {
        return this.parent;
    }
    
    public void setParent(long parent) {
        this.parent = parent;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getQuestiontext() {
        return this.questiontext;
    }
    
    public void setQuestiontext(String questiontext) {
        this.questiontext = questiontext;
    }
    public byte getQuestiontextformat() {
        return this.questiontextformat;
    }
    
    public void setQuestiontextformat(byte questiontextformat) {
        this.questiontextformat = questiontextformat;
    }
    public String getImage() {
        return this.image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }
    public String getGeneralfeedback() {
        return this.generalfeedback;
    }
    
    public void setGeneralfeedback(String generalfeedback) {
        this.generalfeedback = generalfeedback;
    }
    public long getDefaultgrade() {
        return this.defaultgrade;
    }
    
    public void setDefaultgrade(long defaultgrade) {
        this.defaultgrade = defaultgrade;
    }
    public double getPenalty() {
        return this.penalty;
    }
    
    public void setPenalty(double penalty) {
        this.penalty = penalty;
    }
    public String getQtype() {
        return this.qtype;
    }
    
    public void setQtype(String qtype) {
        this.qtype = qtype;
    }
    public long getLength() {
        return this.length;
    }
    
    public void setLength(long length) {
        this.length = length;
    }
    public String getStamp() {
        return this.stamp;
    }
    
    public void setStamp(String stamp) {
        this.stamp = stamp;
    }
    public boolean isHidden() {
        return this.hidden;
    }
    
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
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
    public Long getCreatedby() {
        return this.createdby;
    }
    
    public void setCreatedby(Long createdby) {
        this.createdby = createdby;
    }
    public Long getModifiedby() {
        return this.modifiedby;
    }
    
    public void setModifiedby(Long modifiedby) {
        this.modifiedby = modifiedby;
    }




}


