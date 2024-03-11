package com.example.pmd_se_a_java.staticFragmentExample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.pmd_se_a_java.CommunicationBwFragments.ButtonPressListener;
import com.example.pmd_se_a_java.CommunicationBwFragments.SecondFragment;
import com.example.pmd_se_a_java.R;

public class MyContactsMainActivity extends AppCompatActivity implements ButtonPressListener.OnButtonPressListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_contacts_main);
    }

    @Override
    public void onButtonPressed(String message) {
        SecondFragment secondFragment = (SecondFragment) getSupportFragmentManager().findFragmentById(R.id.fragment2);
        secondFragment.onFragmentInteraction(message);
    }
}