package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlCapabilities generated by hbm2java
 */
public class MdlCapabilities  implements java.io.Serializable {


     private Long id;
     private String name;
     private String captype;
     private long contextlevel;
     private String component;
     private long riskbitmask;

    public MdlCapabilities() {
    }

    public MdlCapabilities(String name, String captype, long contextlevel, String component, long riskbitmask) {
       this.name = name;
       this.captype = captype;
       this.contextlevel = contextlevel;
       this.component = component;
       this.riskbitmask = riskbitmask;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getCaptype() {
        return this.captype;
    }
    
    public void setCaptype(String captype) {
        this.captype = captype;
    }
    public long getContextlevel() {
        return this.contextlevel;
    }
    
    public void setContextlevel(long contextlevel) {
        this.contextlevel = contextlevel;
    }
    public String getComponent() {
        return this.component;
    }
    
    public void setComponent(String component) {
        this.component = component;
    }
    public long getRiskbitmask() {
        return this.riskbitmask;
    }
    
    public void setRiskbitmask(long riskbitmask) {
        this.riskbitmask = riskbitmask;
    }




}


