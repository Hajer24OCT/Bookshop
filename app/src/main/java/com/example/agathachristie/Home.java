package com.example.agathachristie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    Button signin_btn , signup_btn , book_btn , deliveryOption_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        signin_btn = findViewById(R.id.signin_btn);
        signin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), signIn.class);
                startActivity(i);
            }
        });

        signup_btn = findViewById(R.id.signup_btn);
        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), signUp.class);
                startActivity(i);
            }
        });

        book_btn = findViewById(R.id.button3);
        book_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Books.class);
                startActivity(i);
            }
        });


        deliveryOption_btn = findViewById(R.id.button5);
        deliveryOption_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), DeliveryOptions.class);
                startActivity(i);
            }
        });

    }
}