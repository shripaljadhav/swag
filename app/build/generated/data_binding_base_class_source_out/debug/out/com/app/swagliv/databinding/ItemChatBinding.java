// Generated by data binding compiler. Do not edit!
package com.app.swagliv.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.app.swagliv.R;
import com.app.swagliv.model.chat.pojo.chatlist.UserChats;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ItemChatBinding extends ViewDataBinding {
  @NonNull
  public final ImageView chatCall;

  @NonNull
  public final ImageView chatVideo;

  @NonNull
  public final CircleImageView imgProfile;

  @NonNull
  public final TextView messageTxt;

  @NonNull
  public final TextView nameTxt;

  @Bindable
  protected UserChats mChats;

  protected ItemChatBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView chatCall, ImageView chatVideo, CircleImageView imgProfile, TextView messageTxt,
      TextView nameTxt) {
    super(_bindingComponent, _root, _localFieldCount);
    this.chatCall = chatCall;
    this.chatVideo = chatVideo;
    this.imgProfile = imgProfile;
    this.messageTxt = messageTxt;
    this.nameTxt = nameTxt;
  }

  public abstract void setChats(@Nullable UserChats chats);

  @Nullable
  public UserChats getChats() {
    return mChats;
  }

  @NonNull
  public static ItemChatBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_chat, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ItemChatBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ItemChatBinding>inflateInternal(inflater, R.layout.item_chat, root, attachToRoot, component);
  }

  @NonNull
  public static ItemChatBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_chat, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ItemChatBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ItemChatBinding>inflateInternal(inflater, R.layout.item_chat, null, false, component);
  }

  public static ItemChatBinding bind(@NonNull View view) {
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
  public static ItemChatBinding bind(@NonNull View view, @Nullable Object component) {
    return (ItemChatBinding)bind(component, view, R.layout.item_chat);
  }
}
