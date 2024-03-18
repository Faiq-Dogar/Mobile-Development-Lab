package com.example.pmd_se_a_java.SQLiteExample;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.HashMap;

public class DbTools extends SQLiteOpenHelper {
    public DbTools(Context context){
        super(context,"ContactsDB", null ,1);
        Log.d("TAG", "Database Created");
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createdQuery = "CREATE TABLE CONTACTS("+
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "firstName TEXT," +
                "secondName TEXT,"+
                "phoneNumber TEXT,"+
                "emailAddress TEXT," +
                "homeAddress TEXT)";
        db.execSQL(createdQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void AddContact(HashMap<String, String> contact){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", contact.get("_id"));
        contentValues.put("firstName",contact.get("firstName"));
        contentValues.put("secondName",contact.get("secondName"));
        contentValues.put("phoneNumber",contact.get("phoneNumber"));
        contentValues.put("emailAddress",contact.get("emailAddress"));
        contentValues.put("homeAddress",contact.get("homeAddress"));

        long i = db.insert("CONTACTS",null,contentValues);
        if(i != -1){
            Log.d("TAG", "New Contact inserted with _id " + i);
        }
        else{
            Log.d("TAG", "New Contact insertion is failed");
        }
        //db.close();
    }
}
