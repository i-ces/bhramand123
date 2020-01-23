package com.example.bhramand123.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bhramand123.R;
import com.example.bhramand123.models.Events;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.EventsAdapterViewHolder> {
    private List<Events> mEvents;
    private Context mContext;
    private FirebaseAuth mAuth;
    private String userId;

    @NonNull
    @Override
    public EventsAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.events_list_item,parent,false);
        return new EventsAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventsAdapterViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class EventsAdapterViewHolder extends RecyclerView.ViewHolder
    {
        private TextView eventDate,eventHeading,eventDesc;
        private ImageView interestImage;
        public EventsAdapterViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
