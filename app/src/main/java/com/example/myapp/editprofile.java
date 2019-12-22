package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class editprofile extends AppCompatActivity implements View.OnClickListener {
    private TextView name,nicname,phone,marital,religi,dateof,gender,blood,national,email,fname,mname,fcont,mcont,faocc,maocc,faann,maann,address,post,dist,divi,cont;
    private Button submit;

    profile_database profile;
    MainActivity ma;
//    String id=ma.IID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile);



        name=(EditText) findViewById(R.id.name);
        nicname=(EditText) findViewById(R.id.name);
        phone=(EditText) findViewById(R.id.name);
        marital=(EditText) findViewById(R.id.name);
        religi=(EditText) findViewById(R.id.name);
        dateof=(EditText) findViewById(R.id.name);
        gender=(EditText) findViewById(R.id.name);
        blood=(EditText) findViewById(R.id.name);
        national=(EditText) findViewById(R.id.name);
        email=(EditText) findViewById(R.id.name);
        fname=(EditText) findViewById(R.id.name);
        mname=(EditText) findViewById(R.id.name);
        fcont=(EditText) findViewById(R.id.name);
        mcont=(EditText) findViewById(R.id.name);
        faann=(EditText) findViewById(R.id.name);
        faocc=(EditText) findViewById(R.id.name);
        maocc=(EditText) findViewById(R.id.name);
        maann=(EditText) findViewById(R.id.name);
        address=(EditText) findViewById(R.id.name);
        post=(EditText) findViewById(R.id.name);
        dist=(EditText) findViewById(R.id.name);
        divi=(EditText) findViewById(R.id.name);
        cont=(EditText) findViewById(R.id.name);

        submit=(Button) findViewById(R.id.submit);

        profile=new profile_database(this);
        SQLiteDatabase sql=profile.getWritableDatabase();

        submit.setOnClickListener(this);




    }



    @Override
    public void onClick(View v) {

        String nam=name.getText().toString();
        String nic=nicname.getText().toString();
        String pho=phone.getText().toString();
        String mari=marital.getText().toString();
        String reli=religi.getText().toString();
        String datofb=dateof.getText().toString();
        String gen=gender.getText().toString();
        String bloo=blood.getText().toString();
        String National=national.getText().toString();
        String Email=email.getText().toString();
        String fathername=fname.getText().toString();
        String mothername=mname.getText().toString();
        String facontact=fcont.getText().toString();
        String macontact=mcont.getText().toString();
        String faannual=faann.getText().toString();
        String maannual=maann.getText().toString();
        String faoccapation=faocc.getText().toString();
        String maoccapaton=maocc.getText().toString();
        String Address=address.getText().toString();
        String Post=post.getText().toString();
        String District=dist.getText().toString();
        String Division=divi.getText().toString();
        String contry=cont.getText().toString();


//        Toast.makeText(getApplicationContext(),"Your id is : "+id,Toast.LENGTH_LONG).show();

        if(v.getId()==R.id.submit){

            Boolean chk=profile.updatepersonal(nam, nic, mari, reli,gen,datofb,bloo, National, Email, pho);
            if(chk==true){
                Toast.makeText(getApplicationContext(),"Data is save successfully in editprofile",Toast.LENGTH_LONG).show();
            }

        }



    }
}
