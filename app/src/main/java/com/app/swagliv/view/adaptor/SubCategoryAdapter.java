package com.app.swagliv.view.adaptor;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.swagliv.R;
import com.app.swagliv.model.store.Category;

import java.util.ArrayList;

public class SubCategoryAdapter extends RecyclerView.Adapter<SubCategoryAdapter.CategoryViewHolder> {

    private final ArrayList<Category> categories;
    private final View.OnClickListener onClickListener;
    private Category selectedCategory=null;

    public SubCategoryAdapter(ArrayList<Category> categories, View.OnClickListener onClickListener) {
        this.categories = categories;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoryViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_sub_category,parent,false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category = categories.get(position);
        TextView textViewCategory = holder.itemView.findViewById(R.id.textview_category);
        textViewCategory.setText(category.getLabel());
        holder.itemView.setOnClickListener(onClickListener);
        holder.itemView.setTag(R.string.tag_category,category);
        if(category!=null && selectedCategory!=null && category.get_id().equals(selectedCategory.get_id())){
            holder.itemView.setBackgroundColor(Color.parseColor("#E83587"));
        }else {
            holder.itemView.setBackgroundResource(R.drawable.ic_rounded_corner);
        }
    }

    public void setSelected(Category category){
        selectedCategory = category;
        notifyDataSetChanged();
    }

    public Category getSelectedCategory() {
        return selectedCategory;
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    static final class CategoryViewHolder extends RecyclerView.ViewHolder{

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
