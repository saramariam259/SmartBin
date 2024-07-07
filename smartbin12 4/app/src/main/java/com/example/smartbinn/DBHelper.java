package com.example.smartbinn;


import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "Login.db";
    public DBHelper(Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users(username TEXT primary key, password TEXT,houseno number,name TEXT,address TEXT,locality TEXT,city TEXT,mobileno number)");
        MyDB.execSQL("create Table drivers(driverid TEXT primary key, password TEXT,name TEXT,address TEXT,city TEXT,mobileno number,aadhar number,username TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists users");
        MyDB.execSQL("drop Table if exists drivers");
    }



    public Boolean insertData(String username, String password,String houseno,String name,String address,String locality,String city,String mobileno){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("houseno",houseno);
        contentValues.put("name",name);
        contentValues.put("address",address);
        contentValues.put("locality",locality);
        contentValues.put("city",city);
        contentValues.put("mobileno",mobileno);

        long result = MyDB.insert("users", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }

    public Boolean insertdriverData(String driverid, String password,String name,String address,String city,String mobileno,String aadhar,String username){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("driverid", driverid);
        contentValues.put("password", password);
        contentValues.put("name",name);
        contentValues.put("address",address);
        contentValues.put("city",city);
        contentValues.put("mobileno",mobileno);
        contentValues.put("aadhar",aadhar);
        contentValues.put("username",username);

        long result = MyDB.insert("drivers", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }
        public boolean checkUser(String mobileno){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from users where mobileno=?",new String[]{mobileno});
            if (cursor.getCount() > 0)
                return true;
            else
                return false;
        }
    public Boolean checkusername(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[]{username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public String myprofilehouse(String username) {

        String name2;
        SQLiteDatabase MyDB = this.getReadableDatabase();
        Cursor cursor = MyDB.rawQuery("Select houseno from users where username = ?", new String[]{username});
        cursor.moveToFirst();
        name2 = cursor.getString(0);
        return name2;
    }

    public String myprofilename(String username) {

        String name2;
        SQLiteDatabase MyDB = this.getReadableDatabase();
        Cursor cursor = MyDB.rawQuery("Select name from users where username = ?", new String[]{username});
        cursor.moveToFirst();
        name2 = cursor.getString(0);
        return name2;
    }
    public String myprofilead(String username) {

        String name2;
        SQLiteDatabase MyDB = this.getReadableDatabase();
        Cursor cursor = MyDB.rawQuery("Select address from users where username = ?", new String[]{username});
        cursor.moveToFirst();
        name2 = cursor.getString(0);
        return name2;
    }
    public String myprofilelo(String username) {

        String name2;
        SQLiteDatabase MyDB = this.getReadableDatabase();
        Cursor cursor = MyDB.rawQuery("Select locality from users where username = ?", new String[]{username});
        cursor.moveToFirst();
        name2 = cursor.getString(0);
        return name2;
    }
    public String myprofilect(String username) {

        String name2;
        SQLiteDatabase MyDB = this.getReadableDatabase();
        Cursor cursor = MyDB.rawQuery("Select city from users where username = ?", new String[]{username});
        cursor.moveToFirst();
        name2 = cursor.getString(0);
        return name2;
    }
    public String myprofilemobile(String username) {

        String name2;
        SQLiteDatabase MyDB = this.getReadableDatabase();
        Cursor cursor = MyDB.rawQuery("Select mobileno from users where username = ?", new String[]{username});
        cursor.moveToFirst();
        name2 = cursor.getString(0);
        return name2;
    }


    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[] {username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean checkdriver(String username){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from drivers where username = ?", new String[]{username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkusepnamepassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from drivers where username = ? and password = ?", new String[] {username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public List<String> getAllUserNames() {
        List<String> userList = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT username FROM users", null);

        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") String username = cursor.getString(cursor.getColumnIndex("username"));
                userList.add(username);
            } while (cursor.moveToNext());
        }

        cursor.close();
        return userList;
    }
    public Cursor getUserDetails(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {"houseno", "name", "address", "locality", "city", "mobileno"};
        String selection = "username=?";
        String[] selectionArgs = {username};

        return db.query("users", columns, selection, selectionArgs, null, null, null);
    }
}
