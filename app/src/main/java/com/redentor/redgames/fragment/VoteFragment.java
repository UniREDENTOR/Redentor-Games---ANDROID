package com.redentor.redgames.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.redentor.redgames.R;
import com.redentor.redgames.adapter.EventAdapter;
import com.redentor.redgames.model.Event;
import com.redentor.redgames.ws.SetupREST;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class VoteFragment extends Fragment {




    public VoteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vote, container, false);

        RecyclerView recyclerViewEvent = view.findViewById(R.id.lvEvents);
        recyclerViewEvent.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewEvent.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

        final EventAdapter eventAdapter = new EventAdapter(getContext());

        recyclerViewEvent.setAdapter(eventAdapter);

        SetupREST.apiREST.listEvent().enqueue(new Callback<List<Event>>() {
            @Override
            public void onResponse(Call<List<Event>> call, Response<List<Event>> response) {
                eventAdapter.atualiza(response.body());
            }

            @Override
            public void onFailure(Call<List<Event>> call, Throwable t) {

            }
        });

        return view;

    }

}
