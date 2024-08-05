package com.example.androiddevelopmentproject;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class fifteen extends AppCompatActivity {
    ToggleButton t3;
    Button b1,b2,b3,b4,b5,b6,b7;
    CameraManager cm;
    WifiManager wm;
    BluetoothAdapter ba;
    Vibrator v;
    Boolean torch =false;
    Boolean wifi =false;

    @SuppressLint({"MissingInflatedId", "ServiceCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fifteen);
        b6 = (Button) findViewById(R.id.button36);
        b7 = (Button) findViewById(R.id.button35);
        t3 = (ToggleButton) findViewById(R.id.toggleButton3);
        b5 = (Button) findViewById(R.id.button33);
        b1 = (Button) findViewById(R.id.button23);
        b2 = (Button) findViewById(R.id.button24);
        b3 = (Button) findViewById(R.id.button28);
        b4 = (Button) findViewById(R.id.button26);
        cm = (CameraManager)getSystemService(CAMERA_SERVICE);
        wm = (WifiManager)getSystemService(WIFI_SERVICE);
        ba = BluetoothAdapter.getDefaultAdapter();
        v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (torch == false){
                    try {
                        String s1 = cm.getCameraIdList()[0];
                        cm.setTorchMode(s1,true);
                    }
                    catch (CameraAccessException e){

                    }
                    torch = true;
                }
                else{
                    try {
                        String s1 = cm.getCameraIdList()[0];
                        cm.setTorchMode(s1,false);
                    }
                    catch (CameraAccessException e){

                    }
                    torch = false;

                }

            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (wifi == false){
                    if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.Q){
                        Intent pan = new Intent(Settings.Panel.ACTION_WIFI);
                        startActivityForResult(pan,0);
                    }
                    else {
                        wm.setWifiEnabled(true);
                    }
                }
                else {
                    if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.Q){
                        Intent pan=new Intent(Settings.Panel.ACTION_WIFI);
                        startActivityForResult(pan,0);

                    }
                    else {
                        wm.setWifiEnabled(false);
                    }
                }

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(fifteen.this,twenty.class);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(fifteen.this, twentyone.class);
                startActivity(j);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(fifteen.this, twentytwo.class);
                startActivity(k);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                if (vibrator != null) {
                    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
                        vibrator.vibrate(VibrationEffect.createOneShot(5000,VibrationEffect.DEFAULT_AMPLITUDE));
                    } else {
                        vibrator.vibrate(5000);
                    }
                }
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(fifteen.this, twentythree.class);
                startActivity(a);

            }
        });
    }
}