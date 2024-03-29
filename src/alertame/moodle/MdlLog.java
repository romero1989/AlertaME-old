package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlLog generated by hbm2java
 */
public class MdlLog  implements java.io.Serializable {


     private Long id;
     private long time;
     private long userid;
     private String ip;
     private long course;
     private String module;
     private long cmid;
     private String action;
     private String url;
     private String info;

    public MdlLog() {
    }

    public MdlLog(long time, long userid, String ip, long course, String module, long cmid, String action, String url, String info) {
       this.time = time;
       this.userid = userid;
       this.ip = ip;
       this.course = course;
       this.module = module;
       this.cmid = cmid;
       this.action = action;
       this.url = url;
       this.info = info;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public long getTime() {
        return this.time;
    }
    
    public void setTime(long time) {
        this.time = time;
    }
    public long getUserid() {
        return this.userid;
    }
    
    public void setUserid(long userid) {
        this.userid = userid;
    }
    public String getIp() {
        return this.ip;
    }
    
    public void setIp(String ip) {
        this.ip = ip;
    }
    public long getCourse() {
        return this.course;
    }
    
    public void setCourse(long course) {
        this.course = course;
    }
    public String getModule() {
        return this.module;
    }
    
    public void setModule(String module) {
        this.module = module;
    }
    public long getCmid() {
        return this.cmid;
    }
    
    public void setCmid(long cmid) {
        this.cmid = cmid;
    }
    public String getAction() {
        return this.action;
    }
    
    public void setAction(String action) {
        this.action = action;
    }
    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    public String getInfo() {
        return this.info;
    }
    
    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "MdlLog{" + "id=" + id + ", time=" + time + ", userid=" + userid + ", ip=" + ip + ", course=" + course + ", module=" + module + ", cmid=" + cmid + ", action=" + action + ", url=" + url + ", info=" + info + '}';
    }




}


