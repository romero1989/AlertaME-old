package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlBlockSearchDocuments generated by hbm2java
 */
public class MdlBlockSearchDocuments  implements java.io.Serializable {


     private Long id;
     private String docid;
     private String doctype;
     private String itemtype;
     private String title;
     private String url;
     private long docdate;
     private long updated;
     private long courseid;
     private long groupid;

    public MdlBlockSearchDocuments() {
    }

    public MdlBlockSearchDocuments(String docid, String doctype, String itemtype, String title, String url, long docdate, long updated, long courseid, long groupid) {
       this.docid = docid;
       this.doctype = doctype;
       this.itemtype = itemtype;
       this.title = title;
       this.url = url;
       this.docdate = docdate;
       this.updated = updated;
       this.courseid = courseid;
       this.groupid = groupid;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public String getDocid() {
        return this.docid;
    }
    
    public void setDocid(String docid) {
        this.docid = docid;
    }
    public String getDoctype() {
        return this.doctype;
    }
    
    public void setDoctype(String doctype) {
        this.doctype = doctype;
    }
    public String getItemtype() {
        return this.itemtype;
    }
    
    public void setItemtype(String itemtype) {
        this.itemtype = itemtype;
    }
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    public long getDocdate() {
        return this.docdate;
    }
    
    public void setDocdate(long docdate) {
        this.docdate = docdate;
    }
    public long getUpdated() {
        return this.updated;
    }
    
    public void setUpdated(long updated) {
        this.updated = updated;
    }
    public long getCourseid() {
        return this.courseid;
    }
    
    public void setCourseid(long courseid) {
        this.courseid = courseid;
    }
    public long getGroupid() {
        return this.groupid;
    }
    
    public void setGroupid(long groupid) {
        this.groupid = groupid;
    }




}


