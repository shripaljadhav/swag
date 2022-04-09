package com.app.swagliv.view.adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.app.swagliv.R;
import com.app.swagliv.model.store.Category;
import com.skydoves.powerspinner.OnSpinnerItemSelectedListener;
import com.skydoves.powerspinner.PowerSpinnerInterface;
import com.skydoves.powerspinner.PowerSpinnerView;

import java.util.ArrayList;
import java.util.List;

public class CategorySpinnerAdapter extends RecyclerView.Adapter<CategorySpinnerAdapter.CategoryViewHolder> implements PowerSpinnerInterface<Category> {

    private final PowerSpinnerView powerSpinnerView;
    private ArrayList<Category> categories;
    private int index;

    public CategorySpinnerAdapter(PowerSpinnerView powerSpinnerView) {
        this.powerSpinnerView = powerSpinnerView;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoryViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_spinner_category,parent,false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category = categories.get(position);
        TextView textView = holder.itemView.findViewById(R.id.textview_category);
        textView.setText(category.getLabel());
        holder.itemView.setOnClickListener(v -> notifyItemSelected(position));
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    @Override
    public int getIndex() {
        return powerSpinnerView.getSelectedIndex();
    }

    @Override
    public void setIndex(int index) {
    }

    @Nullable
    @Override
    public OnSpinnerItemSelectedListener<Category> getOnSpinnerItemSelectedListener() {
        return null;
    }

    @Override
    public void setOnSpinnerItemSelectedListener(@Nullable OnSpinnerItemSelectedListener<Category> onSpinnerItemSelectedListener) {

    }

    @NonNull
    @Override
    public PowerSpinnerView getSpinnerView() {
        return powerSpinnerView;
    }

    @Override
    public void notifyItemSelected(int index) {
        if(index<0) return;
        int oldIndex = this.index;
        this.index = index;
        powerSpinnerView.notifyItemSelected(index, categories.get(index).getLabel());
    }

    @Override
    public void setItems(@NonNull List<? extends Category> categories) {
        this.categories = (ArrayList<Category>) categories;
    }

    public ArrayList<Category> getItems() {
        return categories;
    }

    static final class CategoryViewHolder extends RecyclerView.ViewHolder{

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
