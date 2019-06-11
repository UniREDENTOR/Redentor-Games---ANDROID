package com.redentor.redgames;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.redentor.redgames.model.GameDescription;

public class FullDescriptionGameActivity extends AppCompatActivity {


    private TextView textViewGameData;
    private TextView textViewGameHorario;
    private TextView textViewGameLocal;
    private TextView textViewGameDescription;
    private Button buttonEdital;
    private TextView txtTool;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_description_game);


        textViewGameData = findViewById(R.id.textViewGameData);
        textViewGameHorario = findViewById(R.id.textViewGameHorario);
        textViewGameLocal = findViewById(R.id.textViewGameLocal);
        textViewGameDescription = findViewById(R.id.textViewGameDescription);
        buttonEdital = findViewById(R.id.buttonEdital);
        toolbar = findViewById(R.id.toolbar);
        txtTool = findViewById(R.id.txtToolbar);

        Intent intent = getIntent();
        GameDescription game = (GameDescription) intent.getExtras().getSerializable("game");

        txtTool.setText(game.getName());


        textViewGameData.setText(game.getDate());
        textViewGameHorario.setText(game.getTime());
        textViewGameLocal.setText(game.getLocale());
        textViewGameDescription.setText(game.getDescription());

        buttonEdital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(game.getEdital()));
                startActivity(browserIntent);
            }
        });
    }
}
