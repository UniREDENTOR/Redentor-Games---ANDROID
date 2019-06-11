package com.redentor.redgames.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.redentor.redgames.R;
import com.redentor.redgames.model.Rank;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RankAdapter extends RecyclerView.Adapter<RankAdapter.RankViewHolder> {

    private Context context;
    private List<Rank> listRank;
    private TextView nameRank, positionRank, scoreRank;
    private ImageView logoRank;

    public RankAdapter(Context context) {
        this.context = context;
        this.listRank = new ArrayList<>();
    }

    @NonNull
    @Override
    public RankViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_rank, viewGroup,false);

        return new RankViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RankViewHolder rankViewHolder, int i) {

        Rank rank = listRank.get(i);
        nameRank.setText(rank.getName());
        String position = String.valueOf(rank.getPosition());
        String score = String.valueOf(rank.getScore());
        positionRank.setText(position + "º");
       scoreRank.setText(score);
        Picasso.get().load(rank.getLogo()).noFade().into(logoRank);


    }

    @Override
    public int getItemCount() {

        if (listRank == null) {
            return 0;
        }
        return listRank.size();
    }

    public void atualiza(List<Rank> ranks) {

        this.listRank = ranks;
        notifyDataSetChanged();
    }

    class RankViewHolder extends RecyclerView.ViewHolder {


        public RankViewHolder(@NonNull View itemView) {
            super(itemView);
            nameRank = itemView.findViewById(R.id.txtNameRank);
            positionRank = itemView.findViewById(R.id.txtRankingPosition);
            scoreRank = itemView.findViewById(R.id.txtScoreRank);
            logoRank = itemView.findViewById(R.id.imgLogoRank);

        }
    }
}
