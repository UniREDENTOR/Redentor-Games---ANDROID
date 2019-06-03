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

import com.redentor.redgames.ChooseTeamVotationActivity;
import com.redentor.redgames.R;
import com.redentor.redgames.RatingActivity;
import com.redentor.redgames.model.TeamsVotations;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class VotationTeamsAdapter extends RecyclerView.Adapter<VotationTeamsAdapter.VotationViewHolder> {

    private Context context;
    private List<TeamsVotations> teamsVotationslist;
    private TextView textVotationNome, textVotationScore, idTeam;
    private ImageView imageViewLogo;

    public VotationTeamsAdapter(Context context) {
        this.context = context;
        this.teamsVotationslist = new ArrayList<>();
    }

    @NonNull
    @Override
    public VotationViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_votation_teams,viewGroup,false);
        return new VotationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VotationViewHolder votationViewHolder, int i) {

        TeamsVotations teamsVotations = teamsVotationslist.get(i);
        textVotationNome.setText(teamsVotations.getName());
        textVotationScore.setText(teamsVotations.getAvg());
        String quantidade = String.valueOf(teamsVotations.getId());
        idTeam.setText(quantidade);




        Picasso.get().load(teamsVotations.getLogo()).into(imageViewLogo);

        votationViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, RatingActivity.class);
                intent.putExtra("idteam", teamsVotations.getId());
                intent.putExtra("timeescolhido", teamsVotations);
                context.startActivity(intent);
                Toast.makeText(context, "position" + i, Toast.LENGTH_SHORT).show();
            }
        });






    }

    @Override
    public int getItemCount() {

        return teamsVotationslist.size();
    }

    public void atualiza(List<TeamsVotations> teamsVotations) {
        this.teamsVotationslist = teamsVotations;
        notifyDataSetChanged();
    }

    class VotationViewHolder extends RecyclerView.ViewHolder {

        public VotationViewHolder(@NonNull View itemView) {
            super(itemView);
            textVotationNome = itemView.findViewById(R.id.txtVotationNameTeam);
            textVotationScore = itemView.findViewById(R.id.txtTeamScore);
            imageViewLogo = itemView.findViewById(R.id.imgTeamVotation);
            idTeam = itemView.findViewById(R.id.teamId);
        }
    }
}
