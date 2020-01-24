package com.example.bhramand123;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class EventDetailsActivity extends AppCompatActivity {
private ImageView eventflex;
private TextView eventname;
private TextView eventdesc;
private TextView eventdate;
private TextView locationlink;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);
        eventflex=findViewById(R.id.imageView5);
        eventname=findViewById(R.id.textView6);
        eventdesc=findViewById(R.id.textView10);
        eventdate=findViewById(R.id.textView8);
        locationlink=findViewById(R.id.textView9);



    }
}
