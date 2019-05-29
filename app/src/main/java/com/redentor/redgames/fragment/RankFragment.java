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
import com.redentor.redgames.adapter.RankAdapter;
import com.redentor.redgames.model.Rank;
import com.redentor.redgames.ws.SetupREST;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class RankFragment extends Fragment {


    public RankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rank, container, false);

        RecyclerView recyclerViewRank = view.findViewById(R.id.recyclerRank);
        recyclerViewRank.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewRank.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

        final RankAdapter rankAdapter = new RankAdapter(getContext());

        recyclerViewRank.setAdapter(rankAdapter);

        SetupREST.apiREST.listRank().enqueue(new Callback<List<Rank>>() {
            @Override
            public void onResponse(Call<List<Rank>> call, Response<List<Rank>> response) {

                rankAdapter.atualiza(response.body());
            }

            @Override
            public void onFailure(Call<List<Rank>> call, Throwable t) {

            }
        });

        return view;



    }
}
