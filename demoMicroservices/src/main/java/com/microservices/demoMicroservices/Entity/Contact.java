package com.microservices.demoMicroservices.Entity;

public class Contact {
    private long cid;
    private String cname;
    private String cemail;
    private long userId;

    public Contact(long cid, String cname, String cemail, long userId) {
        this.cid = cid;
        this.cname = cname;
        this.cemail = cemail;
        this.userId = userId;
    }

    public Contact() {
    }

    public long getCid() {
        return cid;
    }

    public void setCid(long cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCemail() {
        return cemail;
    }

    public void setCemail(String cemail) {
        this.cemail = cemail;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
