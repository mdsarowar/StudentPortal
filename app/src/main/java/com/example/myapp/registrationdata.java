package com.example.myapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class registrationdata extends SQLiteOpenHelper {

    private static final String student_login="student.db";
    private static final String student_table="allstudent";
    private static final int vers=2;

    private static final String id="ID";
    private static final String name="NAME";
    private static final String email="EMAIL";

    private static final String pass="PASSWORD";

    private static final String con_pass="confirm_password";


    private static final String create="CREATE table "+student_table+"("+id+" primary key ,"+name+" varchar(255),"+email+" varchar(255),"+pass+" varchar(255),"+con_pass+" varchar(255)) ";
    private static final String drop ="Drop table if exists "+student_table;


    private static final String view= "Select * from "+student_table;

    Context cont;
    public registrationdata(@Nullable Context context) {
        super(context, student_login, null, vers);
        this.cont=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            Toast.makeText(cont,"oncreate method is open successfually",Toast.LENGTH_LONG).show();
            db.execSQL(create);


        }catch (Exception e){
            Toast.makeText(cont,"oncreate method is not  successfully open "+e,Toast.LENGTH_LONG).show();
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try{
            Toast.makeText(cont,"onupgrate method is open successfually",Toast.LENGTH_LONG).show();
            db.execSQL(drop);
            onCreate(db);
        }catch (Exception e){
            Toast.makeText(cont,"onupgrate method is not unsuccessfully open"+e,Toast.LENGTH_LONG).show();
        }

    }

    public long inser(String Id,String na,String em,String pa){
        SQLiteDatabase sql=this.getWritableDatabase();

        ContentValues allval=new ContentValues();
        allval.put(id,Id);
        allval.put(name,na);
        allval.put(email,em);
        allval.put(pass,pa);

//        allval.put(name,da.getName());
//        allval.put(email,da.getEmail());
//        allval.put(username,da.getUsername());
//        allval.put(pass,da.getPassword());

        long row =sql.insert(student_table,null,allval);
        return row;


    }

    public boolean check(String id,String pas){

        SQLiteDatabase sql=this.getReadableDatabase();

        Cursor cor=sql.rawQuery(view,null);
        boolean bll=false;

        if(cor.getCount()==0){
            Toast.makeText(cont,"no data here",Toast.LENGTH_LONG).show();
        }
        else{
            while(cor.moveToNext()){
                String ID=cor.getString(0);
                String pass=cor.getString(3);

                if(ID.equals(id)&& pass.equals(pas)){
                    bll=true;
                    break;
                }

            }
        }
        return bll;
    }

}
