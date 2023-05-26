package com.example.agathachristie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signIn extends AppCompatActivity {

    Button signupbtn , signinbtn;
    EditText name , password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        signinbtn=findViewById(R.id.button2);
        name = findViewById(R.id.editTextText);
        password = findViewById(R.id.editTextText6);
        signinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(name.getText().toString()) || TextUtils.isEmpty(password.getText().toString())){
                    Toast.makeText(signIn.this, "Empty field not allowed!",
                    Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(signIn.this,
                            "Proceed..",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });


        signupbtn = findViewById(R.id.signupbtn);
        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), signUp.class);
                startActivity(i);
            }
        });

    }
}