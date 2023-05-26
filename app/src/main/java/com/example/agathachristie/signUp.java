package com.example.agathachristie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class signUp extends AppCompatActivity {

    Button sumbit;
    EditText User_name , E_mail , Password , re_Password , Phone_num;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference().child("Users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        User_name = findViewById(R.id.editTextText2);
        E_mail = findViewById(R.id.editTextText4);
        Password = findViewById(R.id.editTextText5);
        re_Password = findViewById(R.id.editTextText7);
        Phone_num = findViewById(R.id.editTextText3);

        sumbit = findViewById(R.id.button6);
        sumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(User_name.getText().toString())) {
                    Toast.makeText(signUp.this, "Please enter your name",
                            Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(E_mail.getText().toString())) {
                    Toast.makeText(signUp.this, "Please enter your e-mail",
                            Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(Password.getText().toString())) {
                    Toast.makeText(signUp.this, "Please enter your password",
                            Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(re_Password.getText().toString())) {
                    Toast.makeText(signUp.this, "Please confirm your password",
                            Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(Phone_num.getText().toString())) {
                    Toast.makeText(signUp.this, "Please enter your phone number",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(signUp.this,
                            "Now, you become one of our worlds:)",
                            Toast.LENGTH_SHORT).show();
                }

                String name = User_name.getText().toString();
                String email_ = E_mail.getText().toString();
                String password_ = Password.getText().toString();
                String phonenum_ = Phone_num.getText().toString();

                HashMap<String, String> usersMap = new HashMap<>();
                usersMap.put("name", name);
                usersMap.put("email", email_);
                usersMap.put("password", password_);
                usersMap.put("phone", phonenum_);

                myRef.push().setValue(usersMap, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                        if (databaseError != null) {
                            // Error occurred
                            Log.e("Firebase", "Data could not be saved: " + databaseError.getMessage());
                        } else {
                            // Data sent successfully
                            Log.d("Firebase", "Data saved successfully.");
                        }
                    }
                });
            }
        });
    }
}







