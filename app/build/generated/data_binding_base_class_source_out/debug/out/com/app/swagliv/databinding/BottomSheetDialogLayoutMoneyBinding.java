// Generated by view binder compiler. Do not edit!
package com.app.swagliv.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.app.swagliv.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class BottomSheetDialogLayoutMoneyBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView WalletBalance;

  @NonNull
  public final TextView WalletBalanceValue;

  @NonNull
  public final AppCompatButton btAddMoney;

  @NonNull
  public final AppCompatButton btSend;

  @NonNull
  public final EditText etAmount;

  @NonNull
  public final RecyclerView recAmountLst;

  @NonNull
  public final TextView txtEnterAmount;

  @NonNull
  public final View viewBottomLine;

  @NonNull
  public final View viewTopLine;

  private BottomSheetDialogLayoutMoneyBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextView WalletBalance, @NonNull TextView WalletBalanceValue,
      @NonNull AppCompatButton btAddMoney, @NonNull AppCompatButton btSend,
      @NonNull EditText etAmount, @NonNull RecyclerView recAmountLst,
      @NonNull TextView txtEnterAmount, @NonNull View viewBottomLine, @NonNull View viewTopLine) {
    this.rootView = rootView;
    this.WalletBalance = WalletBalance;
    this.WalletBalanceValue = WalletBalanceValue;
    this.btAddMoney = btAddMoney;
    this.btSend = btSend;
    this.etAmount = etAmount;
    this.recAmountLst = recAmountLst;
    this.txtEnterAmount = txtEnterAmount;
    this.viewBottomLine = viewBottomLine;
    this.viewTopLine = viewTopLine;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static BottomSheetDialogLayoutMoneyBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static BottomSheetDialogLayoutMoneyBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.bottom_sheet_dialog_layout_money, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static BottomSheetDialogLayoutMoneyBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.Wallet_Balance;
      TextView WalletBalance = ViewBindings.findChildViewById(rootView, id);
      if (WalletBalance == null) {
        break missingId;
      }

      id = R.id.Wallet_Balance_value;
      TextView WalletBalanceValue = ViewBindings.findChildViewById(rootView, id);
      if (WalletBalanceValue == null) {
        break missingId;
      }

      id = R.id.bt_add_money;
      AppCompatButton btAddMoney = ViewBindings.findChildViewById(rootView, id);
      if (btAddMoney == null) {
        break missingId;
      }

      id = R.id.bt_send;
      AppCompatButton btSend = ViewBindings.findChildViewById(rootView, id);
      if (btSend == null) {
        break missingId;
      }

      id = R.id.et_amount;
      EditText etAmount = ViewBindings.findChildViewById(rootView, id);
      if (etAmount == null) {
        break missingId;
      }

      id = R.id.rec_amount_lst;
      RecyclerView recAmountLst = ViewBindings.findChildViewById(rootView, id);
      if (recAmountLst == null) {
        break missingId;
      }

      id = R.id.txt_enter_amount;
      TextView txtEnterAmount = ViewBindings.findChildViewById(rootView, id);
      if (txtEnterAmount == null) {
        break missingId;
      }

      id = R.id.view_bottom_line;
      View viewBottomLine = ViewBindings.findChildViewById(rootView, id);
      if (viewBottomLine == null) {
        break missingId;
      }

      id = R.id.view_top_line;
      View viewTopLine = ViewBindings.findChildViewById(rootView, id);
      if (viewTopLine == null) {
        break missingId;
      }

      return new BottomSheetDialogLayoutMoneyBinding((ConstraintLayout) rootView, WalletBalance,
          WalletBalanceValue, btAddMoney, btSend, etAmount, recAmountLst, txtEnterAmount,
          viewBottomLine, viewTopLine);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
