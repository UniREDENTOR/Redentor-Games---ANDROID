package com.redentor.redgames;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.hsalf.smilerating.BaseRating;
import com.hsalf.smilerating.SmileRating;
import com.redentor.redgames.model.Note;
import com.redentor.redgames.model.TeamsVotations;
import com.redentor.redgames.ws.SetupREST;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;

public class RatingActivity extends AppCompatActivity {

    private ImageView logoTimeEscolhido;
    private TextView txtTimeEscolhido, txtScoreTime;
    private Button btnVotar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        Intent intent = getIntent();
        TeamsVotations teamsVotations = (TeamsVotations) intent.getExtras().getSerializable("timeescolhido");





        logoTimeEscolhido = findViewById(R.id.imgTimeEscolhido);
        txtTimeEscolhido = findViewById(R.id.txtTimeEscolhido);
        txtScoreTime = findViewById(R.id.txtPontuação);
        SmileRating smileRating = (SmileRating) findViewById(R.id.smile_rating);
        btnVotar = findViewById(R.id.btnVotar);

        Picasso.get().load(teamsVotations.getLogo()).into(logoTimeEscolhido);
        txtTimeEscolhido.setText(teamsVotations.getName());
        txtScoreTime.setText(teamsVotations.getAvg());






        smileRating.setNameForSmile(BaseRating.TERRIBLE, "Péssimo");
        smileRating.setNameForSmile(BaseRating.BAD, "Ruim");
        smileRating.setNameForSmile(BaseRating.OKAY, "Aceitável");
        smileRating.setNameForSmile(BaseRating.GOOD, "Bom");
        smileRating.setNameForSmile(BaseRating.GREAT, "Ótimo");




        btnVotar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int level = smileRating.getRating();

                if (level == 0)  {
                    Toast.makeText(RatingActivity.this, "Por favor escolha uma nota", Toast.LENGTH_SHORT).show();
                } else {

                    Note note = new Note();
                    note.setUuid("2321");
                    note.setAmount(30120130);

                    JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.put("amount",note.getAmount());
                        jsonObject.put("uuid", note.getUuid());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                    SetupREST.apiREST.note(1, teamsVotations.getId(), jsonObject).enqueue(new Callback<Note>() {
                       @Override
                       public void onResponse(Call<Note> call, Response<Note> response) {

                       }

                       @Override
                       public void onFailure(Call<Note> call, Throwable t) {

                       }
                   });



                }

            }
        });



    }
}
