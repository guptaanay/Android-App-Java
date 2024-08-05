package com.example.androiddevelopmentproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class twentyeight extends AppCompatActivity {
    TextView t1,t2,t3;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_twentyeight);
        t1 = (TextView) findViewById(R.id.textView33);
        t2 = (TextView) findViewById(R.id.textView35);
        t3 = (TextView) findViewById(R.id.textView34);
        b = (Button) findViewById(R.id.button40);
        String s1 = Integer.toString(eighteen.score);
        t3.setText(s1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(twentyeight.this, eighteen.class);
                startActivity(i);
            }
        });



    }
}