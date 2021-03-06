// Generated by data binding compiler. Do not edit!
package com.app.swagliv.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.app.swagliv.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityLocationGpsallowPermissionBinding extends ViewDataBinding {
  @NonNull
  public final ImageView imageView;

  @NonNull
  public final TextView textView;

  @NonNull
  public final TextView textView2;

  @NonNull
  public final TextView textView3;

  @Bindable
  protected Boolean mIsForLocationPermission;

  protected ActivityLocationGpsallowPermissionBinding(Object _bindingComponent, View _root,
      int _localFieldCount, ImageView imageView, TextView textView, TextView textView2,
      TextView textView3) {
    super(_bindingComponent, _root, _localFieldCount);
    this.imageView = imageView;
    this.textView = textView;
    this.textView2 = textView2;
    this.textView3 = textView3;
  }

  public abstract void setIsForLocationPermission(@Nullable Boolean isForLocationPermission);

  @Nullable
  public Boolean getIsForLocationPermission() {
    return mIsForLocationPermission;
  }

  @NonNull
  public static ActivityLocationGpsallowPermissionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_location_gpsallow_permission, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityLocationGpsallowPermissionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityLocationGpsallowPermissionBinding>inflateInternal(inflater, R.layout.activity_location_gpsallow_permission, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityLocationGpsallowPermissionBinding inflate(
      @NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_location_gpsallow_permission, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityLocationGpsallowPermissionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityLocationGpsallowPermissionBinding>inflateInternal(inflater, R.layout.activity_location_gpsallow_permission, null, false, component);
  }

  public static ActivityLocationGpsallowPermissionBinding bind(@NonNull View view) {
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
  public static ActivityLocationGpsallowPermissionBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (ActivityLocationGpsallowPermissionBinding)bind(component, view, R.layout.activity_location_gpsallow_permission);
  }
}
