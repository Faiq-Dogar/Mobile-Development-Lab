package com.example.pmd_se_a_java.RecyclerViewExample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.pmd_se_a_java.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewMainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    List<MyMobile> mobileList = new ArrayList<>();

    AdapterRecyclerView adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_main);

        recyclerView = findViewById(R.id.myrecylerview);
        adapter = new AdapterRecyclerView(mobileList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        AddMobiles();
        }

    public void AddMobiles(){
        MyMobile myMobileobj = new MyMobile("IPhone 12", "Apple", "400000");
        mobileList.add(myMobileobj);
        myMobileobj = new MyMobile("IPhone 13","Apple","500000");
        mobileList.add(myMobileobj);
        myMobileobj = new MyMobile("Vivo","vivo","500000");
        mobileList.add(myMobileobj);
        myMobileobj = new MyMobile("Note 20","Samsung","500000");
        mobileList.add(myMobileobj);
        myMobileobj = new MyMobile("Note 24","Samsung","400000");
        mobileList.add(myMobileobj);
        myMobileobj = new MyMobile("Note 10","Samsung","300000");
        mobileList.add(myMobileobj);
        adapter.notifyDataSetChanged();
    }
}