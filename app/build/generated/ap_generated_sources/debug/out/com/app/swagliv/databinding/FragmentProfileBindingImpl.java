package com.app.swagliv.databinding;
import com.app.swagliv.R;
import com.app.swagliv.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentProfileBindingImpl extends FragmentProfileBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.lay, 4);
        sViewsWithIds.put(R.id.profile_text, 5);
        sViewsWithIds.put(R.id.layout_profile, 6);
        sViewsWithIds.put(R.id.progress_bar, 7);
        sViewsWithIds.put(R.id.profile_image, 8);
        sViewsWithIds.put(R.id.btnEditPofile, 9);
        sViewsWithIds.put(R.id.ic_camera, 10);
        sViewsWithIds.put(R.id.ic_video, 11);
        sViewsWithIds.put(R.id.ic_product_list, 12);
        sViewsWithIds.put(R.id.otherImagesParentLayout, 13);
        sViewsWithIds.put(R.id.pictures_view, 14);
        sViewsWithIds.put(R.id.lay2, 15);
        sViewsWithIds.put(R.id.profile_edit_txt, 16);
        sViewsWithIds.put(R.id.profile_name_txt, 17);
        sViewsWithIds.put(R.id.mobile, 18);
        sViewsWithIds.put(R.id.current_plan, 19);
        sViewsWithIds.put(R.id.current_location, 20);
        sViewsWithIds.put(R.id.show_me_men_txt, 21);
        sViewsWithIds.put(R.id.sliderRange, 22);
        sViewsWithIds.put(R.id.distance_range_slider, 23);
        sViewsWithIds.put(R.id.passion_btn_continue, 24);
    }
    // views
    @NonNull
    private final android.widget.ScrollView mboundView0;
    @NonNull
    private final android.widget.TextView mboundView1;
    @NonNull
    private final android.widget.TextView mboundView2;
    @NonNull
    private final android.widget.TextView mboundView3;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentProfileBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 25, sIncludes, sViewsWithIds));
    }
    private FragmentProfileBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[9]
            , (android.widget.TextView) bindings[20]
            , (android.widget.TextView) bindings[19]
            , (com.google.android.material.slider.RangeSlider) bindings[23]
            , (android.widget.ImageView) bindings[10]
            , (android.widget.ImageView) bindings[12]
            , (android.widget.ImageView) bindings[11]
            , (android.widget.RelativeLayout) bindings[4]
            , (android.widget.LinearLayout) bindings[15]
            , (android.widget.RelativeLayout) bindings[6]
            , (android.widget.TextView) bindings[18]
            , (android.widget.LinearLayout) bindings[13]
            , (android.widget.LinearLayout) bindings[24]
            , (androidx.recyclerview.widget.RecyclerView) bindings[14]
            , (android.widget.TextView) bindings[16]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[8]
            , (android.widget.TextView) bindings[17]
            , (android.widget.TextView) bindings[5]
            , (android.widget.ProgressBar) bindings[7]
            , (android.widget.TextView) bindings[21]
            , (com.google.android.material.slider.RangeSlider) bindings[22]
            );
        this.mboundView0 = (android.widget.ScrollView) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.TextView) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView2 = (android.widget.TextView) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView3 = (android.widget.TextView) bindings[3];
        this.mboundView3.setTag(null);
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
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.user);
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
        java.lang.String userName = null;
        com.app.swagliv.model.login.pojo.User user = mUser;
        java.lang.String utilityConvertDateUserDobAppCommonConstantsAPIDATEFORMATAppCommonConstantsDATEFORMATSHOWUI = null;
        java.lang.String userDob = null;

        if ((dirtyFlags & 0x3L) != 0) {



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
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView1, userName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView2, userName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView3, utilityConvertDateUserDobAppCommonConstantsAPIDATEFORMATAppCommonConstantsDATEFORMATSHOWUI);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): user
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}