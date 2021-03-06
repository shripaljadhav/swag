// Generated by data binding compiler. Do not edit!
package com.app.swagliv.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.app.swagliv.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityShopBinding extends ViewDataBinding {
  @NonNull
  public final CommonHeaderBinding commonHeader;

  @NonNull
  public final RecyclerView shopView;

  protected ActivityShopBinding(Object _bindingComponent, View _root, int _localFieldCount,
      CommonHeaderBinding commonHeader, RecyclerView shopView) {
    super(_bindingComponent, _root, _localFieldCount);
    this.commonHeader = commonHeader;
    this.shopView = shopView;
  }

  @NonNull
  public static ActivityShopBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_shop, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityShopBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityShopBinding>inflateInternal(inflater, R.layout.activity_shop, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityShopBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_shop, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityShopBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityShopBinding>inflateInternal(inflater, R.layout.activity_shop, null, false, component);
  }

  public static ActivityShopBinding bind(@NonNull View view) {
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
  public static ActivityShopBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityShopBinding)bind(component, view, R.layout.activity_shop);
  }
}
