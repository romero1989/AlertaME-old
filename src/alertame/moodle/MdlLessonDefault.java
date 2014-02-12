package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlLessonDefault generated by hbm2java
 */
public class MdlLessonDefault  implements java.io.Serializable {


     private Long id;
     private long course;
     private short practice;
     private short modattempts;
     private short usepassword;
     private String password;
     private String conditions;
     private short grade;
     private short custom;
     private short ongoing;
     private short usemaxgrade;
     private short maxanswers;
     private short maxattempts;
     private short review;
     private short nextpagedefault;
     private short feedback;
     private short minquestions;
     private short maxpages;
     private short timed;
     private long maxtime;
     private short retake;
     private long mediaheight;
     private long mediawidth;
     private short mediaclose;
     private short slideshow;
     private long width;
     private long height;
     private String bgcolor;
     private short displayleft;
     private short displayleftif;
     private short progressbar;
     private short highscores;
     private long maxhighscores;

    public MdlLessonDefault() {
    }

	
    public MdlLessonDefault(long course, short practice, short modattempts, short usepassword, String password, String conditions, short grade, short custom, short ongoing, short usemaxgrade, short maxanswers, short maxattempts, short review, short nextpagedefault, short feedback, short minquestions, short maxpages, short timed, long maxtime, short retake, long mediaheight, long mediawidth, short mediaclose, short slideshow, long width, long height, short displayleft, short displayleftif, short progressbar, short highscores, long maxhighscores) {
        this.course = course;
        this.practice = practice;
        this.modattempts = modattempts;
        this.usepassword = usepassword;
        this.password = password;
        this.conditions = conditions;
        this.grade = grade;
        this.custom = custom;
        this.ongoing = ongoing;
        this.usemaxgrade = usemaxgrade;
        this.maxanswers = maxanswers;
        this.maxattempts = maxattempts;
        this.review = review;
        this.nextpagedefault = nextpagedefault;
        this.feedback = feedback;
        this.minquestions = minquestions;
        this.maxpages = maxpages;
        this.timed = timed;
        this.maxtime = maxtime;
        this.retake = retake;
        this.mediaheight = mediaheight;
        this.mediawidth = mediawidth;
        this.mediaclose = mediaclose;
        this.slideshow = slideshow;
        this.width = width;
        this.height = height;
        this.displayleft = displayleft;
        this.displayleftif = displayleftif;
        this.progressbar = progressbar;
        this.highscores = highscores;
        this.maxhighscores = maxhighscores;
    }
    public MdlLessonDefault(long course, short practice, short modattempts, short usepassword, String password, String conditions, short grade, short custom, short ongoing, short usemaxgrade, short maxanswers, short maxattempts, short review, short nextpagedefault, short feedback, short minquestions, short maxpages, short timed, long maxtime, short retake, long mediaheight, long mediawidth, short mediaclose, short slideshow, long width, long height, String bgcolor, short displayleft, short displayleftif, short progressbar, short highscores, long maxhighscores) {
       this.course = course;
       this.practice = practice;
       this.modattempts = modattempts;
       this.usepassword = usepassword;
       this.password = password;
       this.conditions = conditions;
       this.grade = grade;
       this.custom = custom;
       this.ongoing = ongoing;
       this.usemaxgrade = usemaxgrade;
       this.maxanswers = maxanswers;
       this.maxattempts = maxattempts;
       this.review = review;
       this.nextpagedefault = nextpagedefault;
       this.feedback = feedback;
       this.minquestions = minquestions;
       this.maxpages = maxpages;
       this.timed = timed;
       this.maxtime = maxtime;
       this.retake = retake;
       this.mediaheight = mediaheight;
       this.mediawidth = mediawidth;
       this.mediaclose = mediaclose;
       this.slideshow = slideshow;
       this.width = width;
       this.height = height;
       this.bgcolor = bgcolor;
       this.displayleft = displayleft;
       this.displayleftif = displayleftif;
       this.progressbar = progressbar;
       this.highscores = highscores;
       this.maxhighscores = maxhighscores;
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
    public short getPractice() {
        return this.practice;
    }
    
    public void setPractice(short practice) {
        this.practice = practice;
    }
    public short getModattempts() {
        return this.modattempts;
    }
    
    public void setModattempts(short modattempts) {
        this.modattempts = modattempts;
    }
    public short getUsepassword() {
        return this.usepassword;
    }
    
    public void setUsepassword(short usepassword) {
        this.usepassword = usepassword;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getConditions() {
        return this.conditions;
    }
    
    public void setConditions(String conditions) {
        this.conditions = conditions;
    }
    public short getGrade() {
        return this.grade;
    }
    
    public void setGrade(short grade) {
        this.grade = grade;
    }
    public short getCustom() {
        return this.custom;
    }
    
    public void setCustom(short custom) {
        this.custom = custom;
    }
    public short getOngoing() {
        return this.ongoing;
    }
    
    public void setOngoing(short ongoing) {
        this.ongoing = ongoing;
    }
    public short getUsemaxgrade() {
        return this.usemaxgrade;
    }
    
    public void setUsemaxgrade(short usemaxgrade) {
        this.usemaxgrade = usemaxgrade;
    }
    public short getMaxanswers() {
        return this.maxanswers;
    }
    
    public void setMaxanswers(short maxanswers) {
        this.maxanswers = maxanswers;
    }
    public short getMaxattempts() {
        return this.maxattempts;
    }
    
    public void setMaxattempts(short maxattempts) {
        this.maxattempts = maxattempts;
    }
    public short getReview() {
        return this.review;
    }
    
    public void setReview(short review) {
        this.review = review;
    }
    public short getNextpagedefault() {
        return this.nextpagedefault;
    }
    
    public void setNextpagedefault(short nextpagedefault) {
        this.nextpagedefault = nextpagedefault;
    }
    public short getFeedback() {
        return this.feedback;
    }
    
    public void setFeedback(short feedback) {
        this.feedback = feedback;
    }
    public short getMinquestions() {
        return this.minquestions;
    }
    
    public void setMinquestions(short minquestions) {
        this.minquestions = minquestions;
    }
    public short getMaxpages() {
        return this.maxpages;
    }
    
    public void setMaxpages(short maxpages) {
        this.maxpages = maxpages;
    }
    public short getTimed() {
        return this.timed;
    }
    
    public void setTimed(short timed) {
        this.timed = timed;
    }
    public long getMaxtime() {
        return this.maxtime;
    }
    
    public void setMaxtime(long maxtime) {
        this.maxtime = maxtime;
    }
    public short getRetake() {
        return this.retake;
    }
    
    public void setRetake(short retake) {
        this.retake = retake;
    }
    public long getMediaheight() {
        return this.mediaheight;
    }
    
    public void setMediaheight(long mediaheight) {
        this.mediaheight = mediaheight;
    }
    public long getMediawidth() {
        return this.mediawidth;
    }
    
    public void setMediawidth(long mediawidth) {
        this.mediawidth = mediawidth;
    }
    public short getMediaclose() {
        return this.mediaclose;
    }
    
    public void setMediaclose(short mediaclose) {
        this.mediaclose = mediaclose;
    }
    public short getSlideshow() {
        return this.slideshow;
    }
    
    public void setSlideshow(short slideshow) {
        this.slideshow = slideshow;
    }
    public long getWidth() {
        return this.width;
    }
    
    public void setWidth(long width) {
        this.width = width;
    }
    public long getHeight() {
        return this.height;
    }
    
    public void setHeight(long height) {
        this.height = height;
    }
    public String getBgcolor() {
        return this.bgcolor;
    }
    
    public void setBgcolor(String bgcolor) {
        this.bgcolor = bgcolor;
    }
    public short getDisplayleft() {
        return this.displayleft;
    }
    
    public void setDisplayleft(short displayleft) {
        this.displayleft = displayleft;
    }
    public short getDisplayleftif() {
        return this.displayleftif;
    }
    
    public void setDisplayleftif(short displayleftif) {
        this.displayleftif = displayleftif;
    }
    public short getProgressbar() {
        return this.progressbar;
    }
    
    public void setProgressbar(short progressbar) {
        this.progressbar = progressbar;
    }
    public short getHighscores() {
        return this.highscores;
    }
    
    public void setHighscores(short highscores) {
        this.highscores = highscores;
    }
    public long getMaxhighscores() {
        return this.maxhighscores;
    }
    
    public void setMaxhighscores(long maxhighscores) {
        this.maxhighscores = maxhighscores;
    }




}

