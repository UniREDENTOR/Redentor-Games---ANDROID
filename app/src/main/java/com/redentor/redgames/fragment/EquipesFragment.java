package com.redentor.redgames.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import com.redentor.redgames.R;
import com.redentor.redgames.adapter.EquipesAdapter;
import com.redentor.redgames.model.Equipe;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class EquipesFragment extends Fragment {


    public EquipesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_equipes, container, false);





        EquipesAdapter adapter = new EquipesAdapter(getContext());

        Equipe equipe = new Equipe();
        equipe.setName("teste");
        RecyclerView recyclerView = view.findViewById(R.id.recycleViewEquipe);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));



        recyclerView.setAdapter(adapter);

        return view;
    }


}
