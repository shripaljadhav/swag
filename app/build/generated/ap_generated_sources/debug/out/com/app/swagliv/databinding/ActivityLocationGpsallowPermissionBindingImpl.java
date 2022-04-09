package com.app.swagliv.databinding;
import com.app.swagliv.R;
import com.app.swagliv.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityLocationGpsallowPermissionBindingImpl extends ActivityLocationGpsallowPermissionBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityLocationGpsallowPermissionBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }
    private ActivityLocationGpsallowPermissionBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[1]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[4]
            );
        this.imageView.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.textView.setTag(null);
        this.textView2.setTag(null);
        this.textView3.setTag(null);
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
        if (BR.isForLocationPermission == variableId) {
            setIsForLocationPermission((java.lang.Boolean) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setIsForLocationPermission(@Nullable java.lang.Boolean IsForLocationPermission) {
        this.mIsForLocationPermission = IsForLocationPermission;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.isForLocationPermission);
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
        java.lang.String isForLocationPermissionTextView3AndroidStringBtnAllowTextView3AndroidStringBtnEnableGps = null;
        java.lang.Boolean isForLocationPermission = mIsForLocationPermission;
        java.lang.String isForLocationPermissionTextView2AndroidStringEnableLocationDetailMsgTextView2AndroidStringErrGpsEnableMsg = null;
        android.graphics.drawable.Drawable isForLocationPermissionImageViewAndroidDrawableIcLocationV2ImageViewAndroidDrawableIcBaselineGps = null;
        boolean androidxDatabindingViewDataBindingSafeUnboxIsForLocationPermission = false;
        java.lang.String isForLocationPermissionTextViewAndroidStringEnableLocationTitleTextViewAndroidStringMsgOops = null;

        if ((dirtyFlags & 0x3L) != 0) {



                // read androidx.databinding.ViewDataBinding.safeUnbox(isForLocationPermission)
                androidxDatabindingViewDataBindingSafeUnboxIsForLocationPermission = androidx.databinding.ViewDataBinding.safeUnbox(isForLocationPermission);
            if((dirtyFlags & 0x3L) != 0) {
                if(androidxDatabindingViewDataBindingSafeUnboxIsForLocationPermission) {
                        dirtyFlags |= 0x8L;
                        dirtyFlags |= 0x20L;
                        dirtyFlags |= 0x80L;
                        dirtyFlags |= 0x200L;
                }
                else {
                        dirtyFlags |= 0x4L;
                        dirtyFlags |= 0x10L;
                        dirtyFlags |= 0x40L;
                        dirtyFlags |= 0x100L;
                }
            }


                // read androidx.databinding.ViewDataBinding.safeUnbox(isForLocationPermission) ? @android:string/btn_allow : @android:string/btn_enable_gps
                isForLocationPermissionTextView3AndroidStringBtnAllowTextView3AndroidStringBtnEnableGps = ((androidxDatabindingViewDataBindingSafeUnboxIsForLocationPermission) ? (textView3.getResources().getString(R.string.btn_allow)) : (textView3.getResources().getString(R.string.btn_enable_gps)));
                // read androidx.databinding.ViewDataBinding.safeUnbox(isForLocationPermission) ? @android:string/enable_location_detail_msg : @android:string/err_gps_enable_msg
                isForLocationPermissionTextView2AndroidStringEnableLocationDetailMsgTextView2AndroidStringErrGpsEnableMsg = ((androidxDatabindingViewDataBindingSafeUnboxIsForLocationPermission) ? (textView2.getResources().getString(R.string.enable_location_detail_msg)) : (textView2.getResources().getString(R.string.err_gps_enable_msg)));
                // read androidx.databinding.ViewDataBinding.safeUnbox(isForLocationPermission) ? @android:drawable/ic_location_v2 : @android:drawable/ic_baseline_gps
                isForLocationPermissionImageViewAndroidDrawableIcLocationV2ImageViewAndroidDrawableIcBaselineGps = ((androidxDatabindingViewDataBindingSafeUnboxIsForLocationPermission) ? (androidx.appcompat.content.res.AppCompatResources.getDrawable(imageView.getContext(), R.drawable.ic_location_v2)) : (androidx.appcompat.content.res.AppCompatResources.getDrawable(imageView.getContext(), R.drawable.ic_baseline_gps)));
                // read androidx.databinding.ViewDataBinding.safeUnbox(isForLocationPermission) ? @android:string/enable_location_title : @android:string/msg_oops
                isForLocationPermissionTextViewAndroidStringEnableLocationTitleTextViewAndroidStringMsgOops = ((androidxDatabindingViewDataBindingSafeUnboxIsForLocationPermission) ? (textView.getResources().getString(R.string.enable_location_title)) : (textView.getResources().getString(R.string.msg_oops)));
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.ImageViewBindingAdapter.setImageDrawable(this.imageView, isForLocationPermissionImageViewAndroidDrawableIcLocationV2ImageViewAndroidDrawableIcBaselineGps);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textView, isForLocationPermissionTextViewAndroidStringEnableLocationTitleTextViewAndroidStringMsgOops);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textView2, isForLocationPermissionTextView2AndroidStringEnableLocationDetailMsgTextView2AndroidStringErrGpsEnableMsg);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textView3, isForLocationPermissionTextView3AndroidStringBtnAllowTextView3AndroidStringBtnEnableGps);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): isForLocationPermission
        flag 1 (0x2L): null
        flag 2 (0x3L): androidx.databinding.ViewDataBinding.safeUnbox(isForLocationPermission) ? @android:string/btn_allow : @android:string/btn_enable_gps
        flag 3 (0x4L): androidx.databinding.ViewDataBinding.safeUnbox(isForLocationPermission) ? @android:string/btn_allow : @android:string/btn_enable_gps
        flag 4 (0x5L): androidx.databinding.ViewDataBinding.safeUnbox(isForLocationPermission) ? @android:string/enable_location_detail_msg : @android:string/err_gps_enable_msg
        flag 5 (0x6L): androidx.databinding.ViewDataBinding.safeUnbox(isForLocationPermission) ? @android:string/enable_location_detail_msg : @android:string/err_gps_enable_msg
        flag 6 (0x7L): androidx.databinding.ViewDataBinding.safeUnbox(isForLocationPermission) ? @android:drawable/ic_location_v2 : @android:drawable/ic_baseline_gps
        flag 7 (0x8L): androidx.databinding.ViewDataBinding.safeUnbox(isForLocationPermission) ? @android:drawable/ic_location_v2 : @android:drawable/ic_baseline_gps
        flag 8 (0x9L): androidx.databinding.ViewDataBinding.safeUnbox(isForLocationPermission) ? @android:string/enable_location_title : @android:string/msg_oops
        flag 9 (0xaL): androidx.databinding.ViewDataBinding.safeUnbox(isForLocationPermission) ? @android:string/enable_location_title : @android:string/msg_oops
    flag mapping end*/
    //end
}