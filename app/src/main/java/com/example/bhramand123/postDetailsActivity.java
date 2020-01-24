package com.example.bhramand123;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class postDetailsActivity extends AppCompatActivity {
private TextView placename;
private TextView placedesc;
private TextView poster;
private TextView location;
private ImageView interested;
private DatabaseReference idb;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_details);

        placename=findViewById(R.id.postDetails_postTitle);
        location=findViewById(R.id.textView12);
        poster=findViewById(R.id.postDetails_publisherName);
        placedesc=findViewById(R.id.postDetails_postDescription);
        idb= FirebaseDatabase.getInstance().getReference("places").child("interested");


        interested=findViewById(R.id.imageView6);
        interested.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
