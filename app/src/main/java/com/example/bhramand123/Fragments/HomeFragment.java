package com.example.bhramand123.Fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bhramand123.Adapter.PlacesAdapter;
import com.example.bhramand123.MainActivity;
import com.example.bhramand123.PostActivity;
import com.example.bhramand123.R;
import com.example.bhramand123.addevent;
import com.example.bhramand123.models.Post;
import com.example.bhramand123.models.User;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private RecyclerView topPostRecyclerView;
    private RecyclerView postRecyclerView;
    private PlacesAdapter topPlaces;
    private PlacesAdapter nearestPlaces;
    private TextView username;
    private SeekBar seekBar;
    private String uid;
    private String[] email;
    private FirebaseUser muser;
    private DatabaseReference udb;
   // private TextView seekdata;
    List<Post> topPost;
    List<User> users;
    List<Post> nearPost;
    private  List<Post> postList;
    public HomeFragment() {
        // Required empty public constructor
    }
    private NavigationView navView;

    private FirebaseAuth mAuth;
private DatabaseReference db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view =inflater.inflate(R.layout.fragment_home, container, false);
        topPostRecyclerView=view.findViewById(R.id.home_topPlaces_container);
        postRecyclerView=view.findViewById(R.id.home_places_container);
        username=view.findViewById(R.id.user_name);
        postRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        topPostRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        mAuth=FirebaseAuth.getInstance();
        uid=mAuth.getUid();
        topPost=new ArrayList<>();
        nearPost=new ArrayList<>();
       // seekdata=view.findViewById(R.id.textView11);
        seekBar=view.findViewById(R.id.seekBar);
        db= FirebaseDatabase.getInstance().getReference("post");
        udb=FirebaseDatabase.getInstance().getReference().child("users").child(uid);
        db= FirebaseDatabase.getInstance().getReference().child("places");
        muser=mAuth.getCurrentUser();
         email=muser.getEmail().split("@");
       // Toast.makeText(getContext(),email,Toast.LENGTH_SHORT).show();
        username.setText(email[0]);
        postList =new ArrayList<>();
        seekBar.setMax(15);

        final ImageView navToggle=view.findViewById(R.id.home_navDrawer_btn);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
               Toast.makeText(getContext(), "Selected radius around is :" + progressChangedValue+" km",
                        Toast.LENGTH_SHORT).show();
                //seekdata.setText(;

            }
        });
//        topPost.add(new Post("Bat Cave ","kaski","R.drawable.ic_oval",2.5051515,27.64654646,"BAt Cave  loacated at pokhara Lamachaur is...","Sagar"));
//        topPost.add(new Post("Mahendra Guffa","kaski","hh",2.5051515,27.64654646,"Mahendra  guffa loacated at pokhara Lamachaur is...","Sagar"));
//        topPost.add(new Post("HariHar Guffa","kaski","hh",2.5051515,27.64654646,"Harihar guffa loacated at pokhara bhalam is...","Sagar"));
//
//
//
//        nearPost.add(new Post("Bat Cave ","kaski","hh",2.5051515,27.64654646,"BAt Cave  loacated at pokhara Lamachaur is...","Sagar"));
//        nearPost.add(new Post("Mahendra Guffa","kaski","hh",2.5051515,27.64654646,"Mahendra  guffa loacated at pokhara Lamachaur is...","Sagar"));
//        nearPost.add(new Post("HariHar Guffa","kaski","hh",2.5051515,27.64654646,"Harihar guffa loacated at pokhara bhalam is...","Sagar"));
        nearestPlaces=new PlacesAdapter(nearPost,getContext());
        postRecyclerView.setAdapter(nearestPlaces);
        topPlaces=new PlacesAdapter(topPost,getContext());
        topPostRecyclerView.setAdapter(topPlaces);

//        udb.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                if(dataSnapshot.exists()) {
//                    for (DataSnapshot contents : dataSnapshot.getChildren()) {
//                        if (contents.exists()) {
//                            User user = contents.getValue(User.class);
//                            users.add(user);
//                            Toast.makeText(getContext(),user.getName(),Toast.LENGTH_SHORT).show();
//
//                        } else {
//                            Toast.makeText(getContext(), "sorry", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                }
//                else
//                {
//                    Toast.makeText(getContext(),"sorry",Toast.LENGTH_SHORT).show();
//                }
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });

//
//        db.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//                if (dataSnapshot.exists()) {
//                    for (DataSnapshot content : dataSnapshot.getChildren()) {
//                        if (content.exists()) {
//                            Post place = content.getValue(Post.class);
//                            Toast.makeText(getContext(), place.getName(), Toast.LENGTH_SHORT).show();
//                            postList.add(place);
//
//                            //  Toast.makeText(getContext(),"ok",Toast.LENGTH_SHORT).show();
//                        } else {
//                            Toast.makeText(getContext(), "sorry", Toast.LENGTH_SHORT).show();
//                        }
//                        nearestPlaces=new PlacesAdapter(postList,getContext());
//                        postRecyclerView.setAdapter(nearestPlaces);
//                        topPlaces=new PlacesAdapter(postList,getContext());
//                        topPostRecyclerView.setAdapter(topPlaces);
//
//                    }
//                }
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                Log.w(TAG, "Failed to read value.", error.toException());
//            }
//        });
                navToggle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        PopupMenu popupMenu = new PopupMenu(getContext(), navToggle);
                        popupMenu.getMenuInflater().inflate(R.menu.nav_drawer_menu, popupMenu.getMenu());
                        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem item) {
                                switch (item.getItemId()) {
                                    case R.id.nav_addEvents: {

                                        startActivity(new Intent(getContext(), addevent.class));
                                    }
                                    case R.id.nav_addPlace: {
                                        startActivity(new Intent(getContext(), PostActivity.class));
                                        break;
                                    }
                                    case R.id.nav_addHomestay: {
                                        Toast.makeText(getContext(), "Add Homestay click", Toast.LENGTH_SHORT).show();

                                        break;
                                    }
                                    case R.id.nav_settings: {
                                        Toast.makeText(getContext(), "Settings", Toast.LENGTH_SHORT).show();

                                        break;
                                    }
                                    case R.id.nav_signOut: {
                                        mAuth.signOut();
                                        startActivity(new Intent(getContext(), MainActivity.class));
                                        getActivity().finish();
                                        break;
                                    }
                                }
                                return true;

                            }
                        });
                        popupMenu.show();
                    }
                });
        return view;
    }

}