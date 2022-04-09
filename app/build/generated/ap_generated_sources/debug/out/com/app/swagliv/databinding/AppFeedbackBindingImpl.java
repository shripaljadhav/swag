package com.app.swagliv.databinding;
import com.app.swagliv.R;
import com.app.swagliv.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class AppFeedbackBindingImpl extends AppFeedbackBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(8);
        sIncludes.setIncludes(1, 
            new String[] {"common_header"},
            new int[] {2},
            new int[] {com.app.swagliv.R.layout.common_header});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.animationView, 3);
        sViewsWithIds.put(R.id.ratingbar, 4);
        sViewsWithIds.put(R.id.input_layout_write_your_comment, 5);
        sViewsWithIds.put(R.id.input_write_your_comment, 6);
        sViewsWithIds.put(R.id.next_btn, 7);
    }
    // views
    @NonNull
    private final android.widget.FrameLayout mboundView0;
    @NonNull
    private final android.widget.LinearLayout mboundView1;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public AppFeedbackBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }
    private AppFeedbackBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (com.airbnb.lottie.LottieAnimationView) bindings[3]
            , (com.app.swagliv.databinding.CommonHeaderBinding) bindings[2]
            , (com.google.android.material.textfield.TextInputLayout) bindings[5]
            , (android.widget.EditText) bindings[6]
            , (android.widget.Button) bindings[7]
            , (android.widget.RatingBar) bindings[4]
            );
        setContainedBinding(this.backHedder);
        this.mboundView0 = (android.widget.FrameLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.LinearLayout) bindings[1];
        this.mboundView1.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        backHedder.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (backHedder.hasPendingBindings()) {
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
        backHedder.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeBackHedder((com.app.swagliv.databinding.CommonHeaderBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeBackHedder(com.app.swagliv.databinding.CommonHeaderBinding BackHedder, int fieldId) {
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
        executeBindingsOn(backHedder);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): backHedder
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}