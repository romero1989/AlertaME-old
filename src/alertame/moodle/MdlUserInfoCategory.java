package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlUserInfoCategory generated by hbm2java
 */
public class MdlUserInfoCategory  implements java.io.Serializable {


     private Long id;
     private String name;
     private long sortorder;

    public MdlUserInfoCategory() {
    }

    public MdlUserInfoCategory(String name, long sortorder) {
       this.name = name;
       this.sortorder = sortorder;
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
    public long getSortorder() {
        return this.sortorder;
    }
    
    public void setSortorder(long sortorder) {
        this.sortorder = sortorder;
    }




}

