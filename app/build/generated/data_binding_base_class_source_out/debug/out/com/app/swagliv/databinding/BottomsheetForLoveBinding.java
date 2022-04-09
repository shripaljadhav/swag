// Generated by view binder compiler. Do not edit!
package com.app.swagliv.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.app.swagliv.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class BottomsheetForLoveBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final LinearLayout btnAddToCart;

  @NonNull
  public final View divider;

  @NonNull
  public final AppCompatImageView imageview;

  @NonNull
  public final ConstraintLayout layout;

  @NonNull
  public final LinearLayout passionBtnContinue;

  @NonNull
  public final TextView textviewCoins;

  @NonNull
  public final TextView textviewProductName;

  @NonNull
  public final TextView textviewTitle;

  private BottomsheetForLoveBinding(@NonNull ConstraintLayout rootView,
      @NonNull LinearLayout btnAddToCart, @NonNull View divider,
      @NonNull AppCompatImageView imageview, @NonNull ConstraintLayout layout,
      @NonNull LinearLayout passionBtnContinue, @NonNull TextView textviewCoins,
      @NonNull TextView textviewProductName, @NonNull TextView textviewTitle) {
    this.rootView = rootView;
    this.btnAddToCart = btnAddToCart;
    this.divider = divider;
    this.imageview = imageview;
    this.layout = layout;
    this.passionBtnContinue = passionBtnContinue;
    this.textviewCoins = textviewCoins;
    this.textviewProductName = textviewProductName;
    this.textviewTitle = textviewTitle;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static BottomsheetForLoveBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static BottomsheetForLoveBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.bottomsheet_for_love_, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static BottomsheetForLoveBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_add_to_cart;
      LinearLayout btnAddToCart = ViewBindings.findChildViewById(rootView, id);
      if (btnAddToCart == null) {
        break missingId;
      }

      id = R.id.divider;
      View divider = ViewBindings.findChildViewById(rootView, id);
      if (divider == null) {
        break missingId;
      }

      id = R.id.imageview;
      AppCompatImageView imageview = ViewBindings.findChildViewById(rootView, id);
      if (imageview == null) {
        break missingId;
      }

      id = R.id.layout;
      ConstraintLayout layout = ViewBindings.findChildViewById(rootView, id);
      if (layout == null) {
        break missingId;
      }

      id = R.id.passion_btn_continue;
      LinearLayout passionBtnContinue = ViewBindings.findChildViewById(rootView, id);
      if (passionBtnContinue == null) {
        break missingId;
      }

      id = R.id.textview_coins;
      TextView textviewCoins = ViewBindings.findChildViewById(rootView, id);
      if (textviewCoins == null) {
        break missingId;
      }

      id = R.id.textview_product_name;
      TextView textviewProductName = ViewBindings.findChildViewById(rootView, id);
      if (textviewProductName == null) {
        break missingId;
      }

      id = R.id.textview_title;
      TextView textviewTitle = ViewBindings.findChildViewById(rootView, id);
      if (textviewTitle == null) {
        break missingId;
      }

      return new BottomsheetForLoveBinding((ConstraintLayout) rootView, btnAddToCart, divider,
          imageview, layout, passionBtnContinue, textviewCoins, textviewProductName, textviewTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}