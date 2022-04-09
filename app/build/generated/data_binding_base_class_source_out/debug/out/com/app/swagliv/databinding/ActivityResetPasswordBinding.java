// Generated by data binding compiler. Do not edit!
package com.app.swagliv.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.app.swagliv.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityResetPasswordBinding extends ViewDataBinding {
  @NonNull
  public final LottieAnimationView animationView;

  @NonNull
  public final TextView resetPasswordBtn;

  protected ActivityResetPasswordBinding(Object _bindingComponent, View _root, int _localFieldCount,
      LottieAnimationView animationView, TextView resetPasswordBtn) {
    super(_bindingComponent, _root, _localFieldCount);
    this.animationView = animationView;
    this.resetPasswordBtn = resetPasswordBtn;
  }

  @NonNull
  public static ActivityResetPasswordBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_reset_password, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityResetPasswordBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityResetPasswordBinding>inflateInternal(inflater, R.layout.activity_reset_password, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityResetPasswordBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_reset_password, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityResetPasswordBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityResetPasswordBinding>inflateInternal(inflater, R.layout.activity_reset_password, null, false, component);
  }

  public static ActivityResetPasswordBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static ActivityResetPasswordBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityResetPasswordBinding)bind(component, view, R.layout.activity_reset_password);
  }
}
