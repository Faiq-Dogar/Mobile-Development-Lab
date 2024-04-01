package com.example.pmd_se_a_java.FirebaseExamples;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.pmd_se_a_java.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FirebaseExampleTwoMainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    ArrayList<Student> studentArrayList;
    FirebaseDatabase database;
    DatabaseReference reference;
    FirebaseAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_example_two_main);
        recyclerView = findViewById(R.id.firebaserecyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);


        /*database = FirebaseDatabase.getInstance("https://console.firebase.google.com/project/pmd-se-a-java-8aeb8/database/pmd-se-a-java-8aeb8-default-rtdb/data/~2F");*/
        database = FirebaseDatabase.getInstance("https://pmd-se-a-java-8aeb8-default-rtdb.firebaseio.com/");
        reference = database.getReference("Student");
        studentArrayList = new ArrayList<>();
        LoadData();
    }
    public void LoadData(){
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Student obj = new Student();
                    obj.setName(dataSnapshot.child("Name").getValue().toString());
                    obj.setUrl(dataSnapshot.child("Picture").getValue().toString());
                    studentArrayList.add(obj);
                }
                adapter = new FirebaseAdapter(studentArrayList, getApplicationContext());
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}