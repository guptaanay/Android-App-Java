package com.example.androiddevelopmentproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class twentythree extends AppCompatActivity {
    TextView t1;
    Button b1;
    VideoView v1;
    MediaController s1;
    Uri u1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_twentythree);
        v1 = (VideoView) findViewById(R.id.videoView);
        b1 = (Button) findViewById(R.id.button34);
        t1 = (TextView) findViewById(R.id.textView25);
        s1 = new MediaController(this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivityForResult(i,99);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultcode ,@Nullable Intent data){
        super.onActivityResult(requestCode,resultcode, data);
        if (requestCode == 99 ){
            u1= data.getData();
            v1.setMediaController(s1);
            s1.setAnchorView(v1);
            v1.setVideoURI(u1);
            v1.start();
        }
        else {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
    }
}