package com.redentor.redgames.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.redentor.redgames.DetailsTeamActivity;
import com.redentor.redgames.R;
import com.redentor.redgames.model.Equipe;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class EquipesAdapter extends RecyclerView.Adapter<EquipesAdapter.EquipesViewHolder> {

    private Context context;
    private TextView equipeName;
    private ImageView equipeLogo;
    private TextView equipeDescription;
    private List<Equipe> equipeList;

    public EquipesAdapter(Context context) {
        this.context = context;
        this.equipeList = new ArrayList<>();
    }

    @NonNull
    @Override
    public EquipesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_equipe, viewGroup, false);
        return new EquipesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EquipesViewHolder equipesViewHolder, int i) {
        Equipe equipe = equipeList.get(i);
        Picasso.get().load(equipe.getLogo()).into(equipeLogo);
        equipeDescription.setText(equipe.getDescription());
        equipeName.setText(equipe.getName());



        equipesViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Trocar para tela da equipe", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(context, DetailsTeamActivity.class);
                i.putExtra("teams", equipe);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {

        if (equipeList == null) {
            return 0;
        }

        return equipeList.size();
    }

    public void atualiza(List<Equipe> equipes) {
        this.equipeList = equipes;
        notifyDataSetChanged();
    }

    class EquipesViewHolder extends RecyclerView.ViewHolder {
        public EquipesViewHolder(@NonNull View itemView) {
            super(itemView);

            equipeDescription = itemView.findViewById(R.id.textViewEquipeDescription);
            equipeLogo = itemView.findViewById(R.id.imageViewLogoEquipe);
            equipeName = itemView.findViewById(R.id.textViewEquipeName);





        }
    }
}
