package com.redentor.redgames.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.redentor.redgames.FullDescriptionGameActivity;
import com.redentor.redgames.R;
import com.redentor.redgames.model.GameDescription;

import java.util.ArrayList;
import java.util.List;

public class DescriptionAdapter extends RecyclerView.Adapter<DescriptionAdapter.GameViewHolder> {

    private TextView txtNome, txtDescricao;
    private List<GameDescription> listDescriptionAdapter;
    private Context context;


    public DescriptionAdapter(Context context) {
        this.listDescriptionAdapter = new ArrayList<>();
        this.context = context;
    }


    @NonNull
    @Override
    public GameViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_description, viewGroup, false);


        return new GameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GameViewHolder gameViewHolder, int i) {

        GameDescription gameDescription = listDescriptionAdapter.get(i);

        txtNome.setText(gameDescription.getName());
        txtDescricao.setText(gameDescription.getDescription());

        gameViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FullDescriptionGameActivity.class);
                intent.putExtra("game", gameDescription);
                context.startActivity(intent);
            }
        });

    }



    @Override
    public int getItemCount() {
        return listDescriptionAdapter.size();
    }

    public void update(List<GameDescription> gameDescriptions) {

        this.listDescriptionAdapter = gameDescriptions;
        notifyDataSetChanged();
    }

    class GameViewHolder extends RecyclerView.ViewHolder {

        public GameViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNome = itemView.findViewById(R.id.txtNome);
            txtDescricao = itemView.findViewById(R.id.txtDescricao);


        }
    }

}

