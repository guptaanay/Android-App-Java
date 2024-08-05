package com.example.androiddevelopmentproject;

import android.content.Intent;
import android.os.Bundle;
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
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class ten extends AppCompatActivity {
    TextView t1;
    EditText e1;
    Button b1, b2;
    String Phone;
    String otp;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ten);
        Phone = getIntent().getStringExtra("Mobile").toString();
        t1 = (TextView)findViewById(R.id.textView9);
        e1 = (EditText) findViewById(R.id.editTextText4);
        b1 = (Button) findViewById(R.id.button10);
        b2 = (Button) findViewById(R.id.button11);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ten.this, sixth.class);
                startActivity(i);
                finish();
            }
        });
        firebaseAuth = FirebaseAuth.getInstance();
        genotp();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                PhoneAuthCredential credential = PhoneAuthProvider.getCredential(otp, s1);
                SigninwithPhoneAuthCredential(credential);
            }
        });
    }

    private void genotp() {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                Phone,
                60,
                TimeUnit.SECONDS,
                this,
                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    @Override
                    public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                        otp = s;
                        super.onCodeSent(s, forceResendingToken);
                    }

                    @Override
                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                        SigninwithPhoneAuthCredential(phoneAuthCredential);

                    }

                    @Override
                    public void onVerificationFailed(@NonNull FirebaseException e) {
                        Toast.makeText(ten.this, "OTP is not correct", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
    private void  SigninwithPhoneAuthCredential(PhoneAuthCredential credential) {
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(ten.this, "OTP generated Successfully", Toast.LENGTH_SHORT).show();
                    Intent j = new Intent(ten.this, Seventh.class);
                    startActivity(j);
                    finish();
                } else {
                    Toast.makeText(ten.this, "Unsuccessfull,try Again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}