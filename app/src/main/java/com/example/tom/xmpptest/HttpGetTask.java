package com.example.tom.xmpptest;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Tom on 31.03.2015.
 */
public class HttpGetTask extends AsyncTask<String,Void, String> {
    private String uri;
    private HttpGetTaskResult listener;

    public HttpGetTask(String uri){
        this.uri = uri;
    }
    public HttpGetTask(String uri,HttpGetTaskResult listener){
        this.uri = uri;
        this.listener = listener;
    }

    @Override
    protected String doInBackground(String... params) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpResponse response;
        String result ="";

        try{
            response = httpClient.execute(new HttpGet(uri));
            InputStream is = response.getEntity().getContent();

            result = inputStreamToString(is);
            Log.d("Hoodown", result);
        }catch (ClientProtocolException e) {


        }catch (IOException e){
            e.printStackTrace();
        }

        return result;
    }

    private String inputStreamToString(InputStream is){
        String line = "";
        StringBuilder total = new StringBuilder();

        BufferedReader rd = new BufferedReader(new InputStreamReader(is));

        try{
            while((line =rd.readLine()) != null){
                total.append(line);
            }
        }catch(IOException e){
            e.printStackTrace();
        }

        return total.toString();
    }
    @Override
    protected void onPostExecute(String s) {
        //super.onPostExecute(s);
        // Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
        this.listener.onHttpGetTaskResult(1,s);
    }
}