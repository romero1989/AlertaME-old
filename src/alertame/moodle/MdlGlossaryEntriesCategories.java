package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlGlossaryEntriesCategories generated by hbm2java
 */
public class MdlGlossaryEntriesCategories  implements java.io.Serializable {


     private Long id;
     private long categoryid;
     private long entryid;

    public MdlGlossaryEntriesCategories() {
    }

    public MdlGlossaryEntriesCategories(long categoryid, long entryid) {
       this.categoryid = categoryid;
       this.entryid = entryid;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public long getCategoryid() {
        return this.categoryid;
    }
    
    public void setCategoryid(long categoryid) {
        this.categoryid = categoryid;
    }
    public long getEntryid() {
        return this.entryid;
    }
    
    public void setEntryid(long entryid) {
        this.entryid = entryid;
    }




}

