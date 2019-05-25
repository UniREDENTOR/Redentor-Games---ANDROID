package com.redentor.redgames.fragment;


import android.nfc.Tag;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.redentor.redgames.R;
import com.redentor.redgames.adapter.PhotoAdapter;
import com.redentor.redgames.model.Photo;
import com.redentor.redgames.ws.SetupREST;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhotoFragment extends Fragment {




    public PhotoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_foto, container, false);






       RecyclerView photosview = view.findViewById(R.id.lvFotos);
       photosview.setLayoutManager(new LinearLayoutManager(getContext()));
       photosview.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));


       final PhotoAdapter photoAdapter = new PhotoAdapter(getContext());

       photosview.setAdapter(photoAdapter);

        SetupREST.apiREST.listPhotos().enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {


                photoAdapter.atualiza(response.body());

                Log.e("certo", call.toString());
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {

                Log.e("erro", call.toString());
                t.printStackTrace();

            }
        });

        return view;
    }


}
