// Generated by data binding compiler. Do not edit!
package com.app.swagliv.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.app.swagliv.R;
import com.app.swagliv.model.login.pojo.User;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ItemLikePictureBinding extends ViewDataBinding {
  @NonNull
  public final ImageView userLikeProfile;

  @Bindable
  protected User mUser;

  protected ItemLikePictureBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView userLikeProfile) {
    super(_bindingComponent, _root, _localFieldCount);
    this.userLikeProfile = userLikeProfile;
  }

  public abstract void setUser(@Nullable User user);

  @Nullable
  public User getUser() {
    return mUser;
  }

  @NonNull
  public static ItemLikePictureBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_like_picture, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ItemLikePictureBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ItemLikePictureBinding>inflateInternal(inflater, R.layout.item_like_picture, root, attachToRoot, component);
  }

  @NonNull
  public static ItemLikePictureBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_like_picture, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ItemLikePictureBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ItemLikePictureBinding>inflateInternal(inflater, R.layout.item_like_picture, null, false, component);
  }

  public static ItemLikePictureBinding bind(@NonNull View view) {
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
  public static ItemLikePictureBinding bind(@NonNull View view, @Nullable Object component) {
    return (ItemLikePictureBinding)bind(component, view, R.layout.item_like_picture);
  }
}