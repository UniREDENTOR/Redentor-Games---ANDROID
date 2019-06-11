package com.redentor.redgames.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.redentor.redgames.R;

public class MembersAdapter extends RecyclerView.Adapter<MembersAdapter.MembersViewHolder> {

    private TextView txtmembersName;
    private Context context;
    private String[] membersList;

    public MembersAdapter(Context context, String[] membersList) {
        this.context = context;
        this.membersList = membersList;
    }

    @NonNull
    @Override
    public MembersViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_members, viewGroup, false);

        return new MembersViewHolder(view);



    }

    @Override
    public void onBindViewHolder(@NonNull MembersViewHolder membersViewHolder, int i) {

        txtmembersName.setText(membersList[i]);



    }

    @Override
    public int getItemCount() {

        if(membersList == null) {
            return 0;
        }
        return membersList.length;
    }


    class MembersViewHolder extends RecyclerView.ViewHolder {

        public MembersViewHolder(@NonNull View itemView) {
            super(itemView);

            txtmembersName = itemView.findViewById(R.id.txtMembersName);

        }
    }
}
