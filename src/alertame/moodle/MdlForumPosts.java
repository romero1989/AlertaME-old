package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlForumPosts generated by hbm2java
 */
public class MdlForumPosts  implements java.io.Serializable {


     private Long id;
     private long discussion;
     private long parent;
     private long userid;
     private long created;
     private long modified;
     private byte mailed;
     private String subject;
     private String message;
     private byte format;
     private String attachment;
     private short totalscore;
     private long mailnow;

    public MdlForumPosts() {
    }

    public MdlForumPosts(long discussion, long parent, long userid, long created, long modified, byte mailed, String subject, String message, byte format, String attachment, short totalscore, long mailnow) {
       this.discussion = discussion;
       this.parent = parent;
       this.userid = userid;
       this.created = created;
       this.modified = modified;
       this.mailed = mailed;
       this.subject = subject;
       this.message = message;
       this.format = format;
       this.attachment = attachment;
       this.totalscore = totalscore;
       this.mailnow = mailnow;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public long getDiscussion() {
        return this.discussion;
    }
    
    public void setDiscussion(long discussion) {
        this.discussion = discussion;
    }
    public long getParent() {
        return this.parent;
    }
    
    public void setParent(long parent) {
        this.parent = parent;
    }
    public long getUserid() {
        return this.userid;
    }
    
    public void setUserid(long userid) {
        this.userid = userid;
    }
    public long getCreated() {
        return this.created;
    }
    
    public void setCreated(long created) {
        this.created = created;
    }
    public long getModified() {
        return this.modified;
    }
    
    public void setModified(long modified) {
        this.modified = modified;
    }
    public byte getMailed() {
        return this.mailed;
    }
    
    public void setMailed(byte mailed) {
        this.mailed = mailed;
    }
    public String getSubject() {
        return this.subject;
    }
    
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getMessage() {
        return this.message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    public byte getFormat() {
        return this.format;
    }
    
    public void setFormat(byte format) {
        this.format = format;
    }
    public String getAttachment() {
        return this.attachment;
    }
    
    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }
    public short getTotalscore() {
        return this.totalscore;
    }
    
    public void setTotalscore(short totalscore) {
        this.totalscore = totalscore;
    }
    public long getMailnow() {
        return this.mailnow;
    }
    
    public void setMailnow(long mailnow) {
        this.mailnow = mailnow;
    }




}

