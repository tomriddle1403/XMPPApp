package com.example.tom.xmpptest.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Tom on 01.04.2015.
 */
public class Bot {

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @SerializedName("operator")
    private String operator;
}
