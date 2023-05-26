package com.example.agathachristie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class Books extends AppCompatActivity {

    GridView gridView;
    String [] books = {"I can make this promise ", "Acts of love and war" , "An orphans war" ,
                       "Remember me","Remember Love" ,"Address"};
    int [] books_images = {R.drawable.book1 , R.drawable.book2 , R.drawable.book3 ,
                           R.drawable.book4 , R.drawable.book5 , R.drawable.book6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);

        gridView = findViewById(R.id.gridView);
        customAdapter customAdapter = new customAdapter();
        gridView.setAdapter(customAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext() , Activity_Books_items.class);
                intent.putExtra("name" , books[i] );
                intent.putExtra("image" , books_images[i] );
                startActivity(intent);
            }
        });

    }

    private class customAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return books_images.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1 = getLayoutInflater().inflate(R.layout.rows_data , null);
            TextView name = view1.findViewById(R.id.books);
            ImageView imageView = view1.findViewById(R.id.Books_images);

            name.setText(books[i]);
            imageView.setImageResource(books_images[i]);

            return view1;
        }
    }

}