package com.example.tom.xmpptest.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Tom on 31.03.2015.
 */
public class Account{

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getJabberId() {
        return jabberId;
    }

    public void setJabberId(String jabberId) {
        this.jabberId = jabberId;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Bot getBots() {
        return bots;
    }

    public void setBots(Bot bots) {
        this.bots = bots;
    }


    public long getTimestamp() {
        return timestamp;
    }


    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }


    public long getExpires() {
        return expires;
    }

    public void setExpires(long expires) {
        this.expires = expires;
    }

    public boolean isThrowaway() {
        return throwaway;
    }

    public void setThrowaway(boolean throwaway) {
        this.throwaway = throwaway;
    }

   @SerializedName("type")
    private String type;

   @SerializedName("cid")
    private String cid;

   @SerializedName("user")
    private String user;

    @SerializedName("jabberID")
    private String jabberId;

   @SerializedName("pass")
    private String pass;

   @SerializedName("bots")
    private Bot bots;

    @SerializedName("throwaway")
    private boolean throwaway;


   @SerializedName("timestamp")
   private long timestamp;

   @SerializedName("expires")
   private long expires;


}
