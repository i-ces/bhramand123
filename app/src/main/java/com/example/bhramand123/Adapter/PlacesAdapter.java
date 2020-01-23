package com.example.bhramand123.Adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;

import java.util.List;

public class PlacesAdapter extends RecyclerView.Adapter<PlacesAdapter.PlacesAdapterViewHolder> {
    private List<com.example.bhramand123.Fragments.models.Post> posts;
    private FirebaseAuth mAuth;
    private FirebaseStorage mStorage;
    private String userID;

    @NonNull
    @Override
    public PlacesAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PlacesAdapterViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class PlacesAdapterViewHolder extends RecyclerView.ViewHolder
    {
        public PlacesAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
