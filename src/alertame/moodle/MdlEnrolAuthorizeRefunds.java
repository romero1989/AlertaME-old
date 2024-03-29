package alertame.moodle;
// Generated 14/07/2013 19:45:25 by Hibernate Tools 3.2.1.GA



/**
 * MdlEnrolAuthorizeRefunds generated by hbm2java
 */
public class MdlEnrolAuthorizeRefunds  implements java.io.Serializable {


     private Long id;
     private long orderid;
     private boolean status;
     private String amount;
     private Long transid;
     private long settletime;

    public MdlEnrolAuthorizeRefunds() {
    }

	
    public MdlEnrolAuthorizeRefunds(long orderid, boolean status, String amount, long settletime) {
        this.orderid = orderid;
        this.status = status;
        this.amount = amount;
        this.settletime = settletime;
    }
    public MdlEnrolAuthorizeRefunds(long orderid, boolean status, String amount, Long transid, long settletime) {
       this.orderid = orderid;
       this.status = status;
       this.amount = amount;
       this.transid = transid;
       this.settletime = settletime;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public long getOrderid() {
        return this.orderid;
    }
    
    public void setOrderid(long orderid) {
        this.orderid = orderid;
    }
    public boolean isStatus() {
        return this.status;
    }
    
    public void setStatus(boolean status) {
        this.status = status;
    }
    public String getAmount() {
        return this.amount;
    }
    
    public void setAmount(String amount) {
        this.amount = amount;
    }
    public Long getTransid() {
        return this.transid;
    }
    
    public void setTransid(Long transid) {
        this.transid = transid;
    }
    public long getSettletime() {
        return this.settletime;
    }
    
    public void setSettletime(long settletime) {
        this.settletime = settletime;
    }




}


