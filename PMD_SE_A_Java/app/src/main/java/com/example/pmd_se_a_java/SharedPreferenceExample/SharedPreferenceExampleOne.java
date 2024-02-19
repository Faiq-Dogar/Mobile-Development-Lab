package com.example.pmd_se_a_java.SharedPreferenceExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pmd_se_a_java.R;
import com.google.android.material.snackbar.Snackbar;

public class SharedPreferenceExampleOne extends AppCompatActivity {

    SharedPreferences sharedPreferances;
    TextView textview;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference_example_one);
        textview = findViewById(R.id.txtsharedpreference);
        editText = findViewById(R.id.editsharedepreference);
        sharedPreferances = getSharedPreferences("MyFile2", 0);
    }

    public void SaveMySharedPreferences(View view) {
        SharedPreferences.Editor editor = sharedPreferances.edit();
        String data = editText.getText().toString();
        editor.putString("KEY", data);

        //editor.putInt("A", 100);
        //editor.putString("B", "Ali");
        editor.commit();
        Snackbar.make(view,"Saved", Snackbar.LENGTH_SHORT).show();
    }

    public void ShowMySharedPreferences(View view) {
        //int value = sharedPreferances.getInt("A", 0);
        //String value2 =sharedPreferances.getString("B", "No Value");
        //textview.setText(value + " " + value2);
        textview.setText((sharedPreferances.getString("KEY","No Value")));
    }
}