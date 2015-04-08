package com.example.tom.xmpptest.model;

import io.realm.RealmObject;

/**
 * Created by Tom on 07.04.2015.
 */
public class City extends RealmObject {

    private String name;
    private long votes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getVotes() {
        return votes;
    }

    public void setVotes(long votes) {
        this.votes = votes;
    }

}

