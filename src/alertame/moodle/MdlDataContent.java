package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlDataContent generated by hbm2java
 */
public class MdlDataContent  implements java.io.Serializable {


     private Long id;
     private long fieldid;
     private long recordid;
     private String content;
     private String content1;
     private String content2;
     private String content3;
     private String content4;

    public MdlDataContent() {
    }

	
    public MdlDataContent(long fieldid, long recordid) {
        this.fieldid = fieldid;
        this.recordid = recordid;
    }
    public MdlDataContent(long fieldid, long recordid, String content, String content1, String content2, String content3, String content4) {
       this.fieldid = fieldid;
       this.recordid = recordid;
       this.content = content;
       this.content1 = content1;
       this.content2 = content2;
       this.content3 = content3;
       this.content4 = content4;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public long getFieldid() {
        return this.fieldid;
    }
    
    public void setFieldid(long fieldid) {
        this.fieldid = fieldid;
    }
    public long getRecordid() {
        return this.recordid;
    }
    
    public void setRecordid(long recordid) {
        this.recordid = recordid;
    }
    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    public String getContent1() {
        return this.content1;
    }
    
    public void setContent1(String content1) {
        this.content1 = content1;
    }
    public String getContent2() {
        return this.content2;
    }
    
    public void setContent2(String content2) {
        this.content2 = content2;
    }
    public String getContent3() {
        return this.content3;
    }
    
    public void setContent3(String content3) {
        this.content3 = content3;
    }
    public String getContent4() {
        return this.content4;
    }
    
    public void setContent4(String content4) {
        this.content4 = content4;
    }




}


