package com.redentor.redgames;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.redentor.redgames.adapter.VotationTeamsAdapter;
import com.redentor.redgames.model.Event;
import com.redentor.redgames.model.TeamsVotations;
import com.redentor.redgames.ws.SetupREST;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChooseTeamVotationActivity extends AppCompatActivity {

    private TextView txtToolbar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_team_votation);

        txtToolbar2 = findViewById(R.id.txtToolbar2);

        Intent evento = getIntent();

        Event event = (Event) evento.getExtras().getSerializable("idevento");

        int idEvento = event.getId();

        txtToolbar2.setText(event.getName());




        final VotationTeamsAdapter votationTeamsAdapter = new VotationTeamsAdapter(this, event);
        RecyclerView recyclerView = findViewById(R.id.lvChooseTeam);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        recyclerView.setAdapter(votationTeamsAdapter);


        try {
            SetupREST.apiREST.listTeamVotations(idEvento).enqueue(new Callback<List<TeamsVotations>>() {
                @Override
                public void onResponse(Call<List<TeamsVotations>> call, Response<List<TeamsVotations>> response) {
                    votationTeamsAdapter.atualiza(response.body());

                }

                @Override
                public void onFailure(Call<List<TeamsVotations>> call, Throwable t) {

                }
            });

        }catch (Exception e) {

        }



    }
}
