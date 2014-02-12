package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlForum generated by hbm2java
 */
public class MdlForum  implements java.io.Serializable {


     private Long id;
     private long course;
     private String type;
     private String name;
     private String intro;
     private long assessed;
     private long assesstimestart;
     private long assesstimefinish;
     private long scale;
     private long maxbytes;
     private boolean forcesubscribe;
     private byte trackingtype;
     private byte rsstype;
     private byte rssarticles;
     private long timemodified;
     private long warnafter;
     private long blockafter;
     private long blockperiod;

    public MdlForum() {
    }

    public MdlForum(long course, String type, String name, String intro, long assessed, long assesstimestart, long assesstimefinish, long scale, long maxbytes, boolean forcesubscribe, byte trackingtype, byte rsstype, byte rssarticles, long timemodified, long warnafter, long blockafter, long blockperiod) {
       this.course = course;
       this.type = type;
       this.name = name;
       this.intro = intro;
       this.assessed = assessed;
       this.assesstimestart = assesstimestart;
       this.assesstimefinish = assesstimefinish;
       this.scale = scale;
       this.maxbytes = maxbytes;
       this.forcesubscribe = forcesubscribe;
       this.trackingtype = trackingtype;
       this.rsstype = rsstype;
       this.rssarticles = rssarticles;
       this.timemodified = timemodified;
       this.warnafter = warnafter;
       this.blockafter = blockafter;
       this.blockperiod = blockperiod;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public long getCourse() {
        return this.course;
    }
    
    public void setCourse(long course) {
        this.course = course;
    }
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getIntro() {
        return this.intro;
    }
    
    public void setIntro(String intro) {
        this.intro = intro;
    }
    public long getAssessed() {
        return this.assessed;
    }
    
    public void setAssessed(long assessed) {
        this.assessed = assessed;
    }
    public long getAssesstimestart() {
        return this.assesstimestart;
    }
    
    public void setAssesstimestart(long assesstimestart) {
        this.assesstimestart = assesstimestart;
    }
    public long getAssesstimefinish() {
        return this.assesstimefinish;
    }
    
    public void setAssesstimefinish(long assesstimefinish) {
        this.assesstimefinish = assesstimefinish;
    }
    public long getScale() {
        return this.scale;
    }
    
    public void setScale(long scale) {
        this.scale = scale;
    }
    public long getMaxbytes() {
        return this.maxbytes;
    }
    
    public void setMaxbytes(long maxbytes) {
        this.maxbytes = maxbytes;
    }
    public boolean isForcesubscribe() {
        return this.forcesubscribe;
    }
    
    public void setForcesubscribe(boolean forcesubscribe) {
        this.forcesubscribe = forcesubscribe;
    }
    public byte getTrackingtype() {
        return this.trackingtype;
    }
    
    public void setTrackingtype(byte trackingtype) {
        this.trackingtype = trackingtype;
    }
    public byte getRsstype() {
        return this.rsstype;
    }
    
    public void setRsstype(byte rsstype) {
        this.rsstype = rsstype;
    }
    public byte getRssarticles() {
        return this.rssarticles;
    }
    
    public void setRssarticles(byte rssarticles) {
        this.rssarticles = rssarticles;
    }
    public long getTimemodified() {
        return this.timemodified;
    }
    
    public void setTimemodified(long timemodified) {
        this.timemodified = timemodified;
    }
    public long getWarnafter() {
        return this.warnafter;
    }
    
    public void setWarnafter(long warnafter) {
        this.warnafter = warnafter;
    }
    public long getBlockafter() {
        return this.blockafter;
    }
    
    public void setBlockafter(long blockafter) {
        this.blockafter = blockafter;
    }
    public long getBlockperiod() {
        return this.blockperiod;
    }
    
    public void setBlockperiod(long blockperiod) {
        this.blockperiod = blockperiod;
    }




}

