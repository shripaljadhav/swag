package com.app.swagliv.view.fragment;

import static android.content.ContentValues.TAG;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.common.constant.AppCommonConstants;
import com.app.common.interfaces.APIResponseHandler;
import com.app.common.utils.Utility;
import com.app.common.utils.api_response_handler.APIResponse;
import com.app.swagliv.R;
import com.app.swagliv.model.livestream.pojo.ConnectionsListResp;
import com.app.swagliv.model.store.WalletBalanceResponse;
import com.app.swagliv.shripal.GetHostList;
import com.app.swagliv.view.ClickListiner;
import com.app.swagliv.view.adaptor.AmountListAdapter;
import com.app.swagliv.view.adaptor.SelectHostAdapter;
import com.app.swagliv.viewmodel.livestream.LiveStreamViewModel;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BottomSheetDialog extends BottomSheetDialogFragment implements ClickListiner , APIResponseHandler , PaymentResultListener {

    RecyclerView rec_amount_lst;

    TextView Wallet_Balance_value ;

    EditText et_amount;

    AppCompatButton bt_send , bt_add_money;

    LiveStreamViewModel liveStreamViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bottom_sheet_dialog_layout_money,
                container, false);
        Wallet_Balance_value = v.findViewById(R.id.Wallet_Balance_value);
        rec_amount_lst = v.findViewById(R.id.rec_amount_lst);
        et_amount = v.findViewById(R.id.et_amount);
        bt_add_money = v.findViewById(R.id.bt_add_money);
        bt_send = v.findViewById(R.id.bt_send);

        Checkout.preload(getActivity());


        String myValue = this.getArguments().getString("liveStreamId");
        String hostId = this.getArguments().getString("hostId");




        liveStreamViewModel = new ViewModelProvider(this).get(LiveStreamViewModel.class);
        liveStreamViewModel.responseMutableLiveData.observe(this, new Observer<APIResponse>() {
            @Override
            public void onChanged(APIResponse apiResponse) {
                onAPIResponseHandler(apiResponse);
            }
        });

        bt_add_money.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Checkout checkout = new Checkout();

                checkout.setKeyID("rzp_test_ES8MZeTGTKziMD");

                checkout.setImage(R.mipmap.ic_launcher);

                /**
                 * Reference to current activity
                 */
                final Activity activity = getActivity();

                /**
                 * Pass your payment options to the Razorpay Checkout as a JSONObject
                 */
                try {
                    JSONObject options = new JSONObject();

                    options.put("name", "Merchant Name");
                    options.put("description", "Reference No. #123456");
                    options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
                    options.put("order_id", "order_DBJOWzybf0sJbb");//from response of step 3.
                    options.put("theme.color", "#3399cc");
                    options.put("currency", "INR");
                    options.put("amount", "50000");//pass amount in currency subunits
                    options.put("prefill.email", "gaurav.kumar@example.com");
                    options.put("prefill.contact", "9988776655");
                    JSONObject retryObj = new JSONObject();
                    retryObj.put("enabled", true);
                    retryObj.put("max_count", 4);
                    options.put("retry", retryObj);

                    checkout.open(activity, options);

                } catch (Exception e) {
                    Log.e(TAG, "Error in starting Razorpay Checkout", e);
                }



            }
        });



        bt_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               // Toast.makeText(getContext(), myValue+" - "+hostId+ " - "+et_amount.getText().toString(), Toast.LENGTH_SHORT).show();

                liveStreamViewModel.shareCoinsToHost(et_amount.getText().toString(),myValue,hostId,AppCommonConstants.API_REQUEST.REQUEST_ID_1033);


            }
        });





        liveStreamViewModel.getWalletBalance(AppCommonConstants.API_REQUEST.REQUEST_ID_1032);



        AmountListAdapter amountListAdapter = new AmountListAdapter(getData(), this::click);
        rec_amount_lst.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rec_amount_lst.setAdapter(amountListAdapter);




        return v;
    }

    private List<String> getData() {
        List<String> list = new ArrayList<>();

        for (int i = 1; i <= 100; i++)
            list.add(i * 100 + "");


        return list;
    }

    @Override
    public void click(String amount) {

        if (amount != null)
            et_amount.setText(amount);
    }

    @Override
    public void onAPIResponseHandler(APIResponse apiResponse) {
        switch (apiResponse.status) {

            case LOADING:
                //------
                break;
            case SUCCESS:
                switch (apiResponse.requestID) {
                    // ..

                    case AppCommonConstants.API_REQUEST.REQUEST_ID_1032:

                        WalletBalanceResponse connectionsListResp = (WalletBalanceResponse) apiResponse.data;

                        Wallet_Balance_value.setText(connectionsListResp.getData().getWalletBalance());

                        Log.d("WalletBalance" , apiResponse.data.toString());


                        break;

                    case AppCommonConstants.API_REQUEST.REQUEST_ID_1033:

                        Log.d("ShareCoinToHost" , apiResponse.data.toString());

                        final Dialog[] dialog = new Dialog[1];

                        dialog[0] = new Dialog(getActivity());
                        dialog[0].requestWindowFeature(Window.FEATURE_NO_TITLE);
                        dialog[0].setCancelable(false);
                        dialog[0].setContentView(R.layout.dialog_thanks);
                        dialog[0].getWindow().setBackgroundDrawableResource(android.R.color.transparent);

                        dialog[0].show();


                        dialog[0].dismiss();




                        break;

                }
                break;
            case ERROR:
                //-------
                Utility.showToast(getContext(), getString(R.string.api_failure_error_msg));
                break;
            default:
                break;
        }


    }

    @Override
    public void onPaymentSuccess(String s) {

        Toast.makeText(getActivity(), s.toString(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onPaymentError(int i, String s) {

        Toast.makeText(getActivity(), s.toString(), Toast.LENGTH_SHORT).show();


    }
}
