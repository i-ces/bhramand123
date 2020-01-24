package com.example.bhramand123;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.bhramand123.Fragments.EventsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.bhramand123.Fragments.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private Fragment selectedFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bottomNavigationView=findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);

     HomeFragment hm = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.Frame_container,hm).commit();


    }
     private  BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener=new BottomNavigationView.OnNavigationItemSelectedListener() {
         @Override
         public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
             switch (menuItem.getItemId())
             {
                 case R.id.nav_home:
                 {
                     selectedFragment=new HomeFragment();
                     break;
                 }
                 case R.id.nav_map:
                 {
                     startActivity(new Intent(getApplicationContext(),MapsActivity2.class));
                     break;
                 }
                 case R.id.nav_resturants:
                 {

                     break;
                 }
                 case R.id.events:
                 {
                     selectedFragment=new EventsFragment();
                     break;
                 }

             }
             if (selectedFragment !=null) {
                 getSupportFragmentManager().beginTransaction().replace(R.id.Frame_container, selectedFragment).commit();
             }
             return true;
         }
     };

}
