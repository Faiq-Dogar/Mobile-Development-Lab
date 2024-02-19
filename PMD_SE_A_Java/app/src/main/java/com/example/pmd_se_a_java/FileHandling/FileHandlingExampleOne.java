package com.example.pmd_se_a_java.FileHandling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pmd_se_a_java.R;
import com.google.android.material.snackbar.Snackbar;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class FileHandlingExampleOne extends AppCompatActivity {

    EditText edittext;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_handling_example_one);
        edittext = findViewById(R.id.edtFileHandling);
        textView = findViewById(R.id.txtFileHandling);
    }
    public void SaveIntoFile(View view) {
        String data = edittext.getText().toString();
        try {
            FileOutputStream fileOutputStream = openFileOutput("MyTextFile", Context.MODE_PRIVATE);
            fileOutputStream.write(data.getBytes());
            Snackbar.make(view, "Data Saved", Snackbar.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void ShowFromFile(View view) {
        String ReadData  ="";
        try {
            FileInputStream inputStream = openFileInput("MyTextFile");
            InputStreamReader reader = new InputStreamReader(inputStream);
            BufferedReader bufferReader = new BufferedReader(reader);
            String value = bufferReader.readLine();
            if(value == null){
                Snackbar.make(view, "No Value Found", Snackbar.LENGTH_SHORT).show();
            }
            else{
                while(value != null){
                    ReadData = ReadData + value;
                    value = bufferReader.readLine();
                }
                bufferReader.close();
                reader.close();
                inputStream.close();
            }
            textView.setText(ReadData);
            textView.setText(ReadData);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}