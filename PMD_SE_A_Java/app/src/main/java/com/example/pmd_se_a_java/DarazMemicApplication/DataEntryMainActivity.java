package com.example.pmd_se_a_java.DarazMemicApplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.pmd_se_a_java.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class DataEntryMainActivity extends AppCompatActivity {

    EditText name, company, price;
    ImageView imageView;
    Button button1, button2;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference database;
    modelClass modelObj;
    Bitmap bitmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_entry_main);
        name = findViewById(R.id.nameeditText);
        company = findViewById(R.id.companyeditText);
        price = findViewById(R.id.priceeditText);
        imageView = findViewById(R.id.imageView);
        modelObj = new modelClass();
        firebaseDatabase = FirebaseDatabase.getInstance("https://task-daraz-default-rtdb.firebaseio.com/");
        database = firebaseDatabase.getReference("Product");


    }

    public void Save(View view) {
        modelObj.setName(name.getText().toString());
        modelObj.setCompany(company.getText().toString());
        modelObj.setPrice(price.getText().toString());

        database.child(modelObj.getName()).setValue(modelObj).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(DataEntryMainActivity.this, "Data Saved", Toast.LENGTH_LONG).show();
            }
        });

    }

    public void takePic(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, 102);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 102 && resultCode == RESULT_OK){
            try {
                InputStream inputStream = getContentResolver().openInputStream(data.getData());
                if(bitmap != null){
                    bitmap.recycle();
                }
                bitmap = BitmapFactory.decodeStream(inputStream);
                imageView.setImageBitmap(bitmap);
                modelObj.setByteArray(bitmap.toString());

            }catch (FileNotFoundException e){
                e.printStackTrace();
            }
        }
    }


    public void dispaly(View view) {

    }

}