package com.redentor.redgames;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.redentor.redgames.model.GameDescription;

public class FullDescriptionGameActivity extends AppCompatActivity {

    private TextView textViewGameNome;
    private TextView textViewGameData;
    private TextView textViewGameHorario;
    private TextView textViewGameLocal;
    private TextView textViewGameDescription;
    private Button buttonEdital;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_description_game);

        textViewGameNome = findViewById(R.id.textViewGameNome);
        textViewGameData = findViewById(R.id.textViewGameData);
        textViewGameHorario = findViewById(R.id.textViewGameHorario);
        textViewGameLocal = findViewById(R.id.textViewGameLocal);
        textViewGameDescription = findViewById(R.id.textViewGameDescription);
        buttonEdital = findViewById(R.id.buttonEdital);

        Intent intent = getIntent();
        GameDescription game = (GameDescription) intent.getExtras().getSerializable("game");

        textViewGameNome.setText(game.getName());
        textViewGameData.setText("Data: " + game.getDate());
        textViewGameHorario.setText("Horario: " + game.getTime());
        textViewGameLocal.setText("Local: " + game.getLocale());
        textViewGameDescription.setText("Descrição: " + game.getDescription());

        buttonEdital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(game.getEdital()));
                startActivity(browserIntent);
            }
        });
    }
}
