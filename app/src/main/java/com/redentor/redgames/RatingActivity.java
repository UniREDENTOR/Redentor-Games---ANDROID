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
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.hsalf.smilerating.BaseRating;
import com.hsalf.smilerating.SmileRating;
import com.redentor.redgames.helper.Permissao;
import com.redentor.redgames.model.Event;
import com.redentor.redgames.model.Note;
import com.redentor.redgames.model.TeamsVotations;
import com.redentor.redgames.ws.SetupREST;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RatingActivity extends AppCompatActivity {


    private Button btnVotar;
    private String imei;
    private RatingBar ratingBar;
    private String[] permissoesNecessarias = new String[]{
            Manifest.permission.READ_PHONE_STATE

    };

    private int idEvent;
    private Boolean Active;





    private TextView txtToolbar2, txtnomeTimeToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        txtToolbar2 = findViewById(R.id.txtToolbar2);
        txtnomeTimeToolbar = findViewById(R.id.txtToolbarEvent);
        ratingBar = findViewById(R.id.smile_rating);
        btnVotar = findViewById(R.id.btnVotar);


        Intent intent = getIntent();
        TeamsVotations teamsVotations = (TeamsVotations) intent.getExtras().getSerializable("timeescolhido");
        Event event = (Event) intent.getExtras().getSerializable("ideventovotacao");

        idEvent = event.getId();
        Active = event.getActive();

        Permissao.validarPermissoes(permissoesNecessarias, this,1);




        txtToolbar2.setText("Escolha uma nota para:");
        txtnomeTimeToolbar.setText(teamsVotations.getName());
        ratingBar.setMax(5);



        imei = getIMEINumber();


        btnVotar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int level = (int) ratingBar.getRating();



                if (level > 0 && Active)  {

                    Note note = new Note();
                    note.setUuid(imei);
                    note.setAmount(level);

                    try {

                        SetupREST.apiREST.note(idEvent, teamsVotations.getId(), note).enqueue(new Callback<Note>() {
                            @Override
                            public void onResponse(Call<Note> call, Response<Note> response) {

                                Toast.makeText(RatingActivity.this, "Sua nota foi enviada para validação", Toast.LENGTH_SHORT).show();

                            }

                            @Override
                            public void onFailure(Call<Note> call, Throwable t) {

                            }
                        });

                    }catch (Exception e) {

                    }

                } else {

                    if (level == 0) {
                        Toast.makeText(RatingActivity.this, "Você deve atribuir uma nota de 1 a 5", Toast.LENGTH_LONG).show();
                    }

                    if (Active == false) {
                        Toast.makeText(RatingActivity.this, "O evento ainda não está disponivel para votação!", Toast.LENGTH_SHORT).show();
                    }



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
