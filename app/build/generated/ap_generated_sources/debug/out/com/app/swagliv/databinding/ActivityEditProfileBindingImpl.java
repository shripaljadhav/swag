package com.app.swagliv.databinding;
import com.app.swagliv.R;
import com.app.swagliv.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityEditProfileBindingImpl extends ActivityEditProfileBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(7);
        sIncludes.setIncludes(0, 
            new String[] {"common_header"},
            new int[] {3},
            new int[] {com.app.swagliv.R.layout.common_header});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.edit_mobile_txt, 4);
        sViewsWithIds.put(R.id.date_pick_ic, 5);
        sViewsWithIds.put(R.id.save_btn, 6);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityEditProfileBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }
    private ActivityEditProfileBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (com.app.swagliv.databinding.CommonHeaderBinding) bindings[3]
            , (android.widget.TextView) bindings[2]
            , (android.widget.ImageView) bindings[5]
            , (android.widget.EditText) bindings[4]
            , (android.widget.EditText) bindings[1]
            , (android.widget.TextView) bindings[6]
            );
        setContainedBinding(this.EditHeader);
        this.birthDateText.setTag(null);
        this.editNameText.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
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
        if (BR.user == variableId) {
            setUser((com.app.swagliv.model.login.pojo.User) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setUser(@Nullable com.app.swagliv.model.login.pojo.User User) {
        this.mUser = User;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.user);
        super.requestRebind();
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
        com.app.swagliv.model.login.pojo.User user = mUser;
        java.lang.String utilityConvertDateUserDobAppCommonConstantsAPIDATEFORMATAppCommonConstantsDATEFORMATSHOWUI = null;
        java.lang.String userName = null;
        java.lang.String userDob = null;

        if ((dirtyFlags & 0x6L) != 0) {



                if (user != null) {
                    // read user.name
                    userName = user.getName();
                    // read user.dob
                    userDob = user.getDob();
                }


                // read Utility.convertDate(user.dob, AppCommonConstants.API_DATE_FORMAT, AppCommonConstants.DATE_FORMAT_SHOW_UI)
                utilityConvertDateUserDobAppCommonConstantsAPIDATEFORMATAppCommonConstantsDATEFORMATSHOWUI = com.app.common.utils.Utility.convertDate(userDob, com.app.common.constant.AppCommonConstants.API_DATE_FORMAT, com.app.common.constant.AppCommonConstants.DATE_FORMAT_SHOW_UI);
        }
        // batch finished
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.birthDateText, utilityConvertDateUserDobAppCommonConstantsAPIDATEFORMATAppCommonConstantsDATEFORMATSHOWUI);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.editNameText, userName);
        }
        executeBindingsOn(EditHeader);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): EditHeader
        flag 1 (0x2L): user
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}