package com.example.pmd_se_a_java.SQLiteExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.pmd_se_a_java.R;

import java.util.ArrayList;
import java.util.HashMap;

public class SQLiteMainActivity extends AppCompatActivity {
    DbTools dbTools;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma_sqlitein);
        dbTools = new DbTools((getApplicationContext()));
        listView = findViewById(R.id.lstmaincontactlist);

        ArrayList<HashMap<String, String>> contactList = dbTools.getAllContacts();
        SimpleAdapter adapter = new SimpleAdapter(this, contactList, R.layout.allcontactslayout, new String[]{"_id", "firstName", "secondName"}, new int[]{R.id.txtdbid,R.id.txtdbfirstname,R.id.txtdbsecondname});
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                Intent intent = new Intent(SQLiteMainActivity.this, EditContactEntry.class);
                intent.putExtra("id", String.valueOf(id + 1));
                startActivity(intent);
            }
        });
    }

    public void AddContact(View view) {
        Intent intent = new Intent(SQLiteMainActivity.this, NewContactEntry.class);
        startActivity(intent);
    }


}