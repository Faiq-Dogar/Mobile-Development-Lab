package com.example.pmd_se_a_java.staticFragmentExample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.pmd_se_a_java.CommunicationBwFragments.ButtonPressListener;
import com.example.pmd_se_a_java.CommunicationBwFragments.SecondFragment;
import com.example.pmd_se_a_java.R;

public class MyContactsMainActivity extends AppCompatActivity implements Contacts.ListSelectionListener {

    public static String[] contactsArray;
    public static String[] contactDetails;
    public ContatcsDetails contactDetailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_contacts_main);
        SecondFragment secondFragment = (SecondFragment) getSupportFragmentManager().findFragmentById(R.id.fragment2);
        //secondFragment.onFragmentInteraction(message);
        contactsArray = getResources().getStringArray(R.array.contacts_array);
        contactDetails = getResources().getStringArray(R.array.details_array);
        contactDetailFragment = (ContatcsDetails) getSupportFragmentManager().findFragmentById(R.id.contactsdetails);
    }

    @Override
    public void onSelection(int position) {
        if(contactDetailFragment.getshowIndex() != position){
            contactDetailFragment.ContactIndex(position);
        }
    }
}