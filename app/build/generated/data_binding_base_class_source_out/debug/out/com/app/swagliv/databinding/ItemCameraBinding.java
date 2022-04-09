// Generated by data binding compiler. Do not edit!
package com.app.swagliv.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.app.swagliv.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ItemCameraBinding extends ViewDataBinding {
  @NonNull
  public final AppCompatImageView image;

  @NonNull
  public final ConstraintLayout layoutCamera;

  protected ItemCameraBinding(Object _bindingComponent, View _root, int _localFieldCount,
      AppCompatImageView image, ConstraintLayout layoutCamera) {
    super(_bindingComponent, _root, _localFieldCount);
    this.image = image;
    this.layoutCamera = layoutCamera;
  }

  @NonNull
  public static ItemCameraBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_camera, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ItemCameraBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ItemCameraBinding>inflateInternal(inflater, R.layout.item_camera, root, attachToRoot, component);
  }

  @NonNull
  public static ItemCameraBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_camera, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ItemCameraBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ItemCameraBinding>inflateInternal(inflater, R.layout.item_camera, null, false, component);
  }

  public static ItemCameraBinding bind(@NonNull View view) {
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
  public static ItemCameraBinding bind(@NonNull View view, @Nullable Object component) {
    return (ItemCameraBinding)bind(component, view, R.layout.item_camera);
  }
}