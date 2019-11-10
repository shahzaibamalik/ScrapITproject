package com.example.scrapit;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "eproject.db";
    private static final String TABLE_NAME = "Tb_user";
    private static final String RATETABLE_NAME = "Tb_Ad_pro";

    public DBhelper(Context context) {
        super(context, DATABASE_NAME, null, 2);
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME +
                " (ID INTEGER PRIMARY KEY AUTOINCREMENT ," +
                " NAME TEXT ," +
                " MOBILE_NUMBER INTEGER ," +
                " PASSWORD TEXT ," +
                " EMAIL TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        //db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("CREATE TABLE " + RATETABLE_NAME +
                " (ID INTEGER PRIMARY KEY AUTOINCREMENT ," +
                " NAME TEXT ," +
                " RATE TEXT )");
        //onCreate(db);
    }
    public boolean insertContact(String name, int phone,String pass, String email)
    {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME", name);
        contentValues.put("MOBILE_NUMBER", phone);
        contentValues.put("PASSWORD", pass);
        contentValues.put("EMAIL", email);

        long result =sqLiteDatabase.insert("Tb_user", null, contentValues);

        if (result == -1)
            return false ;
        else
            return  true ;

    }

    public Cursor getData(String phone)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        String query ="SELECT * FROM Tb_User WHERE MOBILE_NUMBER =' " + phone +" '  ";

        // Cursor res =  sqLiteDatabase.rawQuery( query, null );
        Cursor res =  db.rawQuery( query, null );
        return res;
    }
    public void deleteData (String phone)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        sqLiteDatabase.delete(TABLE_NAME," MOBILE_NUMBER =' " + phone +" '  ",null);
        sqLiteDatabase.close();
    }
    public void updateData (String name, String phone,String pass, String email)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put("NAME", name);
        contentValues.put("PASSWORD", pass);
        contentValues.put("EMAIL", email);

        sqLiteDatabase.update(TABLE_NAME,contentValues,"MOBILE_NUMBER ='" + phone +"'  ",null);
        sqLiteDatabase.close();

    }

    //Add product work
    public boolean insertproduct (String name,  String rate)
    {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME", name);
        contentValues.put("RATE", rate);


        long result =sqLiteDatabase.insert("Tb_Ad_pro", null, contentValues);

        if (result == -1)
            return false ;
        else
            return  true ;

    }

    public Cursor getProData(String name)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        String query ="SELECT * FROM Tb_Ad_pro WHERE NAME =' " + name +" '  ";

        // Cursor res =  sqLiteDatabase.rawQuery( query, null );
        Cursor res =  db.rawQuery( query, null );
        return res;
    }
    public Cursor getRateListContents()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor data=db.rawQuery("SELECT * FROM "+RATETABLE_NAME,null);
        return data;
    }
}


