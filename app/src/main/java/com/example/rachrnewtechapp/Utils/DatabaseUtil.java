package com.example.rachrnewtechapp.Utils;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

import com.example.rachrnewtechapp.Model.StatusResponse;
import com.example.rachrnewtechapp.Model.UserDto;

public class DatabaseUtil  {

    private static final String DB_NAME = "RachtrTechApp";
    private static final int DB_VERSION = 2;

    static SQLiteDatabase db;
    static MyHelper helper;

    public DatabaseUtil(Context context) {
        System.out.println("context " + context);
        helper = new MyHelper(context);
        db = helper.getWritableDatabase();

    }

    public void close() {
        helper.close();
    }

    public long saveDeviceRegistationDetails(UserDto userDto) {
        db = helper.getWritableDatabase();

        long rowId = 0;

        String query = String.format("INSERT INTO DEVICE_LOGIN VALUES(?,?,?);");

        SQLiteStatement stmt = db.compileStatement(query);

        try {


            stmt.bindString(1, userDto.getUserName());
            stmt.bindString(2, userDto.getPassword());
            stmt.bindString(3, userDto.getUserType());




            rowId = stmt.executeInsert();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rowId;


    }

    public long saveStatusResponse(StatusResponse statusResponse) {
        db = helper.getWritableDatabase();

        long rowId = 0;

        String query = String.format("INSERT INTO STATUS_RESPONSE VALUES(?,?,?,?);");

        SQLiteStatement stmt = db.compileStatement(query);

        try {

            stmt.bindString(1, statusResponse.getDepartmentName());
            stmt.bindString(2, statusResponse.getDepartmentId());
            stmt.bindString(3, statusResponse.getUserId());
            stmt.bindString(4, statusResponse.getUserName());



            rowId = stmt.executeInsert();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rowId;


    }


    public UserDto fetchRegisteredDeviceData() {


        UserDto userDto = new UserDto();

        db = helper.getReadableDatabase();
        String query = "";



        query = String.format("select * from DEVICE_LOGIN");



        Cursor c = db.rawQuery(query, null);

        if (c!=null && c.getCount() >0){
            if (c.moveToFirst()) {

                do {
                    userDto.setUserName (c.getString (c.getColumnIndexOrThrow("userName")));
                    userDto.setPassword (c.getString (c.getColumnIndexOrThrow ("password")));
                    userDto.setUserType (c.getString (c.getColumnIndexOrThrow ("userType")));
                } while (c.moveToNext());

            }
        }

        c.close();

        return userDto;


    }


    public StatusResponse fetchStatusData() {


        StatusResponse statusResponse = new StatusResponse();

        db = helper.getReadableDatabase();
        String query = "";



        query = String.format("select * from STATUS_RESPONSE");



        Cursor c = db.rawQuery(query, null);

        if (c!=null && c.getCount() >0){
            if (c.moveToFirst()) {

                do {
                    statusResponse.setDepartmentName(c.getString (c.getColumnIndexOrThrow("departmentName")));
                    statusResponse.setDepartmentId(c.getString(c.getColumnIndexOrThrow("departmentId")));
                    statusResponse.setUserId(c.getString(c.getColumnIndexOrThrow("userId")));
                    statusResponse.setUserName(c.getString(c.getColumnIndexOrThrow("userName")));


                } while (c.moveToNext());

            }
        }

        c.close();

        return statusResponse;


    }


    public static void truncateTable(String table) {
        db.execSQL("DELETE FROM " + table);
    }

    public class MyHelper extends SQLiteOpenHelper {

        public MyHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            System.out.println("create db----");
             try {
                 sqLiteDatabase.execSQL("CREATE TABLE if not exists DEVICE_LOGIN"
                         + "(" + "userName VARCHAR(20),"
                         + "password VARCHAR(15),"
                         + "userType VARCHAR(25)"
                         + ");");


                 sqLiteDatabase.execSQL("CREATE TABLE if not exists STATUS_RESPONSE"
                         + "(" + "departmentName VARCHAR(25),"
                         + "departmentId VARCHAR(30),"
                         + "userId VARCHAR(30),"
                         + "userName VARCHAR(30)"
                         + ");");

             }catch(Exception e){
                 e.printStackTrace();
             }

        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            onCreate(sqLiteDatabase);
        }
    }


}
