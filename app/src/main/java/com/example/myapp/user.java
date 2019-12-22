package com.example.myapp;

import android.content.Context;
import android.content.SharedPreferences;

public class user {

    SharedPreferences shar;
    Context con;
    public user(Context context) {
        this.con=context;
        shar=con.getSharedPreferences("login",con.MODE_PRIVATE);

    }

    public String getId() {
        id=shar.getString("id"," ");
        return id;
    }

    public void setId(String id) {
        this.id = id;
        shar.edit().putString("id",id).commit();
    }

    public String getPass() {
       pass= shar.getString("pass",pass);
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
        shar.edit().putString("pass",pass).commit();
    }



    public void remove(){
        shar.edit().clear().commit();
    }
    private String id,pass;
}
