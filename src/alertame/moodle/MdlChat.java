package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlChat generated by hbm2java
 */
public class MdlChat  implements java.io.Serializable {


     private Long id;
     private long course;
     private String name;
     private String intro;
     private long keepdays;
     private short studentlogs;
     private long chattime;
     private short schedule;
     private long timemodified;

    public MdlChat() {
    }

    public MdlChat(long course, String name, String intro, long keepdays, short studentlogs, long chattime, short schedule, long timemodified) {
       this.course = course;
       this.name = name;
       this.intro = intro;
       this.keepdays = keepdays;
       this.studentlogs = studentlogs;
       this.chattime = chattime;
       this.schedule = schedule;
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
    public String getIntro() {
        return this.intro;
    }
    
    public void setIntro(String intro) {
        this.intro = intro;
    }
    public long getKeepdays() {
        return this.keepdays;
    }
    
    public void setKeepdays(long keepdays) {
        this.keepdays = keepdays;
    }
    public short getStudentlogs() {
        return this.studentlogs;
    }
    
    public void setStudentlogs(short studentlogs) {
        this.studentlogs = studentlogs;
    }
    public long getChattime() {
        return this.chattime;
    }
    
    public void setChattime(long chattime) {
        this.chattime = chattime;
    }
    public short getSchedule() {
        return this.schedule;
    }
    
    public void setSchedule(short schedule) {
        this.schedule = schedule;
    }
    public long getTimemodified() {
        return this.timemodified;
    }
    
    public void setTimemodified(long timemodified) {
        this.timemodified = timemodified;
    }




}


