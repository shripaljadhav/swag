// Generated by data binding compiler. Do not edit!
package com.app.swagliv.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.app.swagliv.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ItemProductListingBinding extends ViewDataBinding {
  @NonNull
  public final AppCompatImageView image;

  @NonNull
  public final ConstraintLayout item;

  @NonNull
  public final AppCompatTextView textviewProductName;

  @NonNull
  public final AppCompatTextView textviewProductValue;

  @NonNull
  public final AppCompatTextView textviewRate;

  @NonNull
  public final AppCompatTextView textviewRateValue;

  protected ItemProductListingBinding(Object _bindingComponent, View _root, int _localFieldCount,
      AppCompatImageView image, ConstraintLayout item, AppCompatTextView textviewProductName,
      AppCompatTextView textviewProductValue, AppCompatTextView textviewRate,
      AppCompatTextView textviewRateValue) {
    super(_bindingComponent, _root, _localFieldCount);
    this.image = image;
    this.item = item;
    this.textviewProductName = textviewProductName;
    this.textviewProductValue = textviewProductValue;
    this.textviewRate = textviewRate;
    this.textviewRateValue = textviewRateValue;
  }

  @NonNull
  public static ItemProductListingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_product_listing, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ItemProductListingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ItemProductListingBinding>inflateInternal(inflater, R.layout.item_product_listing, root, attachToRoot, component);
  }

  @NonNull
  public static ItemProductListingBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_product_listing, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ItemProductListingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ItemProductListingBinding>inflateInternal(inflater, R.layout.item_product_listing, null, false, component);
  }

  public static ItemProductListingBinding bind(@NonNull View view) {
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
  public static ItemProductListingBinding bind(@NonNull View view, @Nullable Object component) {
    return (ItemProductListingBinding)bind(component, view, R.layout.item_product_listing);
  }
}
