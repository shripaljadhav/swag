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
import com.app.swagliv.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityPortfolioBinding extends ViewDataBinding {
  @NonNull
  public final TextView addressText;

  @NonNull
  public final CommonHeaderBinding commonHeader;

  @NonNull
  public final TextView dateText;

  @NonNull
  public final CircleImageView imageIcon;

  @NonNull
  public final TextView nameText;

  @NonNull
  public final RecyclerView portfolioRecycler;

  protected ActivityPortfolioBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView addressText, CommonHeaderBinding commonHeader, TextView dateText,
      CircleImageView imageIcon, TextView nameText, RecyclerView portfolioRecycler) {
    super(_bindingComponent, _root, _localFieldCount);
    this.addressText = addressText;
    this.commonHeader = commonHeader;
    this.dateText = dateText;
    this.imageIcon = imageIcon;
    this.nameText = nameText;
    this.portfolioRecycler = portfolioRecycler;
  }

  @NonNull
  public static ActivityPortfolioBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_portfolio, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityPortfolioBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityPortfolioBinding>inflateInternal(inflater, R.layout.activity_portfolio, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityPortfolioBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_portfolio, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityPortfolioBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityPortfolioBinding>inflateInternal(inflater, R.layout.activity_portfolio, null, false, component);
  }

  public static ActivityPortfolioBinding bind(@NonNull View view) {
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
  public static ActivityPortfolioBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityPortfolioBinding)bind(component, view, R.layout.activity_portfolio);
  }
}