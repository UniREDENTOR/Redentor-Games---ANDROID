package com.redentor.redgames.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.redentor.redgames.ChooseTeamVotationActivity;
import com.redentor.redgames.R;
import com.redentor.redgames.model.Event;

import java.util.ArrayList;
import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {

    private Context context;
    private List<Event> listEvent;


    public EventAdapter(Context context) {
        this.context = context;
        this.listEvent = new ArrayList<>();
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_event, viewGroup, false);

        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder eventViewHolder, int i) {
        Event event = listEvent.get(i);

        eventViewHolder.txtNameEvent.setText(event.getName());
        eventViewHolder.txtDescriptionEvent.setText(event.getDescription());


        eventViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ChooseTeamVotationActivity.class);
                intent.putExtra("idevento",event);
                context.startActivity(intent);

            }
        });




    }

    @Override
    public int getItemCount() {

        if (listEvent == null) {
            return 0;
        }

       return listEvent.size();
    }

    public void atualiza(List<Event> events) {
        this.listEvent = events;
        notifyDataSetChanged();
    }

    class EventViewHolder extends RecyclerView.ViewHolder {

        private TextView txtNameEvent, txtDescriptionEvent;


        public EventViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNameEvent = itemView.findViewById(R.id.txtNomeEvent);
            txtDescriptionEvent = itemView.findViewById(R.id.txtEventDescription);

        }
    }
}
