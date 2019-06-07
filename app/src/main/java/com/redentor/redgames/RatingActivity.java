package com.redentor.redgames;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hsalf.smilerating.BaseRating;
import com.hsalf.smilerating.SmileRating;
import com.redentor.redgames.helper.Permissao;
import com.redentor.redgames.model.Note;
import com.redentor.redgames.model.TeamsVotations;
import com.redentor.redgames.ws.SetupREST;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RatingActivity extends AppCompatActivity {

    private ImageView logoTimeEscolhido;
    private TextView txtTimeEscolhido, txtScoreTime;
    private Button btnVotar;
    private TelephonyManager telephonyManager;
    private String imei;
    private String[] permissoesNecessarias = new String[]{
            Manifest.permission.READ_PHONE_STATE

    };

    private TextView txtToolbar2, txtnomeTimeToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        txtToolbar2 = findViewById(R.id.txtToolbar2);
        txtnomeTimeToolbar = findViewById(R.id.txtToolbarEvent);

        Permissao.validarPermissoes(permissoesNecessarias, this,1);

        Intent intent = getIntent();
        TeamsVotations teamsVotations = (TeamsVotations) intent.getExtras().getSerializable("timeescolhido");
        int idEvento = intent.getExtras().getInt("ideventovotacao");


        txtToolbar2.setText("Escolha uma nota para:");
        txtnomeTimeToolbar.setText(teamsVotations.getName());


        imei = getIMEINumber();





        SmileRating smileRating = (SmileRating) findViewById(R.id.smile_rating);
        btnVotar = findViewById(R.id.btnVotar);










        smileRating.setNameForSmile(BaseRating.TERRIBLE, "Péssimo - 1");
        smileRating.setNameForSmile(BaseRating.BAD, "Ruim - 2");
        smileRating.setNameForSmile(BaseRating.OKAY, "Aceitável - 3");
        smileRating.setNameForSmile(BaseRating.GOOD, "Bom - 4");
        smileRating.setNameForSmile(BaseRating.GREAT, "Ótimo - 5");




        btnVotar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int level = smileRating.getRating();

                if (level == 0)  {
                    Toast.makeText(RatingActivity.this, "Por favor escolha uma nota", Toast.LENGTH_SHORT).show();
                } else {

                    Note note = new Note();
                    note.setUuid(imei);
                    note.setAmount(level);

                    SetupREST.apiREST.note(idEvento, teamsVotations.getId(), note).enqueue(new Callback<Note>() {
                       @Override
                       public void onResponse(Call<Note> call, Response<Note> response) {

                           if (response.isSuccessful()) {
                               Toast.makeText(RatingActivity.this, "sucesso", Toast.LENGTH_SHORT).show();
                           }

                       }

                       @Override
                       public void onFailure(Call<Note> call, Throwable t) {

                       }
                   });



                }

            }
        });



    }


    private String getIMEINumber() {
        String imei = "";
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
            TelephonyManager telephonyMgr = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                imei = telephonyMgr.getImei();
            } else {
                imei = telephonyMgr.getDeviceId();
            }
        }
        return imei;
    }



}
