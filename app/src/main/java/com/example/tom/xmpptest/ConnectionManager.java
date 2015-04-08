package com.example.tom.xmpptest;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Tom on 31.03.2015.
 */
public class ConnectionManager {

    private static RequestQueue queue;

   // private ConnectionManager(){};

    public static RequestQueue getInstance(Context context){

        if(queue == null) {
            queue = Volley.newRequestQueue(context);
        }
        return queue;
    }

}
