package com.example.androiddevelopmentproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Seventh extends AppCompatActivity {
    ImageView i1;
    ImageButton a1,a2,a3;
    TextView t1,t2,t3;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_seventh);
        i1 = (ImageView) findViewById(R.id.imageView5);
        a1 = (ImageButton) findViewById(R.id.imageButton);
        a2 = (ImageButton) findViewById(R.id.imageButton2);
        a3 = (ImageButton) findViewById(R.id.imageButton3);
        t1 = (TextView) findViewById(R.id.textView15);
        t2 = (TextView) findViewById(R.id.textView16);
        t3 = (TextView) findViewById(R.id.textView17);
        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Seventh.this,fourteen.class);
                startActivity(i);
            }
        });
        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(Seventh.this,fifteen.class);
                startActivity(j);
            }
        });
        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(Seventh.this,twentyfive.class);
                startActivity(k);

            }
        });
//        a2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent l = new Intent(Seventh.this,)
//            }
//        });


    }
}