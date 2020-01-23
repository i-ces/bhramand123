package com.example.bhramand123;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.bhramand123.Fragments.HomeFragment;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
      /*  HomeFragment hm = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.Frame_container,hm).commit();*/
    }
}
