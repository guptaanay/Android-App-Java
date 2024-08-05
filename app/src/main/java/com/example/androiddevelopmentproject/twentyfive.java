package com.example.androiddevelopmentproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class twentyfive extends AppCompatActivity implements SensorEventListener{
    TextView t1,t2;
    Button b1;
    MediaPlayer mp;
    SensorManager sm;
    CameraManager cm;
    Sensor s;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_twentyfive);
        mp = MediaPlayer.create(this,R.raw.anim);
        sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        cm = (CameraManager)getSystemService(CAMERA_SERVICE);
        s = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener((SensorEventListener) this,s,SensorManager.SENSOR_DELAY_NORMAL);
        t1 = (TextView) findViewById(R.id.textView28);
        t2 = (TextView) findViewById(R.id.textView29);
        b1 = (Button) findViewById(R.id.button37);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(twentyfive.this,sixteen.class);
                startActivity(i);
            }
        });

    }
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float x = sensorEvent.values[0];
        float y = sensorEvent.values[1];
        float z = sensorEvent.values[2];
        int x1 = (int) x;
        int y1 = (int) y;
        int z1 = (int) z;
        if (x1 > 1) {
            mp.start();
            try {
                String t = cm.getCameraIdList()[0];
                cm.setTorchMode(t, true);
            } catch (CameraAccessException e) {
            }

    }
        else {
            mp.pause();
            try {
                String t = cm.getCameraIdList()[0];
                cm.setTorchMode(t, false);
            }
            catch (CameraAccessException e) {}
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {


    }
}