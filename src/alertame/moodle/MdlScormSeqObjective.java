package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlScormSeqObjective generated by hbm2java
 */
public class MdlScormSeqObjective  implements java.io.Serializable {


     private Long id;
     private long scoid;
     private boolean primaryobj;
     private long objectiveid;
     private boolean satisfiedbymeasure;
     private float minnormalizedmeasure;

    public MdlScormSeqObjective() {
    }

    public MdlScormSeqObjective(long scoid, boolean primaryobj, long objectiveid, boolean satisfiedbymeasure, float minnormalizedmeasure) {
       this.scoid = scoid;
       this.primaryobj = primaryobj;
       this.objectiveid = objectiveid;
       this.satisfiedbymeasure = satisfiedbymeasure;
       this.minnormalizedmeasure = minnormalizedmeasure;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public long getScoid() {
        return this.scoid;
    }
    
    public void setScoid(long scoid) {
        this.scoid = scoid;
    }
    public boolean isPrimaryobj() {
        return this.primaryobj;
    }
    
    public void setPrimaryobj(boolean primaryobj) {
        this.primaryobj = primaryobj;
    }
    public long getObjectiveid() {
        return this.objectiveid;
    }
    
    public void setObjectiveid(long objectiveid) {
        this.objectiveid = objectiveid;
    }
    public boolean isSatisfiedbymeasure() {
        return this.satisfiedbymeasure;
    }
    
    public void setSatisfiedbymeasure(boolean satisfiedbymeasure) {
        this.satisfiedbymeasure = satisfiedbymeasure;
    }
    public float getMinnormalizedmeasure() {
        return this.minnormalizedmeasure;
    }
    
    public void setMinnormalizedmeasure(float minnormalizedmeasure) {
        this.minnormalizedmeasure = minnormalizedmeasure;
    }




}


