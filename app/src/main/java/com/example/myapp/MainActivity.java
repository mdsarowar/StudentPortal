package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText id, pass;
    private Button log,reg;
    String IID;

    registrationdata registration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id=(EditText) findViewById(R.id.logpagid);
        pass=(EditText) findViewById(R.id.logpagepass);

        log=findViewById(R.id.logpagLogButton);
        reg=findViewById(R.id.logpagRegButton);

       registration=new registrationdata(this);
        SQLiteDatabase sql=registration.getWritableDatabase();

        log.setOnClickListener(this);
        reg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

       String ID=id.getText().toString();
        String pa=pass.getText().toString();

        if(v.getId()==R.id.logpagLogButton){

            if(ID.equals(" ")&&pa.equals(" ")){
                Toast.makeText(getApplicationContext(),"please enter username & password",Toast.LENGTH_LONG).show();
            }
            else {
                user use = new user(MainActivity.this);
                use.setId(ID);
                use.setPass(pa);


                boolean bol = registration.check(ID, pa);
                if (bol == true) {
                    IID=ID;
                    Toast.makeText(getApplicationContext(),"id or password is CORRECT ",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, Homepage.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(),"id or password is incorrect ",Toast.LENGTH_LONG).show();
                }
            }

        }

        else if(v.getId()==R.id.logpagRegButton){
            Intent intent=new Intent(MainActivity.this,Regpage.class);
            startActivity(intent);

        }

    }
}
