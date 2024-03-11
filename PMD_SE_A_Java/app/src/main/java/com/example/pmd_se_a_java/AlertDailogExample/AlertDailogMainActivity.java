package com.example.pmd_se_a_java.AlertDailogExample;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pmd_se_a_java.R;

public class AlertDailogMainActivity extends AppCompatActivity {

    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dailog_main);
        button = findViewById(R.id.btnalertdailog);
        textView = findViewById(R.id.txtalertdailog);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AlertDailogMainActivity.this);
                builder.setMessage("Are you sure...").setPositiveButton("OK", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dailog, int which){
                        textView.setText("2000");
                    }
                }).setNegativeButton("cancel",null);
                AlertDialog alert = builder.create();
                alert.show();

            }
        });
    }

}