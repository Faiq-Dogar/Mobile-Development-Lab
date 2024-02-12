package com.example.pmd_se_a_java.ListViewExamples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.pmd_se_a_java.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MultiColumnListView extends AppCompatActivity {
    ListView listView;
    public ArrayList<HashMap<String, String>> list;

    public static final String First_Column = "First";
    public static final String Second_Column = "Second";
    public static final String Third_Column = "Third";
    public static final String Forth_Column = "Forth";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_column_list_view);
        listView = findViewById(R.id.mylstmulticolumn);
        LoadValues();
        MyListAdapter adpter = new MyListAdapter(list, this);
        listView.setAdapter(adpter);
    }

    public void LoadValues(){
        list = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> hashMap1 = new HashMap<>();
        hashMap1.put(First_Column, "Faiq");
        hashMap1.put(Second_Column, "Shumaila");
        hashMap1.put(Third_Column, "Nabeela");
        hashMap1.put(Forth_Column, "Nazia");
        list.add(hashMap1);

        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put(First_Column, "Faiq");
        hashMap2.put(Second_Column, "Shumaila");
        hashMap2.put(Third_Column, "Nabeela");
        hashMap2.put(Forth_Column, "Nazia");
        list.add(hashMap2);

        HashMap<String, String> hashMap3 = new HashMap<>();
        hashMap3.put(First_Column, "Faiq");
        hashMap3.put(Second_Column, "Shumaila");
        hashMap3.put(Third_Column, "Nabeela");
        hashMap3.put(Forth_Column, "Nazia");
        list.add(hashMap3);

    }
}