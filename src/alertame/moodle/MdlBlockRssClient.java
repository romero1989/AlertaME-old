package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlBlockRssClient generated by hbm2java
 */
public class MdlBlockRssClient  implements java.io.Serializable {


     private Long id;
     private long userid;
     private String title;
     private String preferredtitle;
     private String description;
     private byte shared;
     private String url;

    public MdlBlockRssClient() {
    }

    public MdlBlockRssClient(long userid, String title, String preferredtitle, String description, byte shared, String url) {
       this.userid = userid;
       this.title = title;
       this.preferredtitle = preferredtitle;
       this.description = description;
       this.shared = shared;
       this.url = url;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
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
    public String getPreferredtitle() {
        return this.preferredtitle;
    }
    
    public void setPreferredtitle(String preferredtitle) {
        this.preferredtitle = preferredtitle;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public byte getShared() {
        return this.shared;
    }
    
    public void setShared(byte shared) {
        this.shared = shared;
    }
    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }




}


