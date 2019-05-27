package com.redentor.redgames.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.redentor.redgames.DescriptionGamesActivity;
import com.redentor.redgames.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class GamesFragment extends Fragment {

    private ListView listViewDias;


    public GamesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_games, container,false);

        listViewDias = view.findViewById(R.id.lvDias);

        ArrayList dias = new ArrayList();

        dias.add("Sábado - 15/06/2019");
        dias.add("Domingo - 16/06/2019");
        dias.add("Segunda - 17/06/2019");
        dias.add("Terça - 18/06/2019");
        dias.add("Quarta - 19/06/2019");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String >(getContext(),android.R.layout.simple_list_item_1, dias);

        listViewDias.setAdapter(arrayAdapter);

        listViewDias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), DescriptionGamesActivity.class);
                intent.putExtra("idgame", position);
                startActivity(intent);

            }
        });


        return view;
    }


    public View inicializarComponentes(View view) {
       listViewDias = view.findViewById(R.id.lvDias);

        return view;
    }



}
