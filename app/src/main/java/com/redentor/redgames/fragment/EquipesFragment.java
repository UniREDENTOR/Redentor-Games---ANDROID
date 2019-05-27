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

        Equipe equipe = new Equipe();
        equipe.setName("Sistemafia");
        equipe.setDescription("A equipe surgiu no ano de 2016 e vem forte pelo titulo");
        equipe.setLogo("https://scontent.fgig6-1.fna.fbcdn.net/v/t1.0-9/50673365_800016577008714_2280332110361264128_n.jpg?_nc_cat=103&_nc_ht=scontent.fgig6-1.fna&oh=a8406127d87411d58a36e04c62663154&oe=5D55FEB4");

        Equipe equipe2 = new Equipe();
        equipe2.setName("Tudo pelo ponto");
        equipe2.setDescription("ASXSAKPOXSOKPAXSOKPAXSOKPASOKPAOSKKOPSAXKPOSAXKOSAXSAKPO");
        equipe2.setLogo("https://scontent.fgig6-1.fna.fbcdn.net/v/t1.0-9/29342527_104990343677133_852850702483980288_n.jpg?_nc_cat=101&_nc_ht=scontent.fgig6-1.fna&oh=2b90419b21a16dd41c501367f29d527d&oe=5D6347E8");
        List<Equipe> equipes = new ArrayList<>();
        equipes.add(equipe);
        equipes.add(equipe2);





        EquipesAdapter adapter = new EquipesAdapter(getContext(),equipes);


        RecyclerView recyclerView = view.findViewById(R.id.recycleViewEquipe);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));



        recyclerView.setAdapter(adapter);

        return view;
    }


}
