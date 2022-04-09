package com.app.swagliv.databinding;
import com.app.swagliv.R;
import com.app.swagliv.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemSearchBindingImpl extends ItemSearchBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.pictures, 4);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemSearchBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }
    private ItemSearchBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[1]
            , (android.widget.LinearLayout) bindings[0]
            , (com.google.android.material.imageview.ShapeableImageView) bindings[4]
            );
        this.crushAge.setTag(null);
        this.crushGender.setTag(null);
        this.crushName.setTag(null);
        this.parentLayout.setTag(null);
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
        if (BR.crushInfo == variableId) {
            setCrushInfo((com.app.swagliv.model.login.pojo.User) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setCrushInfo(@Nullable com.app.swagliv.model.login.pojo.User CrushInfo) {
        this.mCrushInfo = CrushInfo;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.crushInfo);
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
        java.lang.String stringValueOfCrushInfoUserAge = null;
        java.lang.String crushInfoGender = null;
        com.app.swagliv.model.login.pojo.User crushInfo = mCrushInfo;
        java.lang.String crushInfoName = null;
        int crushInfoUserAge = 0;

        if ((dirtyFlags & 0x3L) != 0) {



                if (crushInfo != null) {
                    // read crushInfo.gender
                    crushInfoGender = crushInfo.getGender();
                    // read crushInfo.name
                    crushInfoName = crushInfo.getName();
                    // read crushInfo.userAge
                    crushInfoUserAge = crushInfo.getUserAge();
                }


                // read String.valueOf(crushInfo.userAge)
                stringValueOfCrushInfoUserAge = java.lang.String.valueOf(crushInfoUserAge);
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.crushAge, stringValueOfCrushInfoUserAge);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.crushGender, crushInfoGender);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.crushName, crushInfoName);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): crushInfo
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}