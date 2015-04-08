package com.example.tom.xmpptest.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Tom on 31.03.2015.
 */
public class XMPPCredential{

    public static XMPPCredential credential;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @SerializedName("account")
   private Account account;


}
