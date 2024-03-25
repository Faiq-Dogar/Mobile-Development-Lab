package com.example.pmd_se_a_java.FirebaseExamples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.pmd_se_a_java.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseExampleOneMainActivity extends AppCompatActivity {

    DatabaseReference myReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_example_one_main);
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://pmd-se-a-java-8aeb8-default-rtdb.firebaseio.com/");
        myReference = database.getReference();
        //myReference.setValue("This is first value");
        myReference.child("BSSE").child("PMD").child("Student").setValue("Ali");
        myReference.child("BSCS").child("SMD").child("Student").setValue("Ahmad");
    }
}