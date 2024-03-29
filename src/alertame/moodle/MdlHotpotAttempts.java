package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlHotpotAttempts generated by hbm2java
 */
public class MdlHotpotAttempts  implements java.io.Serializable {


     private Long id;
     private long hotpot;
     private long userid;
     private long starttime;
     private long endtime;
     private int score;
     private int penalties;
     private int attempt;
     private long timestart;
     private long timefinish;
     private short status;
     private long clickreportid;

    public MdlHotpotAttempts() {
    }

    public MdlHotpotAttempts(long hotpot, long userid, long starttime, long endtime, int score, int penalties, int attempt, long timestart, long timefinish, short status, long clickreportid) {
       this.hotpot = hotpot;
       this.userid = userid;
       this.starttime = starttime;
       this.endtime = endtime;
       this.score = score;
       this.penalties = penalties;
       this.attempt = attempt;
       this.timestart = timestart;
       this.timefinish = timefinish;
       this.status = status;
       this.clickreportid = clickreportid;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public long getHotpot() {
        return this.hotpot;
    }
    
    public void setHotpot(long hotpot) {
        this.hotpot = hotpot;
    }
    public long getUserid() {
        return this.userid;
    }
    
    public void setUserid(long userid) {
        this.userid = userid;
    }
    public long getStarttime() {
        return this.starttime;
    }
    
    public void setStarttime(long starttime) {
        this.starttime = starttime;
    }
    public long getEndtime() {
        return this.endtime;
    }
    
    public void setEndtime(long endtime) {
        this.endtime = endtime;
    }
    public int getScore() {
        return this.score;
    }
    
    public void setScore(int score) {
        this.score = score;
    }
    public int getPenalties() {
        return this.penalties;
    }
    
    public void setPenalties(int penalties) {
        this.penalties = penalties;
    }
    public int getAttempt() {
        return this.attempt;
    }
    
    public void setAttempt(int attempt) {
        this.attempt = attempt;
    }
    public long getTimestart() {
        return this.timestart;
    }
    
    public void setTimestart(long timestart) {
        this.timestart = timestart;
    }
    public long getTimefinish() {
        return this.timefinish;
    }
    
    public void setTimefinish(long timefinish) {
        this.timefinish = timefinish;
    }
    public short getStatus() {
        return this.status;
    }
    
    public void setStatus(short status) {
        this.status = status;
    }
    public long getClickreportid() {
        return this.clickreportid;
    }
    
    public void setClickreportid(long clickreportid) {
        this.clickreportid = clickreportid;
    }




}


