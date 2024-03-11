package com.example.pmd_se_a_java.asyncClassActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.pmd_se_a_java.R;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class webContentDownloadMainActivity extends AppCompatActivity {

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_content_download_main2);
        editText = findViewById(R.id.edtmultilineweb);
    }

    public void Download_WebContent(View view) throws ExecutionException, InterruptedException {
        DownloadWebContent obj = new DownloadWebContent();
       String WebContent = obj.execute("https://www.google.com").get();
        Log.d("TAG","Back in Main Activity");
        editText.setText(WebContent);

    }

    class DownloadWebContent extends AsyncTask<String, Void, String> {
        protected  String doInBackground(String... strings){
            Log.d("TAG","DoInBackground in Process....");
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream inputStream = connection.getInputStream();
                InputStreamReader reader = new InputStreamReader(inputStream);
                int data = reader.read();
                String webContent = "";
                while (data != -1)
                {
                    char c;
                    c = (char) data;
                    webContent += c;
                }
                return webContent;
            } catch(MalformedURLException e){
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}