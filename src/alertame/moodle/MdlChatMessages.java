package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlChatMessages generated by hbm2java
 */
public class MdlChatMessages  implements java.io.Serializable {


     private Long id;
     private long timestamp;
     private long chatid;
     private long userid;
     private long groupid;
     private boolean system;
     private String message;

    public MdlChatMessages() {
    }

    public MdlChatMessages(long chatid, long userid, long groupid, boolean system, String message) {
       this.chatid = chatid;
       this.userid = userid;
       this.groupid = groupid;
       this.system = system;
       this.message = message;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public long getTimestamp() {
        return this.timestamp;
    }
    
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    public long getChatid() {
        return this.chatid;
    }
    
    public void setChatid(long chatid) {
        this.chatid = chatid;
    }
    public long getUserid() {
        return this.userid;
    }
    
    public void setUserid(long userid) {
        this.userid = userid;
    }
    public long getGroupid() {
        return this.groupid;
    }
    
    public void setGroupid(long groupid) {
        this.groupid = groupid;
    }
    public boolean isSystem() {
        return this.system;
    }
    
    public void setSystem(boolean system) {
        this.system = system;
    }
    public String getMessage() {
        return this.message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }




}


