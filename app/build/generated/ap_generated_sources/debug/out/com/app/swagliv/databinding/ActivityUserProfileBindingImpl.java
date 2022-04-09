package com.app.swagliv.databinding;
import com.app.swagliv.R;
import com.app.swagliv.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityUserProfileBindingImpl extends ActivityUserProfileBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(21);
        sIncludes.setIncludes(1, 
            new String[] {"common_header"},
            new int[] {8},
            new int[] {com.app.swagliv.R.layout.common_header});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.profile_txt, 9);
        sViewsWithIds.put(R.id.layout_profile, 10);
        sViewsWithIds.put(R.id.profile_image, 11);
        sViewsWithIds.put(R.id.btnEditPofile, 12);
        sViewsWithIds.put(R.id.profile_date_selected, 13);
        sViewsWithIds.put(R.id.CurrentLocation, 14);
        sViewsWithIds.put(R.id.gender_txt, 15);
        sViewsWithIds.put(R.id.sliderRange, 16);
        sViewsWithIds.put(R.id.passion_txt, 17);
        sViewsWithIds.put(R.id.add_passsion_btn, 18);
        sViewsWithIds.put(R.id.change_password, 19);
        sViewsWithIds.put(R.id.profile_continue_btn, 20);
    }
    // views
    @NonNull
    private final android.widget.ScrollView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityUserProfileBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 21, sIncludes, sViewsWithIds));
    }
    private ActivityUserProfileBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.TextView) bindings[14]
            , (android.widget.EditText) bindings[7]
            , (android.widget.TextView) bindings[18]
            , (android.widget.LinearLayout) bindings[12]
            , (android.widget.LinearLayout) bindings[19]
            , (com.app.swagliv.databinding.CommonHeaderBinding) bindings[8]
            , (android.widget.TextView) bindings[6]
            , (android.widget.LinearLayout) bindings[15]
            , (android.widget.TextView) bindings[2]
            , (android.widget.LinearLayout) bindings[1]
            , (android.widget.RelativeLayout) bindings[10]
            , (android.widget.TextView) bindings[17]
            , (android.widget.LinearLayout) bindings[20]
            , (android.widget.LinearLayout) bindings[13]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[11]
            , (android.widget.TextView) bindings[4]
            , (android.widget.EditText) bindings[3]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[5]
            , (com.google.android.material.slider.RangeSlider) bindings[16]
            );
        this.aboutMeTxt.setTag(null);
        setContainedBinding(this.commonHeader);
        this.genderSelect.setTag(null);
        this.hedderProfileName.setTag(null);
        this.layProfile.setTag(null);
        this.mboundView0 = (android.widget.ScrollView) bindings[0];
        this.mboundView0.setTag(null);
        this.profileMobileNo.setTag(null);
        this.profileNameText.setTag(null);
        this.selectedDate.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        commonHeader.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (commonHeader.hasPendingBindings()) {
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
        commonHeader.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeCommonHeader((com.app.swagliv.databinding.CommonHeaderBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeCommonHeader(com.app.swagliv.databinding.CommonHeaderBinding CommonHeader, int fieldId) {
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
        java.lang.String userName = null;
        java.lang.String userContactNumber = null;
        com.app.swagliv.model.login.pojo.User user = mUser;
        java.lang.String utilityConvertDateUserDobAppCommonConstantsAPIDATEFORMATAppCommonConstantsDATEFORMATSHOWUI = null;
        java.lang.String userAboutMe = null;
        java.lang.String userDob = null;
        java.lang.String userGender = null;
        java.lang.String userContactNumberToString = null;

        if ((dirtyFlags & 0x6L) != 0) {



                if (user != null) {
                    // read user.name
                    userName = user.getName();
                    // read user.contactNumber
                    userContactNumber = user.getContactNumber();
                    // read user.aboutMe
                    userAboutMe = user.getAboutMe();
                    // read user.dob
                    userDob = user.getDob();
                    // read user.gender
                    userGender = user.getGender();
                }


                if (userContactNumber != null) {
                    // read user.contactNumber.toString()
                    userContactNumberToString = userContactNumber.toString();
                }
                // read Utility.convertDate(user.dob, AppCommonConstants.API_DATE_FORMAT, AppCommonConstants.DATE_FORMAT_SHOW_UI)
                utilityConvertDateUserDobAppCommonConstantsAPIDATEFORMATAppCommonConstantsDATEFORMATSHOWUI = com.app.common.utils.Utility.convertDate(userDob, com.app.common.constant.AppCommonConstants.API_DATE_FORMAT, com.app.common.constant.AppCommonConstants.DATE_FORMAT_SHOW_UI);
        }
        // batch finished
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.aboutMeTxt, userAboutMe);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.genderSelect, userGender);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.hedderProfileName, userName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.profileMobileNo, userContactNumberToString);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.profileNameText, userName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.selectedDate, utilityConvertDateUserDobAppCommonConstantsAPIDATEFORMATAppCommonConstantsDATEFORMATSHOWUI);
        }
        executeBindingsOn(commonHeader);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): commonHeader
        flag 1 (0x2L): user
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}