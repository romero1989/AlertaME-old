package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlUserPreferences generated by hbm2java
 */
public class MdlUserPreferences  implements java.io.Serializable {


     private Long id;
     private long userid;
     private String name;
     private String value;

    public MdlUserPreferences() {
    }

    public MdlUserPreferences(long userid, String name, String value) {
       this.userid = userid;
       this.name = name;
       this.value = value;
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
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getValue() {
        return this.value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }




}


