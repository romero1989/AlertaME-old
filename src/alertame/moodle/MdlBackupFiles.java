package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlBackupFiles generated by hbm2java
 */
public class MdlBackupFiles  implements java.io.Serializable {


     private Long id;
     private long backupCode;
     private String fileType;
     private String path;
     private long oldId;
     private long newId;

    public MdlBackupFiles() {
    }

    public MdlBackupFiles(long backupCode, String fileType, String path, long oldId, long newId) {
       this.backupCode = backupCode;
       this.fileType = fileType;
       this.path = path;
       this.oldId = oldId;
       this.newId = newId;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public long getBackupCode() {
        return this.backupCode;
    }
    
    public void setBackupCode(long backupCode) {
        this.backupCode = backupCode;
    }
    public String getFileType() {
        return this.fileType;
    }
    
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
    public String getPath() {
        return this.path;
    }
    
    public void setPath(String path) {
        this.path = path;
    }
    public long getOldId() {
        return this.oldId;
    }
    
    public void setOldId(long oldId) {
        this.oldId = oldId;
    }
    public long getNewId() {
        return this.newId;
    }
    
    public void setNewId(long newId) {
        this.newId = newId;
    }




}


