// Generated by data binding compiler. Do not edit!
package com.app.swagliv.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.app.swagliv.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivitySignupBinding extends ViewDataBinding {
  @NonNull
  public final LottieAnimationView animationView;

  @NonNull
  public final TextView dateClick;

  @NonNull
  public final EditText emailText;

  @NonNull
  public final TextView genderText;

  @NonNull
  public final EditText nameText;

  @NonNull
  public final TextView signup;

  @NonNull
  public final EditText txtConformPassword;

  @NonNull
  public final EditText txtPassword;

  protected ActivitySignupBinding(Object _bindingComponent, View _root, int _localFieldCount,
      LottieAnimationView animationView, TextView dateClick, EditText emailText,
      TextView genderText, EditText nameText, TextView signup, EditText txtConformPassword,
      EditText txtPassword) {
    super(_bindingComponent, _root, _localFieldCount);
    this.animationView = animationView;
    this.dateClick = dateClick;
    this.emailText = emailText;
    this.genderText = genderText;
    this.nameText = nameText;
    this.signup = signup;
    this.txtConformPassword = txtConformPassword;
    this.txtPassword = txtPassword;
  }

  @NonNull
  public static ActivitySignupBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_signup, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivitySignupBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivitySignupBinding>inflateInternal(inflater, R.layout.activity_signup, root, attachToRoot, component);
  }

  @NonNull
  public static ActivitySignupBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_signup, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivitySignupBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivitySignupBinding>inflateInternal(inflater, R.layout.activity_signup, null, false, component);
  }

  public static ActivitySignupBinding bind(@NonNull View view) {
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
  public static ActivitySignupBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivitySignupBinding)bind(component, view, R.layout.activity_signup);
  }
}
