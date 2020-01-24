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
private String[] eventsname;
private String[] eventsdesc;
private String[] eventdate;

    public EventsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_events, container, false);
        mEvents=new ArrayList<>();
        eventsname= new String[]{"vector", "code with coffee","empower"};
        eventsdesc =new String[]{"vector is the biggest technical event that paschimanchal campus has","code with coffee is a coding competition","empower is a vector event of vector 2.0"};
        eventdate=new String[]{"Jan 26","Jan 26","Jan 26"};

        for(int i=0;i<3;i++)

        {

            mEvents.add(new Events(eventsname[i], eventsdesc[i], eventdate[i], "pokhara", 52.555, 5254.5455, "sandesh", "jdjf"));

//            mEvents.add(new Events("Codecamp", "codecamp is the minor technical event of Vector 2.0", "Jan 26", "pokhara", 52.555, 5254.5455, "sandesh", "jdjf"));
//
//            mEvents.add(new Events("Fsu election 2076", "FSU election 2076", "Feb 26", "pokhara", 52.555, 5254.5455, "sandesh", "jdjf"));
//
//            mEvents.add(new Events("Empower", "Empower is the event that paschimanchal campus has", "Jan 26", "pokhara", 52.555, 5254.5455, "sandesh", "jdjf"));
//
//            mEvents.add(new Events("Code With Coffee", "Code with coffee is a coding competition", "Jan 26", "pokhara", 52.555, 5254.5455, "sandesh", "jdjf"));
        }
       // mEvents.add(new Events( "Vector", "vector is the biggest technical eveni that paschimanchal campus has", "Jan 26","pokhara",52.555,5254.5455, "sandesh","jdjf"));

        eventsAdapter=new EventsAdapter(mEvents,getContext());
        recyclerView=view.findViewById(R.id.ongoingEventsRecyclerView);
        recyclerView.setLayoutManager(new  LinearLayoutManager(getContext()));
        recyclerView.setAdapter(eventsAdapter);

        return view;
    }

}
