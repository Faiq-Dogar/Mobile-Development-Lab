package com.example.pmd_se_a_java.ListViewExamples;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pmd_se_a_java.R;

public class ListViewExampleOne extends AppCompatActivity {
    ListView listView;
    String[] Names = {"Ali", "Ahmad", "Naveed", "Akram", "Shumaila", "Nabeela", "Asifa"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_example_one);
        listView = findViewById(R.id.mylstone);
        ArrayAdapter adapter =  new ArrayAdapter(this, android.R.layout.simple_list_item_1, Names);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(ListViewExampleOne.this, position + " is clicked ID: " + id, Toast.LENGTH_SHORT).show();
            }
        });
    }
}