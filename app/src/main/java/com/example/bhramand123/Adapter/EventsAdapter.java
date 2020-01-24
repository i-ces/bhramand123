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

    public EventsAdapter(List<Events> mEvents, Context mContext) {
        this.mEvents = mEvents;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public EventsAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.events_list_item,parent,false);
        return new EventsAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventsAdapterViewHolder holder, int position) {
        Events events=mEvents.get(position);
        mAuth=FirebaseAuth.getInstance();
        userId=mAuth.getCurrentUser().getUid();
        holder.eventDate.setText(events.getEventdate());
        holder.eventDesc.setText(events.getEventdesc());
        holder.eventHeading.setText(events.getEventname());
        if (events.getEventdesc().length()>16)
        {
            char[] str=events.getEventdesc().toCharArray();
            String smallText=String.copyValueOf(str,0,20);
            smallText=smallText+"..";
            holder.eventMoreText.setVisibility(View.VISIBLE);
        }


    }

    @Override
    public int getItemCount() {
        return mEvents.size();
    }

    public class EventsAdapterViewHolder extends RecyclerView.ViewHolder
    {
        private TextView eventDate,eventHeading,eventDesc,eventMoreText;
        private ImageView interestImage;
        public EventsAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            eventDate= itemView.findViewById(R.id.events_Date);
            eventHeading=itemView.findViewById(R.id.events_heading);
            eventDesc=itemView.findViewById(R.id.events_description);
            interestImage=itemView.findViewById(R.id.events_interest_image);
            eventMoreText=itemView.findViewById(R.id.events_list_more);

        }
    }
}
