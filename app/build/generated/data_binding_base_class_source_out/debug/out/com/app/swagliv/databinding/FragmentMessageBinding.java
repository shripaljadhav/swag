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

public abstract class FragmentMessageBinding extends ViewDataBinding {
  @NonNull
  public final RecyclerView chatView;

  @NonNull
  public final CommonHeaderBinding commonHeader;

  protected FragmentMessageBinding(Object _bindingComponent, View _root, int _localFieldCount,
      RecyclerView chatView, CommonHeaderBinding commonHeader) {
    super(_bindingComponent, _root, _localFieldCount);
    this.chatView = chatView;
    this.commonHeader = commonHeader;
  }

  @NonNull
  public static FragmentMessageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_message, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentMessageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentMessageBinding>inflateInternal(inflater, R.layout.fragment_message, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentMessageBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_message, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentMessageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentMessageBinding>inflateInternal(inflater, R.layout.fragment_message, null, false, component);
  }

  public static FragmentMessageBinding bind(@NonNull View view) {
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
  public static FragmentMessageBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentMessageBinding)bind(component, view, R.layout.fragment_message);
  }
}