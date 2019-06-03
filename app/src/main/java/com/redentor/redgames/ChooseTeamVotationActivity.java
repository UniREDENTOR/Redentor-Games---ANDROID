package com.redentor.redgames;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.redentor.redgames.adapter.VotationTeamsAdapter;
import com.redentor.redgames.model.TeamsVotations;
import com.redentor.redgames.ws.SetupREST;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChooseTeamVotationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_team_votation);

        Intent evento = getIntent();
        int positionEvent = evento.getExtras().getInt("idevento");


        final VotationTeamsAdapter votationTeamsAdapter = new VotationTeamsAdapter(this);
        RecyclerView recyclerView = findViewById(R.id.lvChooseTeam);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        recyclerView.setAdapter(votationTeamsAdapter);


        SetupREST.apiREST.listTeamVotations(positionEvent).enqueue(new Callback<List<TeamsVotations>>() {
            @Override
            public void onResponse(Call<List<TeamsVotations>> call, Response<List<TeamsVotations>> response) {
                votationTeamsAdapter.atualiza(response.body());

            }

            @Override
            public void onFailure(Call<List<TeamsVotations>> call, Throwable t) {

            }
        });
    }
}
