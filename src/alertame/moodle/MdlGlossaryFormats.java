package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlGlossaryFormats generated by hbm2java
 */
public class MdlGlossaryFormats  implements java.io.Serializable {


     private Long id;
     private String name;
     private String popupformatname;
     private byte visible;
     private byte showgroup;
     private String defaultmode;
     private String defaulthook;
     private String sortkey;
     private String sortorder;

    public MdlGlossaryFormats() {
    }

    public MdlGlossaryFormats(String name, String popupformatname, byte visible, byte showgroup, String defaultmode, String defaulthook, String sortkey, String sortorder) {
       this.name = name;
       this.popupformatname = popupformatname;
       this.visible = visible;
       this.showgroup = showgroup;
       this.defaultmode = defaultmode;
       this.defaulthook = defaulthook;
       this.sortkey = sortkey;
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
    public String getPopupformatname() {
        return this.popupformatname;
    }
    
    public void setPopupformatname(String popupformatname) {
        this.popupformatname = popupformatname;
    }
    public byte getVisible() {
        return this.visible;
    }
    
    public void setVisible(byte visible) {
        this.visible = visible;
    }
    public byte getShowgroup() {
        return this.showgroup;
    }
    
    public void setShowgroup(byte showgroup) {
        this.showgroup = showgroup;
    }
    public String getDefaultmode() {
        return this.defaultmode;
    }
    
    public void setDefaultmode(String defaultmode) {
        this.defaultmode = defaultmode;
    }
    public String getDefaulthook() {
        return this.defaulthook;
    }
    
    public void setDefaulthook(String defaulthook) {
        this.defaulthook = defaulthook;
    }
    public String getSortkey() {
        return this.sortkey;
    }
    
    public void setSortkey(String sortkey) {
        this.sortkey = sortkey;
    }
    public String getSortorder() {
        return this.sortorder;
    }
    
    public void setSortorder(String sortorder) {
        this.sortorder = sortorder;
    }




}


