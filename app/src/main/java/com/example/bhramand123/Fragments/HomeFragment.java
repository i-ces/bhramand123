package com.example.bhramand123.Fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.bhramand123.MainActivity;
import com.example.bhramand123.MapsActivity;
import com.example.bhramand123.PostActivity;
import com.example.bhramand123.R;
import com.example.bhramand123.addevent;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private RecyclerView topPostRecyclerView;
    public HomeFragment() {
        // Required empty public constructor
    }
    private NavigationView navView;

    private FirebaseAuth mAuth;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_home, container, false);
        mAuth=FirebaseAuth.getInstance();

        final ImageView navToggle=view.findViewById(R.id.home_navDrawer_btn);
         navToggle.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 PopupMenu popupMenu=new PopupMenu(getContext(),navToggle);
                 popupMenu.getMenuInflater().inflate(R.menu.nav_drawer_menu,popupMenu.getMenu());
                 popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                     @Override
                     public boolean onMenuItemClick(MenuItem item) {
                         switch (item.getItemId())
                         {
                             case R.id.nav_addEvents:
                             {

                                 startActivity(new Intent(getContext(), addevent.class ));
                             }
                             case R.id.nav_addPlace:
                             {
                                startActivity(new Intent(getContext(), PostActivity.class) );
                                 break;
                             }
                             case R.id.nav_addHomestay:
                             {
                                 Toast.makeText(getContext(), "Add Homestay click", Toast.LENGTH_SHORT).show();

                                 break;
                             }
                             case R.id.nav_settings:
                             {
                                 Toast.makeText(getContext(), "Settings", Toast.LENGTH_SHORT).show();

                                 break;
                             }
                             case R.id.nav_signOut:
                             {
                                 mAuth.signOut();
                                 startActivity(new Intent(getContext(),MainActivity.class));
                                 getActivity().finish();
                                 break;
                             }
                         }
                         return  true;

                         }
                 });
                 popupMenu.show();
             }
         });
        return  view;
    }

}
