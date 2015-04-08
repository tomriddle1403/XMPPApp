package com.example.tom.xmpptest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.tom.xmpptest.model.Account;
import com.example.tom.xmpptest.model.City;
import com.example.tom.xmpptest.model.RealmStore;
import com.example.tom.xmpptest.model.XMPPCredential;
import com.google.gson.Gson;

import io.realm.Realm;


public class MainActivity extends Activity {

    private Realm realm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        /*
        * Databse connect example
        * */

        Realm.deleteRealmFile(this);
        realm = Realm.getInstance(this);





    }

    public void showStatus(String msg)
    {
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void LogIn(View v){


        String url = "http://hoodownr.com/clientlogin/client.json?cid=1&lat=1&lon=1&user=tomppa@hastur.org&timestamp=1";

        StringRequest request = new StringRequest(url,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

               XMPPCredential.credential = new Gson().fromJson(response, XMPPCredential.class) ;


               String msg = "Credentials was received successfully";
                if(XMPPCredential.credential != null) {
                    storeToRealm();
                    Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                }

            }
          }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }

        });

        ConnectionManager.getInstance(this).add(request);
    }

    private void loadJsonFromString() {
        String json = "{ city: \"Aarhus\", votes: 99 }";

        realm.beginTransaction();
        realm.createObjectFromJson(City.class, json);
        realm.commitTransaction();
    }

    private void storeToRealm(){

        Account account = XMPPCredential.credential.getAccount();

        realm.beginTransaction();

            RealmStore xmpp = realm.createObject(RealmStore.class);
            xmpp.setUser(account.getUser());
            xmpp.setOperator(account.getBots().getOperator());
            xmpp.setPass(account.getPass());
            xmpp.setJabberId(account.getJabberId());
            xmpp.setCid(account.getCid());
            xmpp.setExpires(account.getExpires());
            xmpp.setThrowaway(account.isThrowaway());
            xmpp.setTimestamp(account.getTimestamp());
            xmpp.setType(account.getType());

        realm.commitTransaction();
    }

    public void basicQuery(View v) {
        showStatus("\nPerforming basic Query operation...");

        RealmStore account = realm.where(RealmStore.class).findFirst();
       Toast.makeText(MainActivity.this, account.getUser(), Toast.LENGTH_SHORT).show();
        Log.d("account", account.getUser());
    }



}
