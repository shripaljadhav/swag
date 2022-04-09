package com.app.swagliv.view.adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.swagliv.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ImagesViewHolder> {

    private final ArrayList<String> images;

    public ImagesAdapter(ArrayList<String> images) {
        this.images = images;
    }

    @NonNull
    @Override
    public ImagesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ImagesViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_images,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ImagesViewHolder holder, int position) {
        ImageView imageView = (ImageView) holder.itemView;
        Glide.with(imageView.getContext())
                .load(images.get(position))
                .centerCrop()
                .into(imageView);
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    static final class ImagesViewHolder extends RecyclerView.ViewHolder {
        public ImagesViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
