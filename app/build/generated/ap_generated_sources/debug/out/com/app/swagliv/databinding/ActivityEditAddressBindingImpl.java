package com.app.swagliv.databinding;
import com.app.swagliv.R;
import com.app.swagliv.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityEditAddressBindingImpl extends ActivityEditAddressBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(18);
        sIncludes.setIncludes(0, 
            new String[] {"common_header"},
            new int[] {1},
            new int[] {com.app.swagliv.R.layout.common_header});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.edittext_name, 2);
        sViewsWithIds.put(R.id.edittext_phone_number, 3);
        sViewsWithIds.put(R.id.edittext_alternate_phone_number, 4);
        sViewsWithIds.put(R.id.layout_pincode, 5);
        sViewsWithIds.put(R.id.edittext_pincode, 6);
        sViewsWithIds.put(R.id.layout_use_my_location, 7);
        sViewsWithIds.put(R.id.imageview_location, 8);
        sViewsWithIds.put(R.id.textview_use_my_location, 9);
        sViewsWithIds.put(R.id.layout_state, 10);
        sViewsWithIds.put(R.id.spinner_state, 11);
        sViewsWithIds.put(R.id.layout_city, 12);
        sViewsWithIds.put(R.id.spinner_city, 13);
        sViewsWithIds.put(R.id.edittext_house_no_building_name, 14);
        sViewsWithIds.put(R.id.edittext_road_name_area_colony, 15);
        sViewsWithIds.put(R.id.edittext_landmark, 16);
        sViewsWithIds.put(R.id.btn_next, 17);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityEditAddressBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 18, sIncludes, sViewsWithIds));
    }
    private ActivityEditAddressBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (com.app.swagliv.databinding.CommonHeaderBinding) bindings[1]
            , (android.widget.LinearLayout) bindings[17]
            , (android.widget.EditText) bindings[4]
            , (android.widget.EditText) bindings[14]
            , (android.widget.EditText) bindings[16]
            , (android.widget.EditText) bindings[2]
            , (android.widget.EditText) bindings[3]
            , (android.widget.EditText) bindings[6]
            , (android.widget.EditText) bindings[15]
            , (android.widget.ImageView) bindings[8]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[12]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[5]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[10]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[7]
            , (android.widget.EditText) bindings[13]
            , (android.widget.EditText) bindings[11]
            , (android.widget.TextView) bindings[9]
            );
        setContainedBinding(this.EditHeader);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
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
        EditHeader.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (EditHeader.hasPendingBindings()) {
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
        EditHeader.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeEditHeader((com.app.swagliv.databinding.CommonHeaderBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeEditHeader(com.app.swagliv.databinding.CommonHeaderBinding EditHeader, int fieldId) {
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
        executeBindingsOn(EditHeader);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): EditHeader
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}