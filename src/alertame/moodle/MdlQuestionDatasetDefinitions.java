package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlQuestionDatasetDefinitions generated by hbm2java
 */
public class MdlQuestionDatasetDefinitions  implements java.io.Serializable {


     private Long id;
     private long category;
     private String name;
     private long type;
     private String options;
     private long itemcount;

    public MdlQuestionDatasetDefinitions() {
    }

    public MdlQuestionDatasetDefinitions(long category, String name, long type, String options, long itemcount) {
       this.category = category;
       this.name = name;
       this.type = type;
       this.options = options;
       this.itemcount = itemcount;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public long getCategory() {
        return this.category;
    }
    
    public void setCategory(long category) {
        this.category = category;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public long getType() {
        return this.type;
    }
    
    public void setType(long type) {
        this.type = type;
    }
    public String getOptions() {
        return this.options;
    }
    
    public void setOptions(String options) {
        this.options = options;
    }
    public long getItemcount() {
        return this.itemcount;
    }
    
    public void setItemcount(long itemcount) {
        this.itemcount = itemcount;
    }




}


