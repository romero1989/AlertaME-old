package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlChoiceAnswers generated by hbm2java
 */
public class MdlChoiceAnswers  implements java.io.Serializable {


     private Long id;
     private long choiceid;
     private long userid;
     private long optionid;
     private long timemodified;

    public MdlChoiceAnswers() {
    }

    public MdlChoiceAnswers(long choiceid, long userid, long optionid, long timemodified) {
       this.choiceid = choiceid;
       this.userid = userid;
       this.optionid = optionid;
       this.timemodified = timemodified;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public long getChoiceid() {
        return this.choiceid;
    }
    
    public void setChoiceid(long choiceid) {
        this.choiceid = choiceid;
    }
    public long getUserid() {
        return this.userid;
    }
    
    public void setUserid(long userid) {
        this.userid = userid;
    }
    public long getOptionid() {
        return this.optionid;
    }
    
    public void setOptionid(long optionid) {
        this.optionid = optionid;
    }
    public long getTimemodified() {
        return this.timemodified;
    }
    
    public void setTimemodified(long timemodified) {
        this.timemodified = timemodified;
    }




}


