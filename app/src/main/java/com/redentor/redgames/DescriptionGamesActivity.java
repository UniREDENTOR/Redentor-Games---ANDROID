package com.redentor.redgames;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.redentor.redgames.adapter.DescriptionAdapter;
import com.redentor.redgames.model.GameDescription;
import com.redentor.redgames.ws.SetupREST;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DescriptionGamesActivity extends AppCompatActivity {



    private RecyclerView recyclerViewDescriptionGames;
    private TextView txtTool;
    private Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description_games);
        inilicializarComponentes();

        txtTool.setText("Modalidades");





        Intent i = getIntent();
       int position = i.getExtras().getInt("idgames") + 4;





       recyclerViewDescriptionGames.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
       recyclerViewDescriptionGames.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));


        //GameDescription gameDescription = new GameDescription();
        //gameDescription.setName("FUTEBOL");
        //gameDescription.setDescription("FUTEBOL");




        final DescriptionAdapter descriptionAdapter = new DescriptionAdapter(this);

        recyclerViewDescriptionGames.setAdapter(descriptionAdapter);

        SetupREST.apiREST.listGameDescription(position).enqueue(new Callback<List<GameDescription>>() {
            @Override
            public void onResponse(Call<List<GameDescription>> call, Response<List<GameDescription>> response) {


               descriptionAdapter.update(response.body());
                Log.e("certo", call.toString());
            }

            @Override
            public void onFailure(Call<List<GameDescription>> call, Throwable t) {

                Log.e("erro", call.toString());
                t.printStackTrace();

            }
        });


    }

    public void inilicializarComponentes() {
        recyclerViewDescriptionGames = findViewById(R.id.recyclerDescriptionGames);
        toolbar = findViewById(R.id.toolbar);
        txtTool = findViewById(R.id.txtToolbar);
    }
}
