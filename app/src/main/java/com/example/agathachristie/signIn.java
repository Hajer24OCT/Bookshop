package com.example.agathachristie;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signIn extends AppCompatActivity {

    Button signupbtn, signinbtn;
    EditText email, password;

    FirebaseAuth mAuth;

    TextView reset_password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        signinbtn = findViewById(R.id.button2);
        email = findViewById(R.id.editTextText);
        password = findViewById(R.id.editTextText6);

        mAuth = FirebaseAuth.getInstance();

        reset_password = findViewById(R.id.textView5);



        signinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userEmail = email.getText().toString();
                String userPassword = password.getText().toString();

                if (TextUtils.isEmpty(userEmail)) {
                    Toast.makeText(signIn.this, "Please enter your email", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(userPassword)) {
                    Toast.makeText(signIn.this, "Please enter your password", Toast.LENGTH_SHORT).show();
                } else {
                    mAuth.signInWithEmailAndPassword(userEmail, userPassword)
                            .addOnCompleteListener(signIn.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign-in success, update UI with the signed-in user's information
                                        Toast.makeText(signIn.this, "Sign-in successful!", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(signIn.this, Books.class));
                                        finish();
                                    } else {
                                        // Sign-in failed, display a message to the user
                                        Toast.makeText(signIn.this, "Sign-in failed. Please check your credentials.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });

        signupbtn = findViewById(R.id.signupbtn);
        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext() , signUp.class);
                startActivity(intent);
            }
        });


        reset_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext() , ResetPasswordActivity.class);
                startActivity(intent);
            }
        });
    }
}





