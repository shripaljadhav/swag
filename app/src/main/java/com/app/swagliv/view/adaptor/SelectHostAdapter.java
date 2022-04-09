package com.app.swagliv.view.adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.swagliv.R;
import com.app.swagliv.databinding.SearchGifItemBinding;
import com.app.swagliv.databinding.SelectHostItemBinding;
import com.app.swagliv.shripal.GetHostList;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;

import java.util.ArrayList;

public class SelectHostAdapter extends RecyclerView.Adapter<SelectHostAdapter.ViewHolder> {

    private ArrayList<GetHostList.Datum> hostsList = new ArrayList<>();


    public SelectHostAdapter(ArrayList<GetHostList.Datum> hostsList) {
        this.hostsList = hostsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.select_host_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        GetHostList.Datum data = hostsList.get(position);

        Glide.with(holder.itemView.getContext())
                .load(data.getImages().getProfileImages())
                .into(holder.binding.hostImageView);

    }

    @Override
    public int getItemCount() {
        return hostsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        SelectHostItemBinding binding;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = SelectHostItemBinding.bind(itemView);
        }
    }

}
