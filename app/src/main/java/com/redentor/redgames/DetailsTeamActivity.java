package com.redentor.redgames;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.redentor.redgames.model.Equipe;
import com.squareup.picasso.Picasso;

public class DetailsTeamActivity extends AppCompatActivity {

    private TextView txtNameLeaderTeam, txtParticipations, txtPositionRanking, txtDescription, txtMembers, txtTeamName;
    private ImageView imgLogoTeam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_team);

        inicializaComponentes();

        Intent intent = getIntent();
        Equipe equipe = (Equipe) intent.getExtras().getSerializable("teams");


        txtTeamName.setText(equipe.getName());
        txtNameLeaderTeam.setText(equipe.getLeader());
        txtDescription.setText(equipe.getDescription());
        txtMembers.setText(equipe.getMemberNames());

        String participations = String.valueOf(equipe.getParticipations());


        txtParticipations.setText(participations);


        photoUrl(equipe.getLogo(),imgLogoTeam);

        txtMembers.setText("Joao " + "Pedro " + "Aline");
    }

    private void inicializaComponentes(){
        txtTeamName = findViewById(R.id.txtTeamName);
        txtNameLeaderTeam = findViewById(R.id.txtNameLeaderTeam);
        txtDescription = findViewById(R.id.txtDescription);
        txtPositionRanking = findViewById(R.id.txtPositionRanking);
        txtParticipations = findViewById(R.id.txtParticipations);
        txtMembers = findViewById(R.id.txtMembers);
        imgLogoTeam = findViewById(R.id.imgLogoTeam);
    }


    private void photoUrl(String url, ImageView imageView) {

        Picasso.get().load(url).into(imageView);
    }


}
