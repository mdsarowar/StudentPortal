package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Regpage extends AppCompatActivity implements View.OnClickListener {

    private EditText edname,edid,edemail,edpa,edconpass,userna;
    private Button sineup;
    registrationdata data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regpage);

        edname=(EditText) findViewById(R.id.RegpagName);
        edid=(EditText) findViewById(R.id.RegpagId);
        edemail=(EditText) findViewById(R.id.RegpagEmail);
//        userna=(EditText) findViewById(R.id.RegpagUserna);
        edpa=(EditText) findViewById(R.id.RegpagPass);

        sineup=findViewById(R.id.RegpagButton);

        data=new registrationdata(this);
        SQLiteDatabase sql=data.getWritableDatabase();


        sineup.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        String id=edid.getText().toString();
        String na=edname.getText().toString();
        String em=edemail.getText().toString();
        String pa=edpa.getText().toString();

        long passdata= data.inser(id,na,em,pa);
        if(passdata== -1){
            Toast.makeText(getApplicationContext(),"Data is not save successfully",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"Data is  save successfully",Toast.LENGTH_LONG).show();
            Intent in=new Intent(Regpage.this,MainActivity.class);
            startActivity(in);
        }


    }
}
