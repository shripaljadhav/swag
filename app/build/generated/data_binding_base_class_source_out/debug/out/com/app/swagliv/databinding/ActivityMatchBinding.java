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
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityMatchBinding extends ViewDataBinding {
  @NonNull
  public final LottieAnimationView animationView;

  @NonNull
  public final TextView keepSwipingBtn;

  @NonNull
  public final TextView nameTxt;

  @NonNull
  public final CircleImageView profile1;

  @NonNull
  public final CircleImageView profile2;

  @NonNull
  public final TextView sendMsgBtn;

  protected ActivityMatchBinding(Object _bindingComponent, View _root, int _localFieldCount,
      LottieAnimationView animationView, TextView keepSwipingBtn, TextView nameTxt,
      CircleImageView profile1, CircleImageView profile2, TextView sendMsgBtn) {
    super(_bindingComponent, _root, _localFieldCount);
    this.animationView = animationView;
    this.keepSwipingBtn = keepSwipingBtn;
    this.nameTxt = nameTxt;
    this.profile1 = profile1;
    this.profile2 = profile2;
    this.sendMsgBtn = sendMsgBtn;
  }

  @NonNull
  public static ActivityMatchBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_match, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityMatchBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityMatchBinding>inflateInternal(inflater, R.layout.activity_match, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityMatchBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_match, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityMatchBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityMatchBinding>inflateInternal(inflater, R.layout.activity_match, null, false, component);
  }

  public static ActivityMatchBinding bind(@NonNull View view) {
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
  public static ActivityMatchBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityMatchBinding)bind(component, view, R.layout.activity_match);
  }
}
