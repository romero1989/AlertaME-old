package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlQuestionMatchSub generated by hbm2java
 */
public class MdlQuestionMatchSub  implements java.io.Serializable {


     private Long id;
     private long code;
     private long question;
     private String questiontext;
     private String answertext;

    public MdlQuestionMatchSub() {
    }

    public MdlQuestionMatchSub(long code, long question, String questiontext, String answertext) {
       this.code = code;
       this.question = question;
       this.questiontext = questiontext;
       this.answertext = answertext;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public long getCode() {
        return this.code;
    }
    
    public void setCode(long code) {
        this.code = code;
    }
    public long getQuestion() {
        return this.question;
    }
    
    public void setQuestion(long question) {
        this.question = question;
    }
    public String getQuestiontext() {
        return this.questiontext;
    }
    
    public void setQuestiontext(String questiontext) {
        this.questiontext = questiontext;
    }
    public String getAnswertext() {
        return this.answertext;
    }
    
    public void setAnswertext(String answertext) {
        this.answertext = answertext;
    }




}


