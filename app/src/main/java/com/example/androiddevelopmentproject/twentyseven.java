package com.example.androiddevelopmentproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class twentyseven extends AppCompatActivity {
    RadioButton r1,r2,r3,r4;
    Button b;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_twentyseven);
        r1 = (RadioButton) findViewById(R.id.radioButton5);
        r2 = (RadioButton) findViewById(R.id.radioButton6);
        r3 = (RadioButton) findViewById(R.id.radioButton7);
        r4 = (RadioButton) findViewById(R.id.radioButton8);
        b = (Button) findViewById(R.id.button39);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (r4.isChecked()){
                    ++eighteen.score;
                }
                else{
                    --eighteen.score;
                }
                Intent i = new Intent(twentyseven.this, twentyeight.class);
                startActivity(i);
                finish();
            }
        });

    }
}