package com.example.androiddevelopmentproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class thirteen extends AppCompatActivity {
    TextView t1;
    EditText e1,e2;
    Button b1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_thirteen);
        t1 = (TextView) findViewById(R.id.textView14);
        e1 = (EditText) findViewById(R.id.editTextText10);
        e2 = (EditText) findViewById(R.id.editTextText11);
        b1 = (Button) findViewById(R.id.button18);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s2 = e1.getText().toString();
                String s3 = e2.getText().toString();
                if ((s2.equals("")) || (s3.equals(""))) {
                    Toast.makeText(thirteen.this, "Empty field", Toast.LENGTH_SHORT).show();
                } else {
                    SQLiteDatabase db = openOrCreateDatabase("rkgit", MODE_PRIVATE, null);
                    db.execSQL("create table if not exists lkw(email varchar,mobile_no varchar,password varchar)");
                    String query = "select * from lkw where (email = '" + s2 + "' and password = '" + s3 + "')";
                    Cursor cursor = db.rawQuery(query, null);
                    if (cursor.getCount() > 0) {
                        Toast.makeText(thirteen.this, "login", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(thirteen.this, Seventh.class);
                        startActivity(i);
                        finish();
                    } else {
                        Toast.makeText(thirteen.this, "invalid details", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });



    }
}