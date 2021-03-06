// Generated by data binding compiler. Do not edit!
package com.app.swagliv.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.app.swagliv.R;
import com.app.swagliv.model.profile.pojo.Subscription;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ItemAdvertiseBinding extends ViewDataBinding {
  @NonNull
  public final CircleImageView icon;

  @NonNull
  public final TextView likeText;

  @NonNull
  public final TextView subscriptionNameText;

  @NonNull
  public final TextView text;

  @Bindable
  protected Subscription mSubscription;

  protected ItemAdvertiseBinding(Object _bindingComponent, View _root, int _localFieldCount,
      CircleImageView icon, TextView likeText, TextView subscriptionNameText, TextView text) {
    super(_bindingComponent, _root, _localFieldCount);
    this.icon = icon;
    this.likeText = likeText;
    this.subscriptionNameText = subscriptionNameText;
    this.text = text;
  }

  public abstract void setSubscription(@Nullable Subscription Subscription);

  @Nullable
  public Subscription getSubscription() {
    return mSubscription;
  }

  @NonNull
  public static ItemAdvertiseBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_advertise, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ItemAdvertiseBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ItemAdvertiseBinding>inflateInternal(inflater, R.layout.item_advertise, root, attachToRoot, component);
  }

  @NonNull
  public static ItemAdvertiseBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_advertise, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ItemAdvertiseBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ItemAdvertiseBinding>inflateInternal(inflater, R.layout.item_advertise, null, false, component);
  }

  public static ItemAdvertiseBinding bind(@NonNull View view) {
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
  public static ItemAdvertiseBinding bind(@NonNull View view, @Nullable Object component) {
    return (ItemAdvertiseBinding)bind(component, view, R.layout.item_advertise);
  }
}
