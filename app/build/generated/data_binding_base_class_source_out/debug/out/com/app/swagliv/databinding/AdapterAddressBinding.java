// Generated by data binding compiler. Do not edit!
package com.app.swagliv.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.app.swagliv.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class AdapterAddressBinding extends ViewDataBinding {
  @NonNull
  public final RadioButton radioAddress;

  @NonNull
  public final TextView textviewAddress;

  @NonNull
  public final TextView textviewEdit;

  @NonNull
  public final TextView textviewPhoneNumber;

  @NonNull
  public final TextView textviewUsername;

  protected AdapterAddressBinding(Object _bindingComponent, View _root, int _localFieldCount,
      RadioButton radioAddress, TextView textviewAddress, TextView textviewEdit,
      TextView textviewPhoneNumber, TextView textviewUsername) {
    super(_bindingComponent, _root, _localFieldCount);
    this.radioAddress = radioAddress;
    this.textviewAddress = textviewAddress;
    this.textviewEdit = textviewEdit;
    this.textviewPhoneNumber = textviewPhoneNumber;
    this.textviewUsername = textviewUsername;
  }

  @NonNull
  public static AdapterAddressBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.adapter_address, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static AdapterAddressBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<AdapterAddressBinding>inflateInternal(inflater, R.layout.adapter_address, root, attachToRoot, component);
  }

  @NonNull
  public static AdapterAddressBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.adapter_address, null, false, component)
   */
  @NonNull
  @Deprecated
  public static AdapterAddressBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<AdapterAddressBinding>inflateInternal(inflater, R.layout.adapter_address, null, false, component);
  }

  public static AdapterAddressBinding bind(@NonNull View view) {
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
  public static AdapterAddressBinding bind(@NonNull View view, @Nullable Object component) {
    return (AdapterAddressBinding)bind(component, view, R.layout.adapter_address);
  }
}
