package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Homepage extends AppCompatActivity implements View.OnClickListener {
    private Button profile,Edtprofile,livres,res,blood,complain,dashbo,laptop,course,changepass,logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        Edtprofile=(Button) findViewById(R.id.homeEditprofileButton);
        profile=(Button) findViewById(R.id.HomeProfileButton);
        livres=(Button) findViewById(R.id.homeLiveresButton);
        res=(Button) findViewById(R.id.homeResultButton);
        blood=(Button) findViewById(R.id.homeBloodButton);
        complain=(Button) findViewById(R.id.homecomplinButton);
        dashbo=(Button) findViewById(R.id.homeDashboardButton);
        laptop=(Button) findViewById(R.id.homelaptopButton);
        course=(Button) findViewById(R.id.homeCourseButton);
        changepass=(Button) findViewById(R.id.homeChangepassButton);
        logout=(Button) findViewById(R.id.homeLogoutButton);


        Edtprofile.setOnClickListener(this);
        profile.setOnClickListener(this);
        livres.setOnClickListener(this);
        res.setOnClickListener(this);
        blood.setOnClickListener(this);
        complain.setOnClickListener(this);
        dashbo.setOnClickListener(this);
        laptop.setOnClickListener(this);
        course.setOnClickListener(this);
        changepass.setOnClickListener(this);
        logout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.homeEditprofileButton){
            Intent intent=new Intent(Homepage.this,editprofile.class);
            startActivity(intent);

        }

        else if(v.getId()==R.id.HomeProfileButton){
            Intent inten=new Intent(Homepage.this,profile.class);
            startActivity(inten);

        }

        else if(v.getId()==R.id.homeLiveresButton){
            Intent intent=new Intent(Homepage.this,liveresult.class);
            startActivity(intent);
        }

        else if(v.getId()==R.id.homeResultButton){
            Intent intent=new Intent(Homepage.this,result.class);
            startActivity(intent);
        }

        else if(v.getId()==R.id.homeBloodButton){
            Intent intent=new Intent(Homepage.this,blood.class);
            startActivity(intent);
        }

        else  if(v.getId()==R.id.homecomplinButton){
            Intent intent=new Intent(Homepage.this,MainActivity.class);
            startActivity(intent);
        }

        else  if(v.getId()==R.id.homeDashboardButton){
            Intent intent=new Intent(Homepage.this,MainActivity.class);
            startActivity(intent);
        }

        else if(v.getId()==R.id.homelaptopButton){
            Intent intent=new Intent(Homepage.this,MainActivity.class);
            startActivity(intent);
        }

        else if(v.getId()==R.id.homeCourseButton){
            Intent intent=new Intent(Homepage.this,MainActivity.class);
            startActivity(intent);
        }

        else  if(v.getId()==R.id.homeChangepassButton){
            Intent intent=new Intent(Homepage.this,MainActivity.class);
            startActivity(intent);
        }
        else  if(v.getId()==R.id.homeLogoutButton){
            new user(Homepage.this).remove();
            Intent intent=new Intent(Homepage.this,MainActivity.class);
            startActivity(intent);
            finish();
        }



    }
}
