package com.example.pmd_se_a_java.SQLiteExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.pmd_se_a_java.R;

import java.util.ArrayList;
import java.util.HashMap;

public class EditContactEntry extends AppCompatActivity {

    EditText firstName, secondName, phoneNumber, emailAddress, homeAddress;

    HashMap<String, String> contact;
    DbTools dbTools;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact_entry);

        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        
        firstName = findViewById(R.id.editfirstname);
        secondName = findViewById(R.id.editsecondname);
        phoneNumber = findViewById(R.id.editphonenumber);
        emailAddress = findViewById(R.id.editemailaddress);
        homeAddress = findViewById(R.id.edithomeaddress);
        
        dbTools = new DbTools(getApplicationContext());
        contact = dbTools.getsingleContact(id);
        
        firstName.setText(contact.get("firstName"));
        secondName.setText(contact.get("secondName"));
        phoneNumber.setText(contact.get("phoneNumber"));
        emailAddress.setText(contact.get("emailAddress"));
        homeAddress.setText(contact.get("homeAddress"));
    }

    public void update(View view) {
        contact.put("firstName", firstName.getText().toString());
        contact.put("secondName", secondName.getText().toString());
        contact.put("phoneNumber", phoneNumber.getText().toString());
        contact.put("emailAddress", emailAddress.getText().toString());
        contact.put("homeAddress", homeAddress.getText().toString());
        dbTools.updateContact(id, contact);
    }


    public void onDelete(View view) {
        int number = dbTools.deleteContact(id);
        if(number != 0){
            Toast.makeText(EditContactEntry.this, "ID : " + id + " deleted", Toast.LENGTH_SHORT).show();
            finish();
        }
        else{
            Toast.makeText(EditContactEntry.this, "An Error Occurred", Toast.LENGTH_SHORT).show();
        }
    }
}

