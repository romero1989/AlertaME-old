package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlHotpotQuestions generated by hbm2java
 */
public class MdlHotpotQuestions  implements java.io.Serializable {


     private Long id;
     private String name;
     private short type;
     private long text;
     private long hotpot;
     private String md5key;

    public MdlHotpotQuestions() {
    }

    public MdlHotpotQuestions(String name, short type, long text, long hotpot, String md5key) {
       this.name = name;
       this.type = type;
       this.text = text;
       this.hotpot = hotpot;
       this.md5key = md5key;
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
    public short getType() {
        return this.type;
    }
    
    public void setType(short type) {
        this.type = type;
    }
    public long getText() {
        return this.text;
    }
    
    public void setText(long text) {
        this.text = text;
    }
    public long getHotpot() {
        return this.hotpot;
    }
    
    public void setHotpot(long hotpot) {
        this.hotpot = hotpot;
    }
    public String getMd5key() {
        return this.md5key;
    }
    
    public void setMd5key(String md5key) {
        this.md5key = md5key;
    }




}


