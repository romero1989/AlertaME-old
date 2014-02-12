package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlSurveyQuestions generated by hbm2java
 */
public class MdlSurveyQuestions  implements java.io.Serializable {


     private Long id;
     private String text;
     private String shorttext;
     private String multi;
     private String intro;
     private short type;
     private String options;

    public MdlSurveyQuestions() {
    }

	
    public MdlSurveyQuestions(String text, String shorttext, String multi, String intro, short type) {
        this.text = text;
        this.shorttext = shorttext;
        this.multi = multi;
        this.intro = intro;
        this.type = type;
    }
    public MdlSurveyQuestions(String text, String shorttext, String multi, String intro, short type, String options) {
       this.text = text;
       this.shorttext = shorttext;
       this.multi = multi;
       this.intro = intro;
       this.type = type;
       this.options = options;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public String getText() {
        return this.text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    public String getShorttext() {
        return this.shorttext;
    }
    
    public void setShorttext(String shorttext) {
        this.shorttext = shorttext;
    }
    public String getMulti() {
        return this.multi;
    }
    
    public void setMulti(String multi) {
        this.multi = multi;
    }
    public String getIntro() {
        return this.intro;
    }
    
    public void setIntro(String intro) {
        this.intro = intro;
    }
    public short getType() {
        return this.type;
    }
    
    public void setType(short type) {
        this.type = type;
    }
    public String getOptions() {
        return this.options;
    }
    
    public void setOptions(String options) {
        this.options = options;
    }




}

