package com.example.pmd_se_a_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("TAG", "OnCreateIsCalled");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TAG","OnStartIsCalled");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TAG","OnPauseIsCalled");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TAG","OnRestartIsCalled");
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void Next(View view) {
        //Intent intent = new Intent(this, MainActivity3.class);
        //startActivity(intent);
       // Toast.makeText(this, "This is my first Toast", Toast.LENGTH_SHORT).show();

        /*Intent intent = new Intent(this, ForthActivity4.class);
        intent.putExtra("A","First Value");
        intent.putExtra("B","Second Value");
        startActivity(intent);

        Snackbar.make(view, "This is my first snackbar", Snackbar.LENGTH_SHORT).show();*/
    }


}