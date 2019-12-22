package com.example.myapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class profile_database extends SQLiteOpenHelper {

    MainActivity main;

    private static final String student_profile="profile.db";
    private static final String student_personal="personal";
    private static final String student_parants="Parants";
    private static final String student_address="address";
    private static final String student_blood="address-address";
    private static final int vers=1;

    private static final String id="ID";


    private static final String nam="Name";
    private static final String nic="Nick_name";
    private static final String  pho="Phone";
    private static final  String mari="Marital_status";
    private static final String reli="Religion";
    private static final String datofb="Date of Birth";
    private static final String gen="Gender";
    private static final String blood="Blood";
    private static final String national="Nationality";
    private static final String email="Email";
    private static final String fathername="Father_name";
    private static final String mothername="Mother_name";
    private static final String facontact="Father_contct";
    private static final String macontact="Mother_contact";
    private static final String faannual="Father_Income";
    private static final String maannual="Mother_Income";
    private static final String faoccapation="Fateher_Occapation";
    private static final  String maoccapaton="Mother_Occapation";
    private static final String address="Address";
    private static final String post="Post_Office";
    private static final String district="District";
    private static final String division="Division";
    private static final String  country="Country";



    private static final String create_personal="CREATE table "+student_personal+"("+id+" varchar(255) primary key ,"+nam+" varchar(255) ,"+nic+" varchar(255),"+mari+" varchar(255),"+reli+" varchar(255),"+gen+" varchar(255),"+datofb+" varchar(255),"+blood+" varchar(255),"+national+" varchar(255),"+email+" varchar(255),"+pho+" varchar(255)) ";
    private static final String create_parants="CREATE table "+student_parants+"("+id+" varchar(255) primary key,"+fathername+" varchar(255),"+facontact+" varchar(255),"+faoccapation+" varchar(255),"+faannual+" varchar(255),"+mothername+" varchar(255),"+macontact+" varchar(255),"+maoccapaton+" varchar(255),"+maannual+" varchar(255)) ";
    private static final String create_address="CREATE table "+student_address+"("+id+" varchar(255) primary key,"+address+" varchar(255),"+post+" varchar(255),"+district+" varchar(255),"+division+" varchar(255),"+country+" varchar(255)) ";
  //  private static final String create_blood="CREATE table "+student_blood+"("+id+" primary key ,"+nam+" varchar(255),"+pho+" varchar(255),"+blood+" varchar(255),"+email+" varchar(255)) ";

    private static final String drop_personal ="Drop table if exists "+student_personal;
    private static final String drop_parantrs ="Drop table if exists "+student_parants;
    private static final String drop_address ="Drop table if exists "+student_address;



    private static final String view_personal= "Select * from "+student_personal;
    private static final String view_parants= "Select * from "+student_parants;
    private static final String view_address= "Select * from "+student_address;

    Context cot;
    public profile_database(@Nullable Context context) {
        super(context, student_profile, null, vers);
        this.cot=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            Toast.makeText(cot,"oncreate method is open successfually in edit profile",Toast.LENGTH_LONG).show();
            db.execSQL(create_personal);
            db.execSQL(create_parants);
            db.execSQL(create_address);


        }catch (Exception e){
            Toast.makeText(cot,"oncreate method is not  successfully open  in edit profile "+e,Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try{
            Toast.makeText(cot,"onupgrate method is open successfually in edit profile ",Toast.LENGTH_LONG).show();
            db.execSQL(drop_personal);
            db.execSQL(drop_parantrs);
            db.execSQL(drop_address);
            onCreate(db);
        }catch (Exception e){
            Toast.makeText(cot,"onupgrate method is not unsuccessfully open in edit profile "+e,Toast.LENGTH_LONG).show();
        }

    }
    public boolean updatepersonal(String na,String ni,String marit,String relis,String gend,String dateo,String blllo,String natlity,String em,String phhh){

//        String i=main.IID;
        SQLiteDatabase sqldata=this.getWritableDatabase();
        ContentValues allv=new ContentValues();

        allv.put(nam,na);
        allv.put(nic,ni);
        allv.put(mari,marit);
        allv.put(reli,relis);
        allv.put(gen,gend);
        allv.put(datofb,dateo);
        allv.put(blood,blllo);
        allv.put(national,natlity);
        allv.put(email,em);
        allv.put(pho,phhh);
        //sqldata.update(student_personal,allv,nam+" = ?",new String[]{na});


        return true;
    }
}
