package com.example.pmd_se_a_java.SharedPreferenceExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.pmd_se_a_java.R;

import java.util.ArrayList;

public class SPExampleTwoSecondActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spexample_two_second);
        listView = findViewById(R.id.lstSharedPreferernces);
        SharedPreferences sharedPreferences = getSharedPreferences("MyFile3", 0);
        String Oppo = sharedPreferences.getString("Oppo", " ");
        String Nokia = sharedPreferences.getString("Nokia", " ");
        String IPhone = sharedPreferences.getString("IPhone", " ");
        String Samsung = sharedPreferences.getString("Samsung", " ");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(Oppo);
        arrayList.add(Nokia);
        arrayList.add(IPhone);
        arrayList.add(Samsung);
        ArrayAdapter<String> adpater = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(adpater);
    }
}