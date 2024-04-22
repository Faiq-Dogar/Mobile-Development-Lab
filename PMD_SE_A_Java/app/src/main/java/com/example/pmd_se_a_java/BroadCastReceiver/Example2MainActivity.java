package com.example.pmd_se_a_java.BroadCastReceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Bundle;


import com.example.pmd_se_a_java.R;

public class Example2MainActivity extends AppCompatActivity {

    IncomingCallReceiver incoming;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example2_main);
        incoming = new IncomingCallReceiver();
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.PHONE_STATE");
        registerReceiver(incoming, filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(incoming);
    }
}