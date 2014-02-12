package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlQuiz generated by hbm2java
 */
public class MdlQuiz  implements java.io.Serializable {


     private Long id;
     private long course;
     private String name;
     private String intro;
     private long timeopen;
     private long timeclose;
     private long optionflags;
     private short penaltyscheme;
     private int attempts;
     private short attemptonlast;
     private short grademethod;
     private short decimalpoints;
     private long review;
     private long questionsperpage;
     private short shufflequestions;
     private short shuffleanswers;
     private String questions;
     private long sumgrades;
     private long grade;
     private long timecreated;
     private long timemodified;
     private long timelimit;
     private String password;
     private String subnet;
     private short popup;
     private long delay1;
     private long delay2;

    public MdlQuiz() {
    }

    public MdlQuiz(long course, String name, String intro, long timeopen, long timeclose, long optionflags, short penaltyscheme, int attempts, short attemptonlast, short grademethod, short decimalpoints, long review, long questionsperpage, short shufflequestions, short shuffleanswers, String questions, long sumgrades, long grade, long timecreated, long timemodified, long timelimit, String password, String subnet, short popup, long delay1, long delay2) {
       this.course = course;
       this.name = name;
       this.intro = intro;
       this.timeopen = timeopen;
       this.timeclose = timeclose;
       this.optionflags = optionflags;
       this.penaltyscheme = penaltyscheme;
       this.attempts = attempts;
       this.attemptonlast = attemptonlast;
       this.grademethod = grademethod;
       this.decimalpoints = decimalpoints;
       this.review = review;
       this.questionsperpage = questionsperpage;
       this.shufflequestions = shufflequestions;
       this.shuffleanswers = shuffleanswers;
       this.questions = questions;
       this.sumgrades = sumgrades;
       this.grade = grade;
       this.timecreated = timecreated;
       this.timemodified = timemodified;
       this.timelimit = timelimit;
       this.password = password;
       this.subnet = subnet;
       this.popup = popup;
       this.delay1 = delay1;
       this.delay2 = delay2;
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
    public long getTimeopen() {
        return this.timeopen;
    }
    
    public void setTimeopen(long timeopen) {
        this.timeopen = timeopen;
    }
    public long getTimeclose() {
        return this.timeclose;
    }
    
    public void setTimeclose(long timeclose) {
        this.timeclose = timeclose;
    }
    public long getOptionflags() {
        return this.optionflags;
    }
    
    public void setOptionflags(long optionflags) {
        this.optionflags = optionflags;
    }
    public short getPenaltyscheme() {
        return this.penaltyscheme;
    }
    
    public void setPenaltyscheme(short penaltyscheme) {
        this.penaltyscheme = penaltyscheme;
    }
    public int getAttempts() {
        return this.attempts;
    }
    
    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }
    public short getAttemptonlast() {
        return this.attemptonlast;
    }
    
    public void setAttemptonlast(short attemptonlast) {
        this.attemptonlast = attemptonlast;
    }
    public short getGrademethod() {
        return this.grademethod;
    }
    
    public void setGrademethod(short grademethod) {
        this.grademethod = grademethod;
    }
    public short getDecimalpoints() {
        return this.decimalpoints;
    }
    
    public void setDecimalpoints(short decimalpoints) {
        this.decimalpoints = decimalpoints;
    }
    public long getReview() {
        return this.review;
    }
    
    public void setReview(long review) {
        this.review = review;
    }
    public long getQuestionsperpage() {
        return this.questionsperpage;
    }
    
    public void setQuestionsperpage(long questionsperpage) {
        this.questionsperpage = questionsperpage;
    }
    public short getShufflequestions() {
        return this.shufflequestions;
    }
    
    public void setShufflequestions(short shufflequestions) {
        this.shufflequestions = shufflequestions;
    }
    public short getShuffleanswers() {
        return this.shuffleanswers;
    }
    
    public void setShuffleanswers(short shuffleanswers) {
        this.shuffleanswers = shuffleanswers;
    }
    public String getQuestions() {
        return this.questions;
    }
    
    public void setQuestions(String questions) {
        this.questions = questions;
    }
    public long getSumgrades() {
        return this.sumgrades;
    }
    
    public void setSumgrades(long sumgrades) {
        this.sumgrades = sumgrades;
    }
    public long getGrade() {
        return this.grade;
    }
    
    public void setGrade(long grade) {
        this.grade = grade;
    }
    public long getTimecreated() {
        return this.timecreated;
    }
    
    public void setTimecreated(long timecreated) {
        this.timecreated = timecreated;
    }
    public long getTimemodified() {
        return this.timemodified;
    }
    
    public void setTimemodified(long timemodified) {
        this.timemodified = timemodified;
    }
    public long getTimelimit() {
        return this.timelimit;
    }
    
    public void setTimelimit(long timelimit) {
        this.timelimit = timelimit;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getSubnet() {
        return this.subnet;
    }
    
    public void setSubnet(String subnet) {
        this.subnet = subnet;
    }
    public short getPopup() {
        return this.popup;
    }
    
    public void setPopup(short popup) {
        this.popup = popup;
    }
    public long getDelay1() {
        return this.delay1;
    }
    
    public void setDelay1(long delay1) {
        this.delay1 = delay1;
    }
    public long getDelay2() {
        return this.delay2;
    }
    
    public void setDelay2(long delay2) {
        this.delay2 = delay2;
    }




}


