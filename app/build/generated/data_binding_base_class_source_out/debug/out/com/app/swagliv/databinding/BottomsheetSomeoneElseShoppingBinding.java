// Generated by data binding compiler. Do not edit!
package com.app.swagliv.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.app.swagliv.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class BottomsheetSomeoneElseShoppingBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout btnMySelf;

  @NonNull
  public final LinearLayout passionBtnContinue;

  @NonNull
  public final TextView textviewTitle;

  protected BottomsheetSomeoneElseShoppingBinding(Object _bindingComponent, View _root,
      int _localFieldCount, LinearLayout btnMySelf, LinearLayout passionBtnContinue,
      TextView textviewTitle) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnMySelf = btnMySelf;
    this.passionBtnContinue = passionBtnContinue;
    this.textviewTitle = textviewTitle;
  }

  @NonNull
  public static BottomsheetSomeoneElseShoppingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.bottomsheet_someone_else_shopping, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static BottomsheetSomeoneElseShoppingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<BottomsheetSomeoneElseShoppingBinding>inflateInternal(inflater, R.layout.bottomsheet_someone_else_shopping, root, attachToRoot, component);
  }

  @NonNull
  public static BottomsheetSomeoneElseShoppingBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.bottomsheet_someone_else_shopping, null, false, component)
   */
  @NonNull
  @Deprecated
  public static BottomsheetSomeoneElseShoppingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<BottomsheetSomeoneElseShoppingBinding>inflateInternal(inflater, R.layout.bottomsheet_someone_else_shopping, null, false, component);
  }

  public static BottomsheetSomeoneElseShoppingBinding bind(@NonNull View view) {
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
  public static BottomsheetSomeoneElseShoppingBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (BottomsheetSomeoneElseShoppingBinding)bind(component, view, R.layout.bottomsheet_someone_else_shopping);
  }
}
