package com.example.androiddevelopmentproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class fourth extends AppCompatActivity {
    TextView t1;
    EditText e1,e2;
    Button b1;
    FirebaseAuth firebaseAuth;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fourth);
        t1 = (TextView) findViewById(R.id.textView10);
        e1 = (EditText) findViewById(R.id.editTextText5);
        e2 = (EditText) findViewById(R.id.editTextText6);
        e2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        firebaseAuth = FirebaseAuth.getInstance();
        b1 = (Button) findViewById(R.id.button12);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString().trim();
                String s2 = e2.getText().toString();
                if (s1.isEmpty()){
                    e1.setError("please fill email field");
                    return;
                }
                else {
                    if (s2.isEmpty()){
                        e2.setError("enter password");
                        return;
                    }
                    else {
                        firebaseAuth.createUserWithEmailAndPassword(s1,s2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(fourth.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                    Intent i = new Intent(fourth.this,fifth.class);
                                    startActivity(i);
                                    finish();
                                }
                                else{
                                    Toast.makeText(fourth.this, "Error Occured", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                }
            }
        });



    }
}