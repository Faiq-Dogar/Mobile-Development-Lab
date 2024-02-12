package com.example.pmd_se_a_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ForthActivity4 extends AppCompatActivity {

    TextView textview;
    String firstValue;
    String secondValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forth4);
        textview = findViewById(R.id.txtSecondActivity);
        Intent intent = getIntent();
        firstValue = intent.getStringExtra("A");
        secondValue = intent.getStringExtra("B");
        //Toast.makeText(this, "firstValue", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStart(){
        super.onStart();
        textview.setText(firstValue + " " + secondValue);
    }
}