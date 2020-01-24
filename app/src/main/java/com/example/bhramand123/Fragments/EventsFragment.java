package com.example.bhramand123.Fragments;



import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bhramand123.Adapter.EventsAdapter;
import com.example.bhramand123.R;
import com.example.bhramand123.models.Events;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class EventsFragment extends Fragment {
    private List<Events> mEvents;
private EventsAdapter eventsAdapter;
private RecyclerView recyclerView;

    public EventsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_events, container, false);
        mEvents=new ArrayList<>();
        for (int i=0; i<=10; i++) {
            mEvents.add(new Events( "Vector", "vector is the biggest technical eveni that paschimanchal campus has", "Jan 26","pokhara",52.555,5254.5455, "sandesh","jdjf"));
        }
        eventsAdapter=new EventsAdapter(mEvents,getContext());
        recyclerView=view.findViewById(R.id.ongoingEventsRecyclerView);
        recyclerView.setLayoutManager(new  LinearLayoutManager(getContext()));
        recyclerView.setAdapter(eventsAdapter);

        return view;
    }

}
