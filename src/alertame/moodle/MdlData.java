package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlData generated by hbm2java
 */
public class MdlData  implements java.io.Serializable {


     private Long id;
     private long course;
     private String name;
     private String intro;
     private short comments;
     private long timeavailablefrom;
     private long timeavailableto;
     private long timeviewfrom;
     private long timeviewto;
     private int requiredentries;
     private int requiredentriestoview;
     private int maxentries;
     private short rssarticles;
     private String singletemplate;
     private String listtemplate;
     private String listtemplateheader;
     private String listtemplatefooter;
     private String addtemplate;
     private String rsstemplate;
     private String rsstitletemplate;
     private String csstemplate;
     private String jstemplate;
     private String asearchtemplate;
     private short approval;
     private long scale;
     private long assessed;
     private long defaultsort;
     private short defaultsortdir;
     private short editany;
     private long notification;

    public MdlData() {
    }

	
    public MdlData(long course, String name, String intro, short comments, long timeavailablefrom, long timeavailableto, long timeviewfrom, long timeviewto, int requiredentries, int requiredentriestoview, int maxentries, short rssarticles, short approval, long scale, long assessed, long defaultsort, short defaultsortdir, short editany, long notification) {
        this.course = course;
        this.name = name;
        this.intro = intro;
        this.comments = comments;
        this.timeavailablefrom = timeavailablefrom;
        this.timeavailableto = timeavailableto;
        this.timeviewfrom = timeviewfrom;
        this.timeviewto = timeviewto;
        this.requiredentries = requiredentries;
        this.requiredentriestoview = requiredentriestoview;
        this.maxentries = maxentries;
        this.rssarticles = rssarticles;
        this.approval = approval;
        this.scale = scale;
        this.assessed = assessed;
        this.defaultsort = defaultsort;
        this.defaultsortdir = defaultsortdir;
        this.editany = editany;
        this.notification = notification;
    }
    public MdlData(long course, String name, String intro, short comments, long timeavailablefrom, long timeavailableto, long timeviewfrom, long timeviewto, int requiredentries, int requiredentriestoview, int maxentries, short rssarticles, String singletemplate, String listtemplate, String listtemplateheader, String listtemplatefooter, String addtemplate, String rsstemplate, String rsstitletemplate, String csstemplate, String jstemplate, String asearchtemplate, short approval, long scale, long assessed, long defaultsort, short defaultsortdir, short editany, long notification) {
       this.course = course;
       this.name = name;
       this.intro = intro;
       this.comments = comments;
       this.timeavailablefrom = timeavailablefrom;
       this.timeavailableto = timeavailableto;
       this.timeviewfrom = timeviewfrom;
       this.timeviewto = timeviewto;
       this.requiredentries = requiredentries;
       this.requiredentriestoview = requiredentriestoview;
       this.maxentries = maxentries;
       this.rssarticles = rssarticles;
       this.singletemplate = singletemplate;
       this.listtemplate = listtemplate;
       this.listtemplateheader = listtemplateheader;
       this.listtemplatefooter = listtemplatefooter;
       this.addtemplate = addtemplate;
       this.rsstemplate = rsstemplate;
       this.rsstitletemplate = rsstitletemplate;
       this.csstemplate = csstemplate;
       this.jstemplate = jstemplate;
       this.asearchtemplate = asearchtemplate;
       this.approval = approval;
       this.scale = scale;
       this.assessed = assessed;
       this.defaultsort = defaultsort;
       this.defaultsortdir = defaultsortdir;
       this.editany = editany;
       this.notification = notification;
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
    public String getIntro() {
        return this.intro;
    }
    
    public void setIntro(String intro) {
        this.intro = intro;
    }
    public short getComments() {
        return this.comments;
    }
    
    public void setComments(short comments) {
        this.comments = comments;
    }
    public long getTimeavailablefrom() {
        return this.timeavailablefrom;
    }
    
    public void setTimeavailablefrom(long timeavailablefrom) {
        this.timeavailablefrom = timeavailablefrom;
    }
    public long getTimeavailableto() {
        return this.timeavailableto;
    }
    
    public void setTimeavailableto(long timeavailableto) {
        this.timeavailableto = timeavailableto;
    }
    public long getTimeviewfrom() {
        return this.timeviewfrom;
    }
    
    public void setTimeviewfrom(long timeviewfrom) {
        this.timeviewfrom = timeviewfrom;
    }
    public long getTimeviewto() {
        return this.timeviewto;
    }
    
    public void setTimeviewto(long timeviewto) {
        this.timeviewto = timeviewto;
    }
    public int getRequiredentries() {
        return this.requiredentries;
    }
    
    public void setRequiredentries(int requiredentries) {
        this.requiredentries = requiredentries;
    }
    public int getRequiredentriestoview() {
        return this.requiredentriestoview;
    }
    
    public void setRequiredentriestoview(int requiredentriestoview) {
        this.requiredentriestoview = requiredentriestoview;
    }
    public int getMaxentries() {
        return this.maxentries;
    }
    
    public void setMaxentries(int maxentries) {
        this.maxentries = maxentries;
    }
    public short getRssarticles() {
        return this.rssarticles;
    }
    
    public void setRssarticles(short rssarticles) {
        this.rssarticles = rssarticles;
    }
    public String getSingletemplate() {
        return this.singletemplate;
    }
    
    public void setSingletemplate(String singletemplate) {
        this.singletemplate = singletemplate;
    }
    public String getListtemplate() {
        return this.listtemplate;
    }
    
    public void setListtemplate(String listtemplate) {
        this.listtemplate = listtemplate;
    }
    public String getListtemplateheader() {
        return this.listtemplateheader;
    }
    
    public void setListtemplateheader(String listtemplateheader) {
        this.listtemplateheader = listtemplateheader;
    }
    public String getListtemplatefooter() {
        return this.listtemplatefooter;
    }
    
    public void setListtemplatefooter(String listtemplatefooter) {
        this.listtemplatefooter = listtemplatefooter;
    }
    public String getAddtemplate() {
        return this.addtemplate;
    }
    
    public void setAddtemplate(String addtemplate) {
        this.addtemplate = addtemplate;
    }
    public String getRsstemplate() {
        return this.rsstemplate;
    }
    
    public void setRsstemplate(String rsstemplate) {
        this.rsstemplate = rsstemplate;
    }
    public String getRsstitletemplate() {
        return this.rsstitletemplate;
    }
    
    public void setRsstitletemplate(String rsstitletemplate) {
        this.rsstitletemplate = rsstitletemplate;
    }
    public String getCsstemplate() {
        return this.csstemplate;
    }
    
    public void setCsstemplate(String csstemplate) {
        this.csstemplate = csstemplate;
    }
    public String getJstemplate() {
        return this.jstemplate;
    }
    
    public void setJstemplate(String jstemplate) {
        this.jstemplate = jstemplate;
    }
    public String getAsearchtemplate() {
        return this.asearchtemplate;
    }
    
    public void setAsearchtemplate(String asearchtemplate) {
        this.asearchtemplate = asearchtemplate;
    }
    public short getApproval() {
        return this.approval;
    }
    
    public void setApproval(short approval) {
        this.approval = approval;
    }
    public long getScale() {
        return this.scale;
    }
    
    public void setScale(long scale) {
        this.scale = scale;
    }
    public long getAssessed() {
        return this.assessed;
    }
    
    public void setAssessed(long assessed) {
        this.assessed = assessed;
    }
    public long getDefaultsort() {
        return this.defaultsort;
    }
    
    public void setDefaultsort(long defaultsort) {
        this.defaultsort = defaultsort;
    }
    public short getDefaultsortdir() {
        return this.defaultsortdir;
    }
    
    public void setDefaultsortdir(short defaultsortdir) {
        this.defaultsortdir = defaultsortdir;
    }
    public short getEditany() {
        return this.editany;
    }
    
    public void setEditany(short editany) {
        this.editany = editany;
    }
    public long getNotification() {
        return this.notification;
    }
    
    public void setNotification(long notification) {
        this.notification = notification;
    }




}


