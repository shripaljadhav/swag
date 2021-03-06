// Generated by data binding compiler. Do not edit!
package com.app.swagliv.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.app.swagliv.R;
import com.google.android.material.slider.RangeSlider;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityTopSheetAvtivityBinding extends ViewDataBinding {
  @NonNull
  public final TextView femaleUnselectedText;

  @NonNull
  public final ImageView filterBackBtn;

  @NonNull
  public final ImageView filterCheckBtn;

  @NonNull
  public final TextView maleUnselected;

  @NonNull
  public final TextView shemaleUnselectedText;

  @NonNull
  public final RangeSlider sliderRange;

  @NonNull
  public final ImageView spinnerTxt;

  protected ActivityTopSheetAvtivityBinding(Object _bindingComponent, View _root,
      int _localFieldCount, TextView femaleUnselectedText, ImageView filterBackBtn,
      ImageView filterCheckBtn, TextView maleUnselected, TextView shemaleUnselectedText,
      RangeSlider sliderRange, ImageView spinnerTxt) {
    super(_bindingComponent, _root, _localFieldCount);
    this.femaleUnselectedText = femaleUnselectedText;
    this.filterBackBtn = filterBackBtn;
    this.filterCheckBtn = filterCheckBtn;
    this.maleUnselected = maleUnselected;
    this.shemaleUnselectedText = shemaleUnselectedText;
    this.sliderRange = sliderRange;
    this.spinnerTxt = spinnerTxt;
  }

  @NonNull
  public static ActivityTopSheetAvtivityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_top_sheet_avtivity, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityTopSheetAvtivityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityTopSheetAvtivityBinding>inflateInternal(inflater, R.layout.activity_top_sheet_avtivity, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityTopSheetAvtivityBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_top_sheet_avtivity, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityTopSheetAvtivityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityTopSheetAvtivityBinding>inflateInternal(inflater, R.layout.activity_top_sheet_avtivity, null, false, component);
  }

  public static ActivityTopSheetAvtivityBinding bind(@NonNull View view) {
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
  public static ActivityTopSheetAvtivityBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (ActivityTopSheetAvtivityBinding)bind(component, view, R.layout.activity_top_sheet_avtivity);
  }
}
