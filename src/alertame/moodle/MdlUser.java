package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlUser generated by hbm2java
 */
public class MdlUser  implements java.io.Serializable {


     private Long id;
     private String auth;
     private boolean confirmed;
     private boolean policyagreed;
     private boolean deleted;
     private long mnethostid;
     private String username;
     private String password;
     private String idnumber;
     private String firstname;
     private String lastname;
     private String email;
     private boolean emailstop;
     private String icq;
     private String skype;
     private String yahoo;
     private String aim;
     private String msn;
     private String phone1;
     private String phone2;
     private String institution;
     private String department;
     private String address;
     private String city;
     private String country;
     private String lang;
     private String theme;
     private String timezone;
     private long firstaccess;
     private long lastaccess;
     private long lastlogin;
     private long currentlogin;
     private String lastip;
     private String secret;
     private boolean picture;
     private String url;
     private String description;
     private boolean mailformat;
     private boolean maildigest;
     private byte maildisplay;
     private boolean htmleditor;
     private boolean ajax;
     private boolean autosubscribe;
     private boolean trackforums;
     private long timemodified;
     private long trustbitmask;
     private String imagealt;
     private boolean screenreader;

    public MdlUser() {
    }

	
    public MdlUser(String auth, boolean confirmed, boolean policyagreed, boolean deleted, long mnethostid, String username, String password, String idnumber, String firstname, String lastname, String email, boolean emailstop, String icq, String skype, String yahoo, String aim, String msn, String phone1, String phone2, String institution, String department, String address, String city, String country, String lang, String theme, String timezone, long firstaccess, long lastaccess, long lastlogin, long currentlogin, String lastip, String secret, boolean picture, String url, boolean mailformat, boolean maildigest, byte maildisplay, boolean htmleditor, boolean ajax, boolean autosubscribe, boolean trackforums, long timemodified, long trustbitmask, boolean screenreader) {
        this.auth = auth;
        this.confirmed = confirmed;
        this.policyagreed = policyagreed;
        this.deleted = deleted;
        this.mnethostid = mnethostid;
        this.username = username;
        this.password = password;
        this.idnumber = idnumber;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.emailstop = emailstop;
        this.icq = icq;
        this.skype = skype;
        this.yahoo = yahoo;
        this.aim = aim;
        this.msn = msn;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.institution = institution;
        this.department = department;
        this.address = address;
        this.city = city;
        this.country = country;
        this.lang = lang;
        this.theme = theme;
        this.timezone = timezone;
        this.firstaccess = firstaccess;
        this.lastaccess = lastaccess;
        this.lastlogin = lastlogin;
        this.currentlogin = currentlogin;
        this.lastip = lastip;
        this.secret = secret;
        this.picture = picture;
        this.url = url;
        this.mailformat = mailformat;
        this.maildigest = maildigest;
        this.maildisplay = maildisplay;
        this.htmleditor = htmleditor;
        this.ajax = ajax;
        this.autosubscribe = autosubscribe;
        this.trackforums = trackforums;
        this.timemodified = timemodified;
        this.trustbitmask = trustbitmask;
        this.screenreader = screenreader;
    }
    public MdlUser(String auth, boolean confirmed, boolean policyagreed, boolean deleted, long mnethostid, String username, String password, String idnumber, String firstname, String lastname, String email, boolean emailstop, String icq, String skype, String yahoo, String aim, String msn, String phone1, String phone2, String institution, String department, String address, String city, String country, String lang, String theme, String timezone, long firstaccess, long lastaccess, long lastlogin, long currentlogin, String lastip, String secret, boolean picture, String url, String description, boolean mailformat, boolean maildigest, byte maildisplay, boolean htmleditor, boolean ajax, boolean autosubscribe, boolean trackforums, long timemodified, long trustbitmask, String imagealt, boolean screenreader) {
       this.auth = auth;
       this.confirmed = confirmed;
       this.policyagreed = policyagreed;
       this.deleted = deleted;
       this.mnethostid = mnethostid;
       this.username = username;
       this.password = password;
       this.idnumber = idnumber;
       this.firstname = firstname;
       this.lastname = lastname;
       this.email = email;
       this.emailstop = emailstop;
       this.icq = icq;
       this.skype = skype;
       this.yahoo = yahoo;
       this.aim = aim;
       this.msn = msn;
       this.phone1 = phone1;
       this.phone2 = phone2;
       this.institution = institution;
       this.department = department;
       this.address = address;
       this.city = city;
       this.country = country;
       this.lang = lang;
       this.theme = theme;
       this.timezone = timezone;
       this.firstaccess = firstaccess;
       this.lastaccess = lastaccess;
       this.lastlogin = lastlogin;
       this.currentlogin = currentlogin;
       this.lastip = lastip;
       this.secret = secret;
       this.picture = picture;
       this.url = url;
       this.description = description;
       this.mailformat = mailformat;
       this.maildigest = maildigest;
       this.maildisplay = maildisplay;
       this.htmleditor = htmleditor;
       this.ajax = ajax;
       this.autosubscribe = autosubscribe;
       this.trackforums = trackforums;
       this.timemodified = timemodified;
       this.trustbitmask = trustbitmask;
       this.imagealt = imagealt;
       this.screenreader = screenreader;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public String getAuth() {
        return this.auth;
    }
    
    public void setAuth(String auth) {
        this.auth = auth;
    }
    public boolean isConfirmed() {
        return this.confirmed;
    }
    
    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }
    public boolean isPolicyagreed() {
        return this.policyagreed;
    }
    
    public void setPolicyagreed(boolean policyagreed) {
        this.policyagreed = policyagreed;
    }
    public boolean isDeleted() {
        return this.deleted;
    }
    
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
    public long getMnethostid() {
        return this.mnethostid;
    }
    
    public void setMnethostid(long mnethostid) {
        this.mnethostid = mnethostid;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getIdnumber() {
        return this.idnumber;
    }
    
    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }
    public String getFirstname() {
        return this.firstname;
    }
    
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return this.lastname;
    }
    
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public boolean isEmailstop() {
        return this.emailstop;
    }
    
    public void setEmailstop(boolean emailstop) {
        this.emailstop = emailstop;
    }
    public String getIcq() {
        return this.icq;
    }
    
    public void setIcq(String icq) {
        this.icq = icq;
    }
    public String getSkype() {
        return this.skype;
    }
    
    public void setSkype(String skype) {
        this.skype = skype;
    }
    public String getYahoo() {
        return this.yahoo;
    }
    
    public void setYahoo(String yahoo) {
        this.yahoo = yahoo;
    }
    public String getAim() {
        return this.aim;
    }
    
    public void setAim(String aim) {
        this.aim = aim;
    }
    public String getMsn() {
        return this.msn;
    }
    
    public void setMsn(String msn) {
        this.msn = msn;
    }
    public String getPhone1() {
        return this.phone1;
    }
    
    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }
    public String getPhone2() {
        return this.phone2;
    }
    
    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }
    public String getInstitution() {
        return this.institution;
    }
    
    public void setInstitution(String institution) {
        this.institution = institution;
    }
    public String getDepartment() {
        return this.department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    public String getCountry() {
        return this.country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    public String getLang() {
        return this.lang;
    }
    
    public void setLang(String lang) {
        this.lang = lang;
    }
    public String getTheme() {
        return this.theme;
    }
    
    public void setTheme(String theme) {
        this.theme = theme;
    }
    public String getTimezone() {
        return this.timezone;
    }
    
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
    public long getFirstaccess() {
        return this.firstaccess;
    }
    
    public void setFirstaccess(long firstaccess) {
        this.firstaccess = firstaccess;
    }
    public long getLastaccess() {
        return this.lastaccess;
    }
    
    public void setLastaccess(long lastaccess) {
        this.lastaccess = lastaccess;
    }
    public long getLastlogin() {
        return this.lastlogin;
    }
    
    public void setLastlogin(long lastlogin) {
        this.lastlogin = lastlogin;
    }
    public long getCurrentlogin() {
        return this.currentlogin;
    }
    
    public void setCurrentlogin(long currentlogin) {
        this.currentlogin = currentlogin;
    }
    public String getLastip() {
        return this.lastip;
    }
    
    public void setLastip(String lastip) {
        this.lastip = lastip;
    }
    public String getSecret() {
        return this.secret;
    }
    
    public void setSecret(String secret) {
        this.secret = secret;
    }
    public boolean isPicture() {
        return this.picture;
    }
    
    public void setPicture(boolean picture) {
        this.picture = picture;
    }
    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public boolean isMailformat() {
        return this.mailformat;
    }
    
    public void setMailformat(boolean mailformat) {
        this.mailformat = mailformat;
    }
    public boolean isMaildigest() {
        return this.maildigest;
    }
    
    public void setMaildigest(boolean maildigest) {
        this.maildigest = maildigest;
    }
    public byte getMaildisplay() {
        return this.maildisplay;
    }
    
    public void setMaildisplay(byte maildisplay) {
        this.maildisplay = maildisplay;
    }
    public boolean isHtmleditor() {
        return this.htmleditor;
    }
    
    public void setHtmleditor(boolean htmleditor) {
        this.htmleditor = htmleditor;
    }
    public boolean isAjax() {
        return this.ajax;
    }
    
    public void setAjax(boolean ajax) {
        this.ajax = ajax;
    }
    public boolean isAutosubscribe() {
        return this.autosubscribe;
    }
    
    public void setAutosubscribe(boolean autosubscribe) {
        this.autosubscribe = autosubscribe;
    }
    public boolean isTrackforums() {
        return this.trackforums;
    }
    
    public void setTrackforums(boolean trackforums) {
        this.trackforums = trackforums;
    }
    public long getTimemodified() {
        return this.timemodified;
    }
    
    public void setTimemodified(long timemodified) {
        this.timemodified = timemodified;
    }
    public long getTrustbitmask() {
        return this.trustbitmask;
    }
    
    public void setTrustbitmask(long trustbitmask) {
        this.trustbitmask = trustbitmask;
    }
    public String getImagealt() {
        return this.imagealt;
    }
    
    public void setImagealt(String imagealt) {
        this.imagealt = imagealt;
    }
    public boolean isScreenreader() {
        return this.screenreader;
    }
    
    public void setScreenreader(boolean screenreader) {
        this.screenreader = screenreader;
    }




}


