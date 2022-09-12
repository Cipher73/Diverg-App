package com.example.divergeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ChangePassword extends AppCompatActivity {
    EditText email;
    Button reset;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        reset=findViewById(R.id.reset);
        email=findViewById(R.id.email_pass);
        mAuth = FirebaseAuth.getInstance();

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passwordReset();
            }
        });
    }
    private void passwordReset() {

        String e_mail = email.getText().toString().trim();
        if(e_mail.isEmpty()){
            email.setError("please enter email");
            email.requestFocus();
            return;
        }

        if(!(Patterns.EMAIL_ADDRESS.matcher(e_mail).matches())){
            email.setError("invalid email! Try Again");
            email.requestFocus();
            return;
        }
        mAuth.sendPasswordResetEmail(e_mail).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(ChangePassword.this, "Email sent! Please Check Email", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(ChangePassword.this, "failed try again!", Toast.LENGTH_LONG).show();

                }
            }
        });

    }
}