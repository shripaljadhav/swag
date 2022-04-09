// Generated by data binding compiler. Do not edit!
package com.app.swagliv.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.app.swagliv.R;
import com.app.swagliv.model.chat.pojo.chat.Message;
import com.app.swagliv.viewmodel.chats.ChatsViewModel;
import java.lang.Deprecated;
import java.lang.Integer;
import java.lang.Object;

public abstract class RowRightChatBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout chatLayout;

  @NonNull
  public final TextView tvChatMessage;

  @NonNull
  public final TextView tvChatTimestamp;

  @Bindable
  protected Integer mPosition;

  @Bindable
  protected Message mComment;

  @Bindable
  protected ChatsViewModel mViewModel;

  protected RowRightChatBinding(Object _bindingComponent, View _root, int _localFieldCount,
      LinearLayout chatLayout, TextView tvChatMessage, TextView tvChatTimestamp) {
    super(_bindingComponent, _root, _localFieldCount);
    this.chatLayout = chatLayout;
    this.tvChatMessage = tvChatMessage;
    this.tvChatTimestamp = tvChatTimestamp;
  }

  public abstract void setPosition(@Nullable Integer position);

  @Nullable
  public Integer getPosition() {
    return mPosition;
  }

  public abstract void setComment(@Nullable Message comment);

  @Nullable
  public Message getComment() {
    return mComment;
  }

  public abstract void setViewModel(@Nullable ChatsViewModel viewModel);

  @Nullable
  public ChatsViewModel getViewModel() {
    return mViewModel;
  }

  @NonNull
  public static RowRightChatBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.row_right_chat, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static RowRightChatBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<RowRightChatBinding>inflateInternal(inflater, R.layout.row_right_chat, root, attachToRoot, component);
  }

  @NonNull
  public static RowRightChatBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.row_right_chat, null, false, component)
   */
  @NonNull
  @Deprecated
  public static RowRightChatBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<RowRightChatBinding>inflateInternal(inflater, R.layout.row_right_chat, null, false, component);
  }

  public static RowRightChatBinding bind(@NonNull View view) {
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
  public static RowRightChatBinding bind(@NonNull View view, @Nullable Object component) {
    return (RowRightChatBinding)bind(component, view, R.layout.row_right_chat);
  }
}