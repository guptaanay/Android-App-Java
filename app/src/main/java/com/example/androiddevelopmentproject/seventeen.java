package com.example.androiddevelopmentproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class seventeen extends AppCompatActivity {
    EditText e1;
    Button b1;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_seventeen);
        t1 = (TextView) findViewById(R.id.textView19);
        e1 = (EditText) findViewById(R.id.editTextText12);
        b1 = (Button) findViewById(R.id.button21);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                Intent i = new Intent(seventeen.this, nineteen.class);
                i.putExtra("url",s1);
                startActivity(i);
            }
        });
    }
}