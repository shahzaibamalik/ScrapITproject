package com.example.scrapit;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.scrapit.adapters.Users;

import java.util.Date;

public class DBhelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "eproject.db";
    private static final String TABLE1_NAME = "Tb_user";
    private static final String TABLE2_NAME = "Tb_item";
    private static final String TABLE3_NAME = "Tb_appointment";
    private static final String TABLE4_NAME = "Tb_scrap";


    public DBhelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE1_NAME +
                " (ID INTEGER PRIMARY KEY AUTOINCREMENT ," +
                " NAME TEXT ," +
                " MOBILE_NUMBER TEXT ," +
                " PASSWORD TEXT ," +
                "EMAIL TEXT," +
                "CNIC TEXT," +
                "AGE TEXT," +
                "GENDER TEXT," +
                "ROLE TEXT," +
                "STATUS TEXT," +
                " ADDRESS TEXT)");

        db.execSQL("CREATE TABLE " + TABLE2_NAME +
                " (ID INTEGER PRIMARY KEY AUTOINCREMENT ," +
                " NAME TEXT ," +
                " RATE TEXT)");

        db.execSQL("CREATE TABLE " + TABLE3_NAME +
                " (ID INTEGER PRIMARY KEY AUTOINCREMENT ," +
                " CONTACT TEXT ," +
                "ADDRESS TEXT," +
                "STATUS TEXT," +
                " ASSIGN TEXT)");

        db.execSQL("CREATE TABLE " + TABLE4_NAME +
                " (ID INTEGER PRIMARY KEY AUTOINCREMENT ," +
                " DATE DATE ," +
                "SC_ID TEXT," +
                "USER_ID TEXT," +
                "RATE TEXT," +
                "WEIGHT_ID TEXT," +
                " AMOUNT TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE1_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE2_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE3_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE4_NAME);
        onCreate(db);
    }
    public boolean insertUser(String name, String phone, String pass, String email, String cnic, String address, String age, String gender, String role, String status)
    {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME", name);
        contentValues.put("MOBILE_NUMBER", phone);
        contentValues.put("PASSWORD", pass);
        contentValues.put("EMAIL", email);
        contentValues.put("CNIC", cnic);
        contentValues.put("AGE", age);
        contentValues.put("GENDER", gender);
        contentValues.put("ROLE", role);
        contentValues.put("STATUS", status);
        contentValues.put("ADDRESS", address);

        long result =sqLiteDatabase.insert("Tb_user", null, contentValues);

        if (result == -1)
            return false ;
        else
            return  true ;

    }

    public boolean insertItem(String name, String rate)
    {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME", name);
        contentValues.put("RATE", rate);


        long result =sqLiteDatabase.insert("Tb_item", null, contentValues);

        if (result == -1)
            return false ;
        else
            return  true ;

    }

    public boolean insertAppointment(String contact, String address,  String assign, String status)
    {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("CONTACT", contact);
        contentValues.put("ASSIGN", assign);
        contentValues.put("STATUS", status);
        contentValues.put("ADDRESS", address);

        long result =sqLiteDatabase.insert("Tb_appointment", null, contentValues);

        if (result == -1)
            return false ;
        else
            return  true ;

    }



    public boolean insertScrap(String date1, String SC_ID, String User_Id,String Rate, String Weight, String Amount)
    {


        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();


        contentValues.put("DATE", date1);
        contentValues.put("SC_ID", SC_ID);
        contentValues.put("USER_ID", User_Id);
        contentValues.put("RATE", Rate);
        contentValues.put("WEIGHT", Weight);
        contentValues.put("AMOUNT", Amount);


        long result =sqLiteDatabase.insert("Tb_scrap", null, contentValues);

        if (result == -1)
            return false ;
        else
            return  true ;

    }



    public void getData(SharedPreferencesHelper pref, String phone, String password)
    {
        SQLiteDatabase db = this.getReadableDatabase();
         String query ="SELECT * FROM Tb_User WHERE MOBILE_NUMBER = '"+phone+"' AND PASSWORD = '"+password+"' ";

        // Cursor res =  sqLiteDatabase.rawQuery( query, null );
        try
        {
            Cursor res =  db.rawQuery( query, null );
            if(res!=null && res.moveToFirst() ){

                Users users = new Users();

                users.setId(res.getString(res.getColumnIndex("ID")));
                users.setName(res.getString(res.getColumnIndex("NAME")));
                users.setPhoneno(res.getString(res.getColumnIndex("MOBILE_NUMBER")));
                users.setPassword(res.getString(res.getColumnIndex("PASSWORD")));
                users.setEmail(res.getString(res.getColumnIndex("EMAIL")));
                users.setCnic(res.getString(res.getColumnIndex("CNIC")));
                users.setAge(res.getString(res.getColumnIndex("AGE")));
                users.setGender(res.getString(res.getColumnIndex("GENDER")));
                users.setRole(res.getString(res.getColumnIndex("ROLE")));
                users.setStatus(res.getString(res.getColumnIndex("STATUS")));
                users.setAddress(res.getString(res.getColumnIndex("ADDRESS")));

                pref.putAuthData(users);

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void deleteData (String phone)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        sqLiteDatabase.delete(TABLE1_NAME," MOBILE_NUMBER =' " + phone +" '  ",null);
        sqLiteDatabase.close();
    }
    public boolean updateScData (String name, String phone, String pass, String email, String address, String age)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put("NAME", name);
        contentValues.put("PASSWORD", pass);
        contentValues.put("EMAIL", email);
        contentValues.put("MOBILE_NUMBER", phone);

        contentValues.put("AGE",age);

        contentValues.put("ADDRESS",address );



        sqLiteDatabase.update(TABLE1_NAME,contentValues,"MOBILE_NUMBER== ='" + phone +"'  ",null);
        sqLiteDatabase.close();

        return false;
    }

    public Cursor getRateListContents()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor data=db.rawQuery("SELECT * FROM "+TABLE2_NAME,null);
        return data;
    }

    public Cursor getUserReportListContents()
    {
        SQLiteDatabase db=this.getWritableDatabase();



        // Cursor data=db.rawQuery(query,null);
        Cursor data=db.rawQuery("SELECT * FROM "+TABLE4_NAME ,null);
        return data;
    }

    public Cursor getScrapReportListContents()
    {
        SQLiteDatabase db=this.getWritableDatabase();


        // Cursor data=db.rawQuery(query,null);
        Cursor data=db.rawQuery("SELECT * FROM "+TABLE4_NAME ,null);
        return data;
    }

}


