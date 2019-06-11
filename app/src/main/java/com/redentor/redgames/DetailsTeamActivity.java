package com.redentor.redgames;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.redentor.redgames.adapter.MembersAdapter;
import com.redentor.redgames.model.Equipe;
import com.squareup.picasso.Picasso;

public class DetailsTeamActivity extends AppCompatActivity {

    private TextView txtNameLeaderTeam, txtParticipations, txtDescription,txtTeamName, txtToolbar;
    private ImageView imgLogoTeam;
    private RecyclerView lvMembers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_team);

        inicializaComponentes();

        Intent intent = getIntent();
        Equipe equipe = (Equipe) intent.getExtras().getSerializable("teams");

        txtToolbar.setText(equipe.getName());


        txtTeamName.setText(equipe.getName());
        txtNameLeaderTeam.setText(equipe.getLeader());
        txtDescription.setText(equipe.getDescription());

        lvMembers.setLayoutManager(new LinearLayoutManager(this));
        lvMembers.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));


        MembersAdapter membersAdapter = new MembersAdapter(this, equipe.getMembers());

        lvMembers.setAdapter(membersAdapter);

        String participations = String.valueOf(equipe.getParticipations());


        txtParticipations.setText(participations);


        photoUrl(equipe.getLogo(),imgLogoTeam);


    }

    private void inicializaComponentes(){
        txtTeamName = findViewById(R.id.txtTeamName);
        txtNameLeaderTeam = findViewById(R.id.txtNameLeaderTeam);
        txtDescription = findViewById(R.id.txtDescription);
        txtParticipations = findViewById(R.id.txtParticipations);
        lvMembers = findViewById(R.id.lvMembers);
        imgLogoTeam = findViewById(R.id.imgLogoTeam);
        txtToolbar = findViewById(R.id.txtToolbar);
    }


    private void photoUrl(String url, ImageView imageView) {

        Picasso.get().load(url).noFade().into(imageView);
    }


}
