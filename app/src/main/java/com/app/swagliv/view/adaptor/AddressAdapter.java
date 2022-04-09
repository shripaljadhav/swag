package com.app.swagliv.view.adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.app.swagliv.R;
import com.app.swagliv.databinding.AdapterAddressBinding;
import com.app.swagliv.model.address.AddressList;

public class AddressAdapter extends ListAdapter<AddressList, AddressAdapter.AddressViewHolder> {

    private final CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
    private final View.OnClickListener onClickListener;
    private int selectedPosition = -1;

    public AddressAdapter(CompoundButton.OnCheckedChangeListener onCheckedChangeListener, View.OnClickListener onClickListener) {
        super(new AddressItemDiffUtilCallBack());
        this.onCheckedChangeListener = onCheckedChangeListener;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public AddressViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AdapterAddressBinding adapterAddressBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.adapter_address, parent, false);
        return new AddressViewHolder(adapterAddressBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull AddressViewHolder holder, int position) {
        holder.adapterAddressBinding.radioAddress.setOnCheckedChangeListener(onCheckedChangeListener);
        if (selectedPosition == position) {
            holder.adapterAddressBinding.radioAddress.setChecked(true);
        }else {
            holder.adapterAddressBinding.radioAddress.setChecked(false);
        }
        holder.adapterAddressBinding.radioAddress.setTag(R.string.tag_selected_address_position, position);
        holder.adapterAddressBinding.textviewEdit.setOnClickListener(onClickListener);
        final AddressList addressListItem = getItem(position);
        holder.adapterAddressBinding.textviewEdit.setTag(R.string.tag_selected_address,addressListItem);
        holder.adapterAddressBinding.textviewUsername.setText(addressListItem.getName());
        holder.adapterAddressBinding.textviewAddress.setText(addressListItem.getDoorNumberAndBuildingName()
                .concat(",")
                .concat(addressListItem.getStreetName())
                .concat("\n")
                .concat(addressListItem.getCity()));
        holder.adapterAddressBinding.textviewPhoneNumber.setText(addressListItem.getMobileNumber());
    }

    public void setSelectedItem(int selectedPosition) {
        this.selectedPosition = selectedPosition;
        notifyDataSetChanged();
    }

    public AddressList getSelectedItem(){
        if(selectedPosition>-1){
            return getCurrentList().get(selectedPosition);
        }
        return null;
    }

    static final class AddressViewHolder extends RecyclerView.ViewHolder {

        final AdapterAddressBinding adapterAddressBinding;

        public AddressViewHolder(@NonNull AdapterAddressBinding adapterAddressBinding) {
            super(adapterAddressBinding.getRoot());
            this.adapterAddressBinding = adapterAddressBinding;
        }
    }

    static final class AddressItemDiffUtilCallBack extends DiffUtil.ItemCallback<AddressList>{

        @Override
        public boolean areItemsTheSame(@NonNull AddressList oldItem, @NonNull AddressList newItem) {
            return oldItem.getAddressId().equals(newItem.getAddressId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull AddressList oldItem, @NonNull AddressList newItem) {
            return oldItem.equals(newItem);
        }
    }
}
