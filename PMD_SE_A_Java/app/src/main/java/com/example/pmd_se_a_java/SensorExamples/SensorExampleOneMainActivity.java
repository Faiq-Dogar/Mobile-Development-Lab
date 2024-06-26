package com.example.pmd_se_a_java.SensorExamples;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.pmd_se_a_java.R;

public class SensorExampleOneMainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager sensorManager;
    boolean color = false;
    View view;
    long lastTimeUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_example_one_main);
        lastTimeUpdate = System.currentTimeMillis();
        view = findViewById(R.id.txtsensor);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            getMyAccelerometerValues(event);
        }
    }

    private void getMyAccelerometerValues(SensorEvent event) {
        float[] values = event.values;
        float x = values[0];
        float y = values[1];
        float z = values[2];
        float acceleration = (x*x + y*y + z*z)/(SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);
        long actualTime = event.timestamp;
        if(acceleration >= 2){
            if(actualTime - lastTimeUpdate < 150){
                return;
            }
            lastTimeUpdate = actualTime;
            Toast.makeText(this,"Device was moved", Toast.LENGTH_SHORT).show();
            if(color)
            {
                view.setBackgroundColor(Color.RED);
            }
            else{
                view.setBackgroundColor(Color.GREEN);
            }
            color = !color;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}