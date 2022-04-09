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

public abstract class ActivitySearchCrushBinding extends ViewDataBinding {
  @NonNull
  public final CommonHeaderBinding commonHeader;

  @NonNull
  public final RecyclerView searchCrushView;

  protected ActivitySearchCrushBinding(Object _bindingComponent, View _root, int _localFieldCount,
      CommonHeaderBinding commonHeader, RecyclerView searchCrushView) {
    super(_bindingComponent, _root, _localFieldCount);
    this.commonHeader = commonHeader;
    this.searchCrushView = searchCrushView;
  }

  @NonNull
  public static ActivitySearchCrushBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_search_crush, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivitySearchCrushBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivitySearchCrushBinding>inflateInternal(inflater, R.layout.activity_search_crush, root, attachToRoot, component);
  }

  @NonNull
  public static ActivitySearchCrushBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_search_crush, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivitySearchCrushBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivitySearchCrushBinding>inflateInternal(inflater, R.layout.activity_search_crush, null, false, component);
  }

  public static ActivitySearchCrushBinding bind(@NonNull View view) {
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
  public static ActivitySearchCrushBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivitySearchCrushBinding)bind(component, view, R.layout.activity_search_crush);
  }
}