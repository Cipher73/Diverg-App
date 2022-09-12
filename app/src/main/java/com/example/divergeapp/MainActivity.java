package com.example.divergeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    Button signin,btnSignup;
    EditText password;
    EditText Email;
    TextView changepass;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signin=findViewById(R.id.btnSignin);
        btnSignup=findViewById(R.id.btnSignup);
        changepass=findViewById(R.id.changepass);

        imageView=findViewById(R.id.showpass);
        changepass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ChangePassword.class));
            }
        });

        password = findViewById(R.id.password);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(password.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())){
                    imageView.setImageResource(R.drawable.see);
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else{
                    imageView.setImageResource(R.drawable.hide);
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

        Email=findViewById(R.id.email);
        mAuth = FirebaseAuth.getInstance();

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SignUp.class));
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });

    }
    private void Login() {

        String pass= password.getText().toString().trim();
        String email = Email.getText().toString().trim();

        if(email.isEmpty()){
            Email.setError("email is required");
            Email.requestFocus();
            return;
        }

        if(!(Patterns.EMAIL_ADDRESS.matcher(email).matches())){
            Email.setError("invalid email");
            Email.requestFocus();
            return;
        }
        if (pass.isEmpty()) {
            password.setError("password is required");
            password.requestFocus();
            return;
        }
        if (pass.length() < 8) {
            password.setError("password is too short (min is 8 characters)");
            password.requestFocus();
            return;
        }
        mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(MainActivity.this,"welcome",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(MainActivity.this,StoreActivity.class));
                }
                else{
                    Toast.makeText(MainActivity.this,"failed to login! Try again!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }


}