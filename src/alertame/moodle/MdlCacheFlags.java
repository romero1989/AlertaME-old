package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlCacheFlags generated by hbm2java
 */
public class MdlCacheFlags  implements java.io.Serializable {


     private Long id;
     private String flagtype;
     private String name;
     private long timemodified;
     private String value;
     private long expiry;

    public MdlCacheFlags() {
    }

    public MdlCacheFlags(String flagtype, String name, long timemodified, String value, long expiry) {
       this.flagtype = flagtype;
       this.name = name;
       this.timemodified = timemodified;
       this.value = value;
       this.expiry = expiry;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public String getFlagtype() {
        return this.flagtype;
    }
    
    public void setFlagtype(String flagtype) {
        this.flagtype = flagtype;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public long getTimemodified() {
        return this.timemodified;
    }
    
    public void setTimemodified(long timemodified) {
        this.timemodified = timemodified;
    }
    public String getValue() {
        return this.value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
    public long getExpiry() {
        return this.expiry;
    }
    
    public void setExpiry(long expiry) {
        this.expiry = expiry;
    }




}


