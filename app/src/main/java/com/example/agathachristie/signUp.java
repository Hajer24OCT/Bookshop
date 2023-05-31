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
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signUp extends AppCompatActivity {

    Button sumbit ;
    TextView login;
    EditText User_name , E_mail , Password , re_Password , Phone_num;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference().child("Users");
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        User_name = findViewById(R.id.editTextText2);
        E_mail = findViewById(R.id.editTextText4);
        Password = findViewById(R.id.editTextText5);
        re_Password = findViewById(R.id.editTextText7);
        Phone_num = findViewById(R.id.editTextText3);

        sumbit = findViewById(R.id.button6);
        sumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = User_name.getText().toString();
                String email_ = E_mail.getText().toString();
                String password_ = Password.getText().toString();
                String repassword_ = re_Password.getText().toString();
                String phonenum_ = Phone_num.getText().toString();

                boolean isMatched = password_.equals(repassword_);

                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(signUp.this, "Please enter your name", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(email_)) {
                    Toast.makeText(signUp.this, "Please enter your e-mail", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(password_)) {
                    Toast.makeText(signUp.this, "Please enter your password", Toast.LENGTH_SHORT).show();
                }else if (TextUtils.isEmpty(repassword_)) {
                    Toast.makeText(signUp.this, "Please confirm your password", Toast.LENGTH_SHORT).show();
                    if (isMatched) {
                    } else {
                        Toast.makeText(getApplicationContext(), "Password incorrect", Toast.LENGTH_SHORT).show();
                    }
                } else if (TextUtils.isEmpty(phonenum_)) {
                    Toast.makeText(signUp.this, "Please enter your phone number", Toast.LENGTH_SHORT).show();
                } else {

                    mAuth.createUserWithEmailAndPassword(email_, password_)
                            .addOnCompleteListener(signUp.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // User creation success
                                        FirebaseUser currentUser = mAuth.getCurrentUser();
                                        String userId = currentUser.getUid();

                                        // Save user details to Firebase Database under "Users" node
                                        DatabaseReference userRef = myRef.child(userId);
                                        userRef.child("name").setValue(name);
                                        userRef.child("email").setValue(email_);
                                        userRef.child("password").setValue(password_);
                                        userRef.child("phone").setValue(phonenum_);

                                        Toast.makeText(signUp.this, "Registration successful!", Toast.LENGTH_SHORT).show();

                                        startActivity(new Intent(signUp.this, signIn.class));
                                        finish();
                                    } else {
                                        // User creation failed
                                        Toast.makeText(signUp.this, "Registration failed. Please try again.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }

        });
        login = findViewById(R.id.textView3);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext() , signIn.class);
                startActivity(intent);
            }
        });

    }


}







