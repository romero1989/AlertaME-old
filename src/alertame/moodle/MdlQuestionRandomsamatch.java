package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlQuestionRandomsamatch generated by hbm2java
 */
public class MdlQuestionRandomsamatch  implements java.io.Serializable {


     private Long id;
     private long question;
     private long choose;

    public MdlQuestionRandomsamatch() {
    }

    public MdlQuestionRandomsamatch(long question, long choose) {
       this.question = question;
       this.choose = choose;
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
    public long getChoose() {
        return this.choose;
    }
    
    public void setChoose(long choose) {
        this.choose = choose;
    }




}


