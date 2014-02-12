package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlJournalEntries generated by hbm2java
 */
public class MdlJournalEntries  implements java.io.Serializable {


     private Long id;
     private long journal;
     private long userid;
     private long modified;
     private String text;
     private byte format;
     private Long rating;
     private String entrycomment;
     private long teacher;
     private long timemarked;
     private boolean mailed;

    public MdlJournalEntries() {
    }

	
    public MdlJournalEntries(long journal, long userid, long modified, String text, byte format, long teacher, long timemarked, boolean mailed) {
        this.journal = journal;
        this.userid = userid;
        this.modified = modified;
        this.text = text;
        this.format = format;
        this.teacher = teacher;
        this.timemarked = timemarked;
        this.mailed = mailed;
    }
    public MdlJournalEntries(long journal, long userid, long modified, String text, byte format, Long rating, String entrycomment, long teacher, long timemarked, boolean mailed) {
       this.journal = journal;
       this.userid = userid;
       this.modified = modified;
       this.text = text;
       this.format = format;
       this.rating = rating;
       this.entrycomment = entrycomment;
       this.teacher = teacher;
       this.timemarked = timemarked;
       this.mailed = mailed;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public long getJournal() {
        return this.journal;
    }
    
    public void setJournal(long journal) {
        this.journal = journal;
    }
    public long getUserid() {
        return this.userid;
    }
    
    public void setUserid(long userid) {
        this.userid = userid;
    }
    public long getModified() {
        return this.modified;
    }
    
    public void setModified(long modified) {
        this.modified = modified;
    }
    public String getText() {
        return this.text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    public byte getFormat() {
        return this.format;
    }
    
    public void setFormat(byte format) {
        this.format = format;
    }
    public Long getRating() {
        return this.rating;
    }
    
    public void setRating(Long rating) {
        this.rating = rating;
    }
    public String getEntrycomment() {
        return this.entrycomment;
    }
    
    public void setEntrycomment(String entrycomment) {
        this.entrycomment = entrycomment;
    }
    public long getTeacher() {
        return this.teacher;
    }
    
    public void setTeacher(long teacher) {
        this.teacher = teacher;
    }
    public long getTimemarked() {
        return this.timemarked;
    }
    
    public void setTimemarked(long timemarked) {
        this.timemarked = timemarked;
    }
    public boolean isMailed() {
        return this.mailed;
    }
    
    public void setMailed(boolean mailed) {
        this.mailed = mailed;
    }




}

