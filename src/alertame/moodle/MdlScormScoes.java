package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlScormScoes generated by hbm2java
 */
public class MdlScormScoes  implements java.io.Serializable {


     private Long id;
     private long scorm;
     private String manifest;
     private String organization;
     private String parent;
     private String identifier;
     private String launch;
     private String scormtype;
     private String title;

    public MdlScormScoes() {
    }

    public MdlScormScoes(long scorm, String manifest, String organization, String parent, String identifier, String launch, String scormtype, String title) {
       this.scorm = scorm;
       this.manifest = manifest;
       this.organization = organization;
       this.parent = parent;
       this.identifier = identifier;
       this.launch = launch;
       this.scormtype = scormtype;
       this.title = title;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public long getScorm() {
        return this.scorm;
    }
    
    public void setScorm(long scorm) {
        this.scorm = scorm;
    }
    public String getManifest() {
        return this.manifest;
    }
    
    public void setManifest(String manifest) {
        this.manifest = manifest;
    }
    public String getOrganization() {
        return this.organization;
    }
    
    public void setOrganization(String organization) {
        this.organization = organization;
    }
    public String getParent() {
        return this.parent;
    }
    
    public void setParent(String parent) {
        this.parent = parent;
    }
    public String getIdentifier() {
        return this.identifier;
    }
    
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
    public String getLaunch() {
        return this.launch;
    }
    
    public void setLaunch(String launch) {
        this.launch = launch;
    }
    public String getScormtype() {
        return this.scormtype;
    }
    
    public void setScormtype(String scormtype) {
        this.scormtype = scormtype;
    }
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }




}

