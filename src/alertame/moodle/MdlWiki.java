package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlWiki generated by hbm2java
 */
public class MdlWiki  implements java.io.Serializable {


     private Long id;
     private long course;
     private String name;
     private String summary;
     private String pagename;
     private String wtype;
     private short ewikiprinttitle;
     private short htmlmode;
     private short ewikiacceptbinary;
     private short disablecamelcase;
     private short setpageflags;
     private short strippages;
     private short removepages;
     private short revertchanges;
     private String initialcontent;
     private long timemodified;

    public MdlWiki() {
    }

    public MdlWiki(long course, String name, String summary, String pagename, String wtype, short ewikiprinttitle, short htmlmode, short ewikiacceptbinary, short disablecamelcase, short setpageflags, short strippages, short removepages, short revertchanges, String initialcontent, long timemodified) {
       this.course = course;
       this.name = name;
       this.summary = summary;
       this.pagename = pagename;
       this.wtype = wtype;
       this.ewikiprinttitle = ewikiprinttitle;
       this.htmlmode = htmlmode;
       this.ewikiacceptbinary = ewikiacceptbinary;
       this.disablecamelcase = disablecamelcase;
       this.setpageflags = setpageflags;
       this.strippages = strippages;
       this.removepages = removepages;
       this.revertchanges = revertchanges;
       this.initialcontent = initialcontent;
       this.timemodified = timemodified;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public long getCourse() {
        return this.course;
    }
    
    public void setCourse(long course) {
        this.course = course;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getSummary() {
        return this.summary;
    }
    
    public void setSummary(String summary) {
        this.summary = summary;
    }
    public String getPagename() {
        return this.pagename;
    }
    
    public void setPagename(String pagename) {
        this.pagename = pagename;
    }
    public String getWtype() {
        return this.wtype;
    }
    
    public void setWtype(String wtype) {
        this.wtype = wtype;
    }
    public short getEwikiprinttitle() {
        return this.ewikiprinttitle;
    }
    
    public void setEwikiprinttitle(short ewikiprinttitle) {
        this.ewikiprinttitle = ewikiprinttitle;
    }
    public short getHtmlmode() {
        return this.htmlmode;
    }
    
    public void setHtmlmode(short htmlmode) {
        this.htmlmode = htmlmode;
    }
    public short getEwikiacceptbinary() {
        return this.ewikiacceptbinary;
    }
    
    public void setEwikiacceptbinary(short ewikiacceptbinary) {
        this.ewikiacceptbinary = ewikiacceptbinary;
    }
    public short getDisablecamelcase() {
        return this.disablecamelcase;
    }
    
    public void setDisablecamelcase(short disablecamelcase) {
        this.disablecamelcase = disablecamelcase;
    }
    public short getSetpageflags() {
        return this.setpageflags;
    }
    
    public void setSetpageflags(short setpageflags) {
        this.setpageflags = setpageflags;
    }
    public short getStrippages() {
        return this.strippages;
    }
    
    public void setStrippages(short strippages) {
        this.strippages = strippages;
    }
    public short getRemovepages() {
        return this.removepages;
    }
    
    public void setRemovepages(short removepages) {
        this.removepages = removepages;
    }
    public short getRevertchanges() {
        return this.revertchanges;
    }
    
    public void setRevertchanges(short revertchanges) {
        this.revertchanges = revertchanges;
    }
    public String getInitialcontent() {
        return this.initialcontent;
    }
    
    public void setInitialcontent(String initialcontent) {
        this.initialcontent = initialcontent;
    }
    public long getTimemodified() {
        return this.timemodified;
    }
    
    public void setTimemodified(long timemodified) {
        this.timemodified = timemodified;
    }




}

