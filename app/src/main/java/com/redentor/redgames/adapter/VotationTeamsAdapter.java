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
import com.redentor.redgames.model.Event;
import com.redentor.redgames.model.TeamsVotations;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class VotationTeamsAdapter extends RecyclerView.Adapter<VotationTeamsAdapter.VotationViewHolder> {

    private Context context;
    private List<TeamsVotations> teamsVotationslist;

    private Event evento;

    public VotationTeamsAdapter(Context context, Event evento) {
        this.context = context;
        this.teamsVotationslist = new ArrayList<>();
        this.evento = evento;
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
        votationViewHolder.textVotationNome.setText(teamsVotations.getName());
        votationViewHolder.textVotationScore.setText(teamsVotations.getAvg());

        String votos = String.valueOf(teamsVotations.getVotes());

        votationViewHolder.textVotos.setText(votos);






        Picasso.get().load(teamsVotations.getLogo()).noFade().into(votationViewHolder.imageViewLogo);

        votationViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, RatingActivity.class);
                intent.putExtra("timeescolhido", teamsVotations);
                intent.putExtra("ideventovotacao", evento);
                context.startActivity(intent);

            }
        });






    }

    @Override
    public int getItemCount() {

        if (teamsVotationslist == null) {
            return 0;
        }

        return teamsVotationslist.size();
    }

    public void atualiza(List<TeamsVotations> teamsVotations) {
        this.teamsVotationslist = teamsVotations;
        notifyDataSetChanged();
    }

    class VotationViewHolder extends RecyclerView.ViewHolder {

        private TextView textVotationNome, textVotationScore, textVotos;
        private ImageView imageViewLogo;

        public VotationViewHolder(@NonNull View itemView) {
            super(itemView);
            textVotationNome = itemView.findViewById(R.id.txtVotationNameTeam);
            textVotationScore = itemView.findViewById(R.id.txtTeamScore);
            imageViewLogo = itemView.findViewById(R.id.imgTeamVotation);
          //  textVotos = itemView.findViewById(R.id.txtTeamVotos);

        }
    }
}
