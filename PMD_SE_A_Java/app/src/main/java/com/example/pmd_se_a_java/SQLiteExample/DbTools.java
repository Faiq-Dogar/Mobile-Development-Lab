package com.example.pmd_se_a_java.SQLiteExample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

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
}
