package com.app.swagliv.databinding;
import com.app.swagliv.R;
import com.app.swagliv.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentHomeBindingImpl extends FragmentHomeBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(17);
        sIncludes.setIncludes(0, 
            new String[] {"layout_filter"},
            new int[] {1},
            new int[] {com.app.swagliv.R.layout.layout_filter});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.peoples_empty_data_view, 2);
        sViewsWithIds.put(R.id.text_view_empty_people_msg, 3);
        sViewsWithIds.put(R.id.profile_setting_btn, 4);
        sViewsWithIds.put(R.id.peoples_profile, 5);
        sViewsWithIds.put(R.id.backgroundLayout, 6);
        sViewsWithIds.put(R.id.actionBarHeader, 7);
        sViewsWithIds.put(R.id.drawerIcon, 8);
        sViewsWithIds.put(R.id.drawerIconForStore, 9);
        sViewsWithIds.put(R.id.filter_icon, 10);
        sViewsWithIds.put(R.id.card_stack_view, 11);
        sViewsWithIds.put(R.id.button_container, 12);
        sViewsWithIds.put(R.id.skip_button, 13);
        sViewsWithIds.put(R.id.undo_button, 14);
        sViewsWithIds.put(R.id.super_like_button, 15);
        sViewsWithIds.put(R.id.like_button, 16);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentHomeBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 17, sIncludes, sViewsWithIds));
    }
    private FragmentHomeBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.RelativeLayout) bindings[7]
            , (android.widget.LinearLayout) bindings[6]
            , (android.widget.LinearLayout) bindings[12]
            , (com.yuyakaido.android.cardstackview.CardStackView) bindings[11]
            , (android.widget.ImageView) bindings[8]
            , (android.widget.ImageView) bindings[9]
            , (android.widget.ImageView) bindings[10]
            , (com.app.swagliv.databinding.LayoutFilterBinding) bindings[1]
            , (android.widget.LinearLayout) bindings[16]
            , (android.widget.LinearLayout) bindings[2]
            , (android.widget.RelativeLayout) bindings[5]
            , (android.widget.TextView) bindings[4]
            , (android.widget.LinearLayout) bindings[13]
            , (android.widget.RelativeLayout) bindings[15]
            , (android.widget.TextView) bindings[3]
            , (android.widget.RelativeLayout) bindings[14]
            );
        setContainedBinding(this.filterLayout);
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        filterLayout.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (filterLayout.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    public void setLifecycleOwner(@Nullable androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        filterLayout.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeFilterLayout((com.app.swagliv.databinding.LayoutFilterBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeFilterLayout(com.app.swagliv.databinding.LayoutFilterBinding FilterLayout, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
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
        // batch finished
        executeBindingsOn(filterLayout);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): filterLayout
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}