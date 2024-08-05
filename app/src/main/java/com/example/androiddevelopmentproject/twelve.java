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

public class twelve extends AppCompatActivity {
    TextView t1;
    Button b1;
    EditText e1,e2,e3;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_twelve);
        t1 = (TextView) findViewById(R.id.textView13);
        e1 = (EditText) findViewById(R.id.editTextText7);
        e2 = (EditText) findViewById(R.id.editTextText8);
        e3 = (EditText) findViewById(R.id.editTextText9);
        b1 = (Button)findViewById(R.id.button17);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();
                if (s1.equals("")|| (s2.equals("")) ||(s3.equals(""))){
                    Toast.makeText(twelve.this, "Empty field", Toast.LENGTH_SHORT).show();
                }
                else {
                    SQLiteDatabase db = openOrCreateDatabase("rkgit",MODE_PRIVATE,null);
                    db.execSQL("create table if not exists lkw(email varchar,mobile_no varchar,password varchar)");
                    String query = "select * from lkw where (email = '"+s1+"')";
                    Cursor cursor = db.rawQuery(query,null);
                    if (cursor.getCount()>0){
                        Toast.makeText(twelve.this, "user exists", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        db.execSQL("insert into lkw values ('"+s1+"','"+s2+"','"+s3+"')");
                        Toast.makeText(twelve.this, "Databse updated", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(twelve.this,Seventh.class);
                        startActivity(i);
                        finish();
                    }

                }
            }

        });

    }
}