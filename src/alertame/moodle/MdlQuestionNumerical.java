package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlQuestionNumerical generated by hbm2java
 */
public class MdlQuestionNumerical  implements java.io.Serializable {


     private Long id;
     private long question;
     private long answer;
     private String tolerance;

    public MdlQuestionNumerical() {
    }

    public MdlQuestionNumerical(long question, long answer, String tolerance) {
       this.question = question;
       this.answer = answer;
       this.tolerance = tolerance;
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




}

