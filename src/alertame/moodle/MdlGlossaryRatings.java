package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlGlossaryRatings generated by hbm2java
 */
public class MdlGlossaryRatings  implements java.io.Serializable {


     private Long id;
     private long userid;
     private long entryid;
     private long time;
     private short rating;

    public MdlGlossaryRatings() {
    }

    public MdlGlossaryRatings(long userid, long entryid, long time, short rating) {
       this.userid = userid;
       this.entryid = entryid;
       this.time = time;
       this.rating = rating;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public long getUserid() {
        return this.userid;
    }
    
    public void setUserid(long userid) {
        this.userid = userid;
    }
    public long getEntryid() {
        return this.entryid;
    }
    
    public void setEntryid(long entryid) {
        this.entryid = entryid;
    }
    public long getTime() {
        return this.time;
    }
    
    public void setTime(long time) {
        this.time = time;
    }
    public short getRating() {
        return this.rating;
    }
    
    public void setRating(short rating) {
        this.rating = rating;
    }




}

