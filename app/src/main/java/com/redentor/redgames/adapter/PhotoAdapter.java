package com.redentor.redgames.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.redentor.redgames.R;
import com.redentor.redgames.model.Photo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.photoViewHolder> {
    private List<Photo> arrayListPhoto;
    private Context context;


    public PhotoAdapter( Context context) {
        this.arrayListPhoto = new ArrayList<>();
        this.context = context;
    }





    @NonNull
    @Override
    public photoViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_photo, viewGroup, false);

        return new photoViewHolder(view);




    }

    @Override
    public void onBindViewHolder(@NonNull photoViewHolder photoViewHolder, int i) {

        Photo photo = arrayListPhoto.get(i);



        Picasso.get().load(photo.getUrl()).into(photoViewHolder.imageView);

    }

    @Override
    public int getItemCount() {
        if (arrayListPhoto == null){
            return 0;
        }
        return arrayListPhoto.size();
    }

    public void atualiza(List<Photo> photos) {
        this.arrayListPhoto = photos;
        notifyDataSetChanged();

    }


    class photoViewHolder extends RecyclerView.ViewHolder  {

        private ImageView imageView;

        public photoViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }

    }
}
