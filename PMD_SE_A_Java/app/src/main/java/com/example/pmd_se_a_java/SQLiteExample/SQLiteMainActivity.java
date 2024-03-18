package com.example.pmd_se_a_java.SQLiteExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.pmd_se_a_java.R;

public class SQLiteMainActivity extends AppCompatActivity {
    DbTools dbTools;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma_sqlitein);
        dbTools = new DbTools((getApplicationContext()));
        listView = findViewById(R.id.lstmaincontactlist);
    }

    public void AddContact(View view) {
        Intent intent = new Intent(SQLiteMainActivity.this, NewContactEntry.class);
        startActivity(intent);
    }
}