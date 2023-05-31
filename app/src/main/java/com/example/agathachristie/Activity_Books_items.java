package com.example.agathachristie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity_Books_items extends AppCompatActivity {

    TextView name , details;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_items);

        name = findViewById(R.id.griddata);
        image = findViewById(R.id.imageView);
        details = findViewById(R.id.textView4);

        Intent intent = getIntent();
        name.setText(intent.getStringExtra("name"));
        image.setImageResource(intent.getIntExtra("image" ,0));
        details.setText(intent.getStringExtra("details"));
    }
}