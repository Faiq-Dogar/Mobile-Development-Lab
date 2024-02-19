package com.example.pmd_se_a_java.ListViewExamples.ImageAndTextViewExample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.pmd_se_a_java.R;

public class ImageAndTextMainActivity extends AppCompatActivity {

    ListView listview;
    String[] Name = {"Faiq", "Rafay", "Aneeqa", "Adil", "Wasil"};

    String[] Text = {"Message from Faiq", "Message from Rafay", "Message from Aneeqa", "Message from Adil", "Message from Wasil"};

    Integer[] Image = {R.drawable.icon, R.drawable.icon, R.drawable.icon, R.drawable.icon, R.drawable.icon};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_and_text_main);
        listview = findViewById(R.id.lstimagandtext);
        ImageAndTextAdapter adapter = new ImageAndTextAdapter(this, Name, Text, Image);
        listview.setAdapter(adapter);
    }
}