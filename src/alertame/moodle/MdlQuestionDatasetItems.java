package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlQuestionDatasetItems generated by hbm2java
 */
public class MdlQuestionDatasetItems  implements java.io.Serializable {


     private Long id;
     private long definition;
     private long itemnumber;
     private String value;

    public MdlQuestionDatasetItems() {
    }

    public MdlQuestionDatasetItems(long definition, long itemnumber, String value) {
       this.definition = definition;
       this.itemnumber = itemnumber;
       this.value = value;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public long getDefinition() {
        return this.definition;
    }
    
    public void setDefinition(long definition) {
        this.definition = definition;
    }
    public long getItemnumber() {
        return this.itemnumber;
    }
    
    public void setItemnumber(long itemnumber) {
        this.itemnumber = itemnumber;
    }
    public String getValue() {
        return this.value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }




}


