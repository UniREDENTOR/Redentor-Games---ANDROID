package com.redentor.redgames;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailsTeamActivity extends AppCompatActivity {

    private TextView txtNameLeaderTeam, txtParticipations, txtPositionRanking, txtDescription, txtMembers;
    private ImageView imgLogoTeam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_team);


        inicializaComponentes();
        photoUrl("https://scontent.fgig6-1.fna.fbcdn.net/v/t1.0-9/50673365_800016577008714_2280332110361264128_n.jpg?_nc_cat=103&_nc_ht=scontent.fgig6-1.fna&oh=a8406127d87411d58a36e04c62663154&oe=5D55FEB4",imgLogoTeam);

        txtMembers.setText("Joao " + "Pedro " + "Aline");
    }

    private void inicializaComponentes(){
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
