package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlModules generated by hbm2java
 */
public class MdlModules  implements java.io.Serializable {


     private Long id;
     private long version;
     private String name;
     private long cron;
     private long lastcron;
     private String search;
     private boolean visible;

    public MdlModules() {
    }

    public MdlModules(String name, long cron, long lastcron, String search, boolean visible) {
       this.name = name;
       this.cron = cron;
       this.lastcron = lastcron;
       this.search = search;
       this.visible = visible;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public long getVersion() {
        return this.version;
    }
    
    public void setVersion(long version) {
        this.version = version;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public long getCron() {
        return this.cron;
    }
    
    public void setCron(long cron) {
        this.cron = cron;
    }
    public long getLastcron() {
        return this.lastcron;
    }
    
    public void setLastcron(long lastcron) {
        this.lastcron = lastcron;
    }
    public String getSearch() {
        return this.search;
    }
    
    public void setSearch(String search) {
        this.search = search;
    }
    public boolean isVisible() {
        return this.visible;
    }
    
    public void setVisible(boolean visible) {
        this.visible = visible;
    }




}


