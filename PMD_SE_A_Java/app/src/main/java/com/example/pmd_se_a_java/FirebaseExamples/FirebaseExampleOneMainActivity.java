package com.example.pmd_se_a_java.FirebaseExamples;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.pmd_se_a_java.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FirebaseExampleOneMainActivity extends AppCompatActivity {

    DatabaseReference myReference;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_example_one_main);
        textView = findViewById(R.id.txtfirebase);
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://pmd-se-a-java-8aeb8-default-rtdb.firebaseio.com/");
        myReference = database.getReference("Student");
        //myReference.setValue("This is first value");

    }

    public void Send(View view) {
        myReference.setValue("The second value is to be retrieved");
        /*myReference.child("BSSE").child("PMD").child("Student1").setValue("Ali");
        myReference.child("BSCS").child("SMD").child("Student2").setValue("Ahmad");*/
    }

    public void RetrieveValue(View view) {
        myReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                /*String value = snapshot.getValue().toString();
                textView.setText(value);*/
                if(snapshot.getValue() != null){
                    for(DataSnapshot datasnapshot : snapshot.getChildren()){
                        String value = (String) datasnapshot.getValue();
                        /*textView.setText(value + " ");*/
                        Log.d("TAG",""+ value);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}