package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlLogDisplay generated by hbm2java
 */
public class MdlLogDisplay  implements java.io.Serializable {


     private Long id;
     private String module;
     private String action;
     private String mtable;
     private String field;

    public MdlLogDisplay() {
    }

    public MdlLogDisplay(String module, String action, String mtable, String field) {
       this.module = module;
       this.action = action;
       this.mtable = mtable;
       this.field = field;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public String getModule() {
        return this.module;
    }
    
    public void setModule(String module) {
        this.module = module;
    }
    public String getAction() {
        return this.action;
    }
    
    public void setAction(String action) {
        this.action = action;
    }
    public String getMtable() {
        return this.mtable;
    }
    
    public void setMtable(String mtable) {
        this.mtable = mtable;
    }
    public String getField() {
        return this.field;
    }
    
    public void setField(String field) {
        this.field = field;
    }




}


