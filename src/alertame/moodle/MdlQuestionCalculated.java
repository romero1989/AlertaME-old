package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlQuestionCalculated generated by hbm2java
 */
public class MdlQuestionCalculated  implements java.io.Serializable {


     private Long id;
     private long question;
     private long answer;
     private String tolerance;
     private long tolerancetype;
     private long correctanswerlength;
     private long correctanswerformat;

    public MdlQuestionCalculated() {
    }

    public MdlQuestionCalculated(long question, long answer, String tolerance, long tolerancetype, long correctanswerlength, long correctanswerformat) {
       this.question = question;
       this.answer = answer;
       this.tolerance = tolerance;
       this.tolerancetype = tolerancetype;
       this.correctanswerlength = correctanswerlength;
       this.correctanswerformat = correctanswerformat;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public long getQuestion() {
        return this.question;
    }
    
    public void setQuestion(long question) {
        this.question = question;
    }
    public long getAnswer() {
        return this.answer;
    }
    
    public void setAnswer(long answer) {
        this.answer = answer;
    }
    public String getTolerance() {
        return this.tolerance;
    }
    
    public void setTolerance(String tolerance) {
        this.tolerance = tolerance;
    }
    public long getTolerancetype() {
        return this.tolerancetype;
    }
    
    public void setTolerancetype(long tolerancetype) {
        this.tolerancetype = tolerancetype;
    }
    public long getCorrectanswerlength() {
        return this.correctanswerlength;
    }
    
    public void setCorrectanswerlength(long correctanswerlength) {
        this.correctanswerlength = correctanswerlength;
    }
    public long getCorrectanswerformat() {
        return this.correctanswerformat;
    }
    
    public void setCorrectanswerformat(long correctanswerformat) {
        this.correctanswerformat = correctanswerformat;
    }




}


