// Generated by view binder compiler. Do not edit!
package com.app.swagliv.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.app.swagliv.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivitySelectHostBinding implements ViewBinding {
  @NonNull
  private final LinearLayoutCompat rootView;

  @NonNull
  public final Button btSend;

  @NonNull
  public final CommonHeaderBinding commonHeader;

  @NonNull
  public final RecyclerView hostRecycler;

  private ActivitySelectHostBinding(@NonNull LinearLayoutCompat rootView, @NonNull Button btSend,
      @NonNull CommonHeaderBinding commonHeader, @NonNull RecyclerView hostRecycler) {
    this.rootView = rootView;
    this.btSend = btSend;
    this.commonHeader = commonHeader;
    this.hostRecycler = hostRecycler;
  }

  @Override
  @NonNull
  public LinearLayoutCompat getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivitySelectHostBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivitySelectHostBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_select_host, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivitySelectHostBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.bt_send;
      Button btSend = ViewBindings.findChildViewById(rootView, id);
      if (btSend == null) {
        break missingId;
      }

      id = R.id.common_header;
      View commonHeader = ViewBindings.findChildViewById(rootView, id);
      if (commonHeader == null) {
        break missingId;
      }
      CommonHeaderBinding binding_commonHeader = CommonHeaderBinding.bind(commonHeader);

      id = R.id.host_recycler;
      RecyclerView hostRecycler = ViewBindings.findChildViewById(rootView, id);
      if (hostRecycler == null) {
        break missingId;
      }

      return new ActivitySelectHostBinding((LinearLayoutCompat) rootView, btSend,
          binding_commonHeader, hostRecycler);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
