package com.redentor.redgames.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class DetailsTeamAdapter extends RecyclerView.Adapter<DetailsTeamAdapter.DetailsTeamViewHolder> {


    @NonNull
    @Override
    public DetailsTeamViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull DetailsTeamViewHolder detailsTeamViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }




    class DetailsTeamViewHolder extends RecyclerView.ViewHolder {


        public DetailsTeamViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
