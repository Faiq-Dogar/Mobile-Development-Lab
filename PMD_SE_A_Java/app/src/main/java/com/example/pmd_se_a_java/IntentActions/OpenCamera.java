package com.example.pmd_se_a_java.IntentActions;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import com.example.pmd_se_a_java.R;

public class OpenCamera extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_camera);
        imageView = findViewById(R.id.imgOpenCamera); //binding
    }

    public void Camera(View view) {
        Intent intent =  new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,101); //Activity pr wapis ane or result wapis lane ke lie

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 101){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(bitmap);
        }
    }
}