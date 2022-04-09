package com.app.swagliv.view.adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.app.swagliv.R;
import com.app.swagliv.databinding.ItemAddProductImagesBinding;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;

import java.util.ArrayList;

public class AddProductImagesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final ArrayList<String> images = new ArrayList<String>();
    private final int GALLERY = 1, CAMERA = 0, IMAGE = 2;
    private final View.OnClickListener onClickListener;

    public AddProductImagesAdapter(View.OnClickListener onClickListener) {
        images.add("");
        images.add("");
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case GALLERY:
                final View galleryView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gallery, parent, false);
                viewHolder = new GalleryViewHolder(galleryView);
                break;
            case CAMERA:
                final View cameraView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_camera, parent, false);
                viewHolder = new CameraViewHolder(cameraView);
                break;
            case IMAGE:
                ItemAddProductImagesBinding addProductImagesBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_add_product_images, parent, false);
                viewHolder = new AddProductImagesViewHolder(addProductImagesBinding);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof AddProductImagesViewHolder) {
            String image = images.get(position);
            final AddProductImagesViewHolder addProductImagesViewHolder = (AddProductImagesViewHolder) holder;
            Glide.with(holder.itemView.getContext())
                    .load(image)
                    .transform(new CenterCrop(),new RoundedCorners(holder.itemView.getContext().getResources().getDimensionPixelSize(R.dimen.dp8)))
                    .into(addProductImagesViewHolder.addProductImagesBinding.image);
        } else {
            holder.itemView.setOnClickListener(onClickListener);
        }
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == GALLERY) {
            return GALLERY;
        } else if (position == CAMERA) {
            return CAMERA;
        } else {
            return IMAGE;
        }
    }

    public void setImage(String image) {
        images.add(image);
        notifyDataSetChanged();
    }

    public ArrayList<String> getImages() {
        if(images.size()>2){
            return new ArrayList<String>(images.subList(2,images.size()));
        }
        return null;
    }

    static final class AddProductImagesViewHolder extends RecyclerView.ViewHolder {

        private final ItemAddProductImagesBinding addProductImagesBinding;

        public AddProductImagesViewHolder(@NonNull ItemAddProductImagesBinding addProductImagesBinding) {
            super(addProductImagesBinding.getRoot());
            this.addProductImagesBinding = addProductImagesBinding;
        }
    }

    static final class GalleryViewHolder extends RecyclerView.ViewHolder {

        public GalleryViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    static final class CameraViewHolder extends RecyclerView.ViewHolder {

        public CameraViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
