package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlMessageRead generated by hbm2java
 */
public class MdlMessageRead  implements java.io.Serializable {


     private Long id;
     private long useridfrom;
     private long useridto;
     private String message;
     private short format;
     private long timecreated;
     private long timeread;
     private String messagetype;
     private boolean mailed;

    public MdlMessageRead() {
    }

    public MdlMessageRead(long useridfrom, long useridto, String message, short format, long timecreated, long timeread, String messagetype, boolean mailed) {
       this.useridfrom = useridfrom;
       this.useridto = useridto;
       this.message = message;
       this.format = format;
       this.timecreated = timecreated;
       this.timeread = timeread;
       this.messagetype = messagetype;
       this.mailed = mailed;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public long getUseridfrom() {
        return this.useridfrom;
    }
    
    public void setUseridfrom(long useridfrom) {
        this.useridfrom = useridfrom;
    }
    public long getUseridto() {
        return this.useridto;
    }
    
    public void setUseridto(long useridto) {
        this.useridto = useridto;
    }
    public String getMessage() {
        return this.message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    public short getFormat() {
        return this.format;
    }
    
    public void setFormat(short format) {
        this.format = format;
    }
    public long getTimecreated() {
        return this.timecreated;
    }
    
    public void setTimecreated(long timecreated) {
        this.timecreated = timecreated;
    }
    public long getTimeread() {
        return this.timeread;
    }
    
    public void setTimeread(long timeread) {
        this.timeread = timeread;
    }
    public String getMessagetype() {
        return this.messagetype;
    }
    
    public void setMessagetype(String messagetype) {
        this.messagetype = messagetype;
    }
    public boolean isMailed() {
        return this.mailed;
    }
    
    public void setMailed(boolean mailed) {
        this.mailed = mailed;
    }




}


