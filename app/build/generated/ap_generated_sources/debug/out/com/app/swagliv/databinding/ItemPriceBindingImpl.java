package com.app.swagliv.databinding;
import com.app.swagliv.R;
import com.app.swagliv.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemPriceBindingImpl extends ItemPriceBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemPriceBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }
    private ItemPriceBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[2]
            , (android.widget.LinearLayout) bindings[0]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[1]
            );
        this.month.setTag(null);
        this.monthNo.setTag(null);
        this.parentLayout.setTag(null);
        this.price.setTag(null);
        this.subscriptionName.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.price == variableId) {
            setPrice((com.app.swagliv.model.profile.pojo.Subscription) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setPrice(@Nullable com.app.swagliv.model.profile.pojo.Subscription Price) {
        this.mPrice = Price;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.price);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        int priceIsSelectedSubscriptionNameAndroidColorWhiteSubscriptionNameAndroidColorBlack = 0;
        int priceIsSelectedMonthNoAndroidColorWhiteMonthNoAndroidColorBlack = 0;
        android.graphics.drawable.Drawable priceIsSelectedParentLayoutAndroidDrawablePriceHighlitedBorderParentLayoutAndroidDrawablePriceNormalBorder = null;
        int priceIsSelectedMonthAndroidColorWhiteMonthAndroidColorBlack = 0;
        int priceIsSelectedPriceAndroidColorWhitePriceAndroidColorBlack = 0;
        boolean priceIsSelected = false;
        com.app.swagliv.model.profile.pojo.Subscription Price1 = mPrice;

        if ((dirtyFlags & 0x3L) != 0) {



                if (Price1 != null) {
                    // read price.isSelected
                    priceIsSelected = Price1.isSelected();
                }
            if((dirtyFlags & 0x3L) != 0) {
                if(priceIsSelected) {
                        dirtyFlags |= 0x8L;
                        dirtyFlags |= 0x20L;
                        dirtyFlags |= 0x80L;
                        dirtyFlags |= 0x200L;
                        dirtyFlags |= 0x800L;
                }
                else {
                        dirtyFlags |= 0x4L;
                        dirtyFlags |= 0x10L;
                        dirtyFlags |= 0x40L;
                        dirtyFlags |= 0x100L;
                        dirtyFlags |= 0x400L;
                }
            }


                // read price.isSelected ? @android:color/white : @android:color/black
                priceIsSelectedSubscriptionNameAndroidColorWhiteSubscriptionNameAndroidColorBlack = ((priceIsSelected) ? (getColorFromResource(subscriptionName, R.color.white)) : (getColorFromResource(subscriptionName, R.color.black)));
                // read price.isSelected ? @android:color/white : @android:color/black
                priceIsSelectedMonthNoAndroidColorWhiteMonthNoAndroidColorBlack = ((priceIsSelected) ? (getColorFromResource(monthNo, R.color.white)) : (getColorFromResource(monthNo, R.color.black)));
                // read price.isSelected ? @android:drawable/price_highlited_border : @android:drawable/price_normal_border
                priceIsSelectedParentLayoutAndroidDrawablePriceHighlitedBorderParentLayoutAndroidDrawablePriceNormalBorder = ((priceIsSelected) ? (androidx.appcompat.content.res.AppCompatResources.getDrawable(parentLayout.getContext(), R.drawable.price_highlited_border)) : (androidx.appcompat.content.res.AppCompatResources.getDrawable(parentLayout.getContext(), R.drawable.price_normal_border)));
                // read price.isSelected ? @android:color/white : @android:color/black
                priceIsSelectedMonthAndroidColorWhiteMonthAndroidColorBlack = ((priceIsSelected) ? (getColorFromResource(month, R.color.white)) : (getColorFromResource(month, R.color.black)));
                // read price.isSelected ? @android:color/white : @android:color/black
                priceIsSelectedPriceAndroidColorWhitePriceAndroidColorBlack = ((priceIsSelected) ? (getColorFromResource(price, R.color.white)) : (getColorFromResource(price, R.color.black)));
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            this.month.setTextColor(priceIsSelectedMonthAndroidColorWhiteMonthAndroidColorBlack);
            this.monthNo.setTextColor(priceIsSelectedMonthNoAndroidColorWhiteMonthNoAndroidColorBlack);
            androidx.databinding.adapters.ViewBindingAdapter.setBackground(this.parentLayout, priceIsSelectedParentLayoutAndroidDrawablePriceHighlitedBorderParentLayoutAndroidDrawablePriceNormalBorder);
            this.price.setTextColor(priceIsSelectedPriceAndroidColorWhitePriceAndroidColorBlack);
            this.subscriptionName.setTextColor(priceIsSelectedSubscriptionNameAndroidColorWhiteSubscriptionNameAndroidColorBlack);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): price
        flag 1 (0x2L): null
        flag 2 (0x3L): price.isSelected ? @android:color/white : @android:color/black
        flag 3 (0x4L): price.isSelected ? @android:color/white : @android:color/black
        flag 4 (0x5L): price.isSelected ? @android:color/white : @android:color/black
        flag 5 (0x6L): price.isSelected ? @android:color/white : @android:color/black
        flag 6 (0x7L): price.isSelected ? @android:drawable/price_highlited_border : @android:drawable/price_normal_border
        flag 7 (0x8L): price.isSelected ? @android:drawable/price_highlited_border : @android:drawable/price_normal_border
        flag 8 (0x9L): price.isSelected ? @android:color/white : @android:color/black
        flag 9 (0xaL): price.isSelected ? @android:color/white : @android:color/black
        flag 10 (0xbL): price.isSelected ? @android:color/white : @android:color/black
        flag 11 (0xcL): price.isSelected ? @android:color/white : @android:color/black
    flag mapping end*/
    //end
}