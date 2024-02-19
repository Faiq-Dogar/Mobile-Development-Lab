package com.example.pmd_se_a_java.SharedPreferenceExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.pmd_se_a_java.R;

public class SPExampleTwoMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spexample_two_main);
    }

    public void SavePref(View view) {
        SharedPreferences preferences = getSharedPreferences("MyFile3", 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("IPhone", "Iphone 11");
        editor.putString("Nokia", "Nokia 10");
        editor.putString("Samsung", "Note 12");
        editor.putString("Oppo", "Node 4");
        editor.putString("Vivo", "Y13");
        editor.putString("Techno", "Camon 15");
        editor.putString("Infinix", "S4");
        editor.putString("Google", "Pixel 7");
        editor.commit();                    //editor.apply wapis 2 le kr atya he
        if(preferences.contains("Oppo") && preferences.contains("IPhone")){
            Intent intent = new Intent(this, SPExampleTwoSecondActivity.class);
            startActivity(intent);
        }
    }
}