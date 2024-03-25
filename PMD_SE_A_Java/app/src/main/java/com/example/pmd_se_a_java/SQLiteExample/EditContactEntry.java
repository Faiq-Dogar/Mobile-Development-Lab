package com.example.pmd_se_a_java.SQLiteExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.example.pmd_se_a_java.R;

import java.util.HashMap;

public class EditContactEntry extends AppCompatActivity {

    DbTools dbTools;
    EditText firstName, secondName, phoneNumber, emailAddress, homeAddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact_entry);
        dbTools = new DbTools(getApplicationContext());
        Intent intent = getIntent();
        String id  = intent.getStringExtra("id");
        HashMap<String, String> singleContact = dbTools.getsingleContact(id);
    }
}