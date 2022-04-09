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
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.app.swagliv.R;
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivitySubscriptionBinding extends ViewDataBinding {
  @NonNull
  public final TextView TimePeriod;

  @NonNull
  public final CommonHeaderBinding commonHeader;

  @NonNull
  public final TextView currentPlan;

  @NonNull
  public final TextView planName;

  @NonNull
  public final RecyclerView recyclerview;

  @NonNull
  public final TextView subscriptionContinueBtn;

  @NonNull
  public final TextView time;

  @NonNull
  public final TextView unsubscribeLabel;

  @NonNull
  public final TextView upgradeBtn;

  @NonNull
  public final ViewPager viewpager;

  @NonNull
  public final WormDotsIndicator wormDotsIndicator;

  protected ActivitySubscriptionBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView TimePeriod, CommonHeaderBinding commonHeader, TextView currentPlan,
      TextView planName, RecyclerView recyclerview, TextView subscriptionContinueBtn, TextView time,
      TextView unsubscribeLabel, TextView upgradeBtn, ViewPager viewpager,
      WormDotsIndicator wormDotsIndicator) {
    super(_bindingComponent, _root, _localFieldCount);
    this.TimePeriod = TimePeriod;
    this.commonHeader = commonHeader;
    this.currentPlan = currentPlan;
    this.planName = planName;
    this.recyclerview = recyclerview;
    this.subscriptionContinueBtn = subscriptionContinueBtn;
    this.time = time;
    this.unsubscribeLabel = unsubscribeLabel;
    this.upgradeBtn = upgradeBtn;
    this.viewpager = viewpager;
    this.wormDotsIndicator = wormDotsIndicator;
  }

  @NonNull
  public static ActivitySubscriptionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_subscription, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivitySubscriptionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivitySubscriptionBinding>inflateInternal(inflater, R.layout.activity_subscription, root, attachToRoot, component);
  }

  @NonNull
  public static ActivitySubscriptionBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_subscription, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivitySubscriptionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivitySubscriptionBinding>inflateInternal(inflater, R.layout.activity_subscription, null, false, component);
  }

  public static ActivitySubscriptionBinding bind(@NonNull View view) {
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
  public static ActivitySubscriptionBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivitySubscriptionBinding)bind(component, view, R.layout.activity_subscription);
  }
}
