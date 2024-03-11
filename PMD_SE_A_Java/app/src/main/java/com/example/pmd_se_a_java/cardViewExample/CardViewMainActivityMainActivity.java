package com.example.pmd_se_a_java.cardViewExample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.pmd_se_a_java.R;

import java.util.ArrayList;
import java.util.List;

public class CardViewMainActivityMainActivity extends AppCompatActivity {

    public List<My_Model> list;
    public AdapterCardView adapterCardView;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view_main_main);
        recyclerView = findViewById(R.id.mycardviewrecyclerview);
        list = new ArrayList<>();
        adapterCardView = new AdapterCardView(this, list);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapterCardView);
        insert();
    }

    public void insert(){
        int[] thumbnails = new int[]
                {
                        R.drawable.icon,R.drawable.icon,
                        R.drawable.icon,R.drawable.icon,
                        R.drawable.icon,R.drawable.icon
                };
        My_Model myModel = new My_Model("My First Item", 10, thumbnails[0]);
        list.add(myModel);
        myModel = new My_Model("My Second Item", 10, thumbnails[0]);
        list.add(myModel);
        myModel = new My_Model("My Third Item", 10, thumbnails[0]);
        list.add(myModel);
        myModel = new My_Model("My Forth Item", 10, thumbnails[0]);
        list.add(myModel);
        myModel = new My_Model("My Fifth Item", 10, thumbnails[0]);
        list.add(myModel);
        myModel = new My_Model("My Sixth Item", 10, thumbnails[0]);
        list.add(myModel);
    }
}