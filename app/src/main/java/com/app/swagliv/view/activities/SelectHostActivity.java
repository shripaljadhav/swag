package com.app.swagliv.view.activities;

import static com.app.common.constant.AppCommonConstants.API_REQUEST.REQUEST_ID_1021;
import static com.app.common.constant.AppCommonConstants.API_REQUEST.REQUEST_ID_1024;
import static com.app.common.constant.AppCommonConstants.API_REQUEST.REQUEST_ID_1025;
import static com.app.common.constant.AppCommonConstants.API_REQUEST.REQUEST_ID_1031;
import static com.app.common.network.RetrofitClient.BASE_URL;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.app.common.constant.AppCommonConstants;
import com.app.common.interfaces.APIResponseHandler;
import com.app.common.preference.AppPreferencesManager;
import com.app.common.utils.Utility;
import com.app.common.utils.api_response_handler.APIResponse;
import com.app.swagliv.R;
import com.app.swagliv.constant.AppConstant;
import com.app.swagliv.databinding.ActivitySearchGifBinding;
import com.app.swagliv.databinding.ActivitySelectHostBinding;
import com.app.swagliv.model.livestream.pojo.AllLiveStreamCommentsResp;
import com.app.swagliv.model.livestream.pojo.ConnectionsListResp;
import com.app.swagliv.model.livestream.pojo.GetListOfActiveViewers;
import com.app.swagliv.shripal.GetHostList;
import com.app.swagliv.view.adaptor.ChatCommentsAdapter;
import com.app.swagliv.view.adaptor.ManageConnectionAdapter;
import com.app.swagliv.view.adaptor.SearchGIFAdapter;
import com.app.swagliv.view.adaptor.SelectHostAdapter;
import com.app.swagliv.view.fragment.BottomSheetDialog;
import com.app.swagliv.viewmodel.livestream.LiveStreamViewModel;

import java.util.ArrayList;

public class SelectHostActivity extends AppCompatActivity implements APIResponseHandler {

    ActivitySelectHostBinding selectHostBinding;
    SelectHostAdapter adapter;
    ArrayList<GetHostList.Datum> hostsList = new ArrayList<>();
    LiveStreamViewModel liveStreamViewModel;
    String liveStreamId ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        selectHostBinding = ActivitySelectHostBinding.inflate(getLayoutInflater());
        setContentView(selectHostBinding.getRoot());
        liveStreamViewModel = new ViewModelProvider(this).get(LiveStreamViewModel.class);
        liveStreamViewModel.responseMutableLiveData.observe(this, new Observer<APIResponse>() {
            @Override
            public void onChanged(APIResponse apiResponse) {
                onAPIResponseHandler(apiResponse);
            }
        });

        selectHostBinding.commonHeader.headerTitle.setText(R.string.select_your_host);

        liveStreamId = getIntent().getStringExtra("liveStreamId");

        liveStreamViewModel.getHostList(liveStreamId
                , REQUEST_ID_1031);

        selectHostBinding.commonHeader.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });






        selectHostBinding.btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();
                bundle.putString("liveStreamId", liveStreamId );
                bundle.putString("hostId", hostsList.get(0).getId() );
                BottomSheetDialog fragInfo = new BottomSheetDialog();
                fragInfo.setArguments(bundle);
                fragInfo.show(getSupportFragmentManager(),
                        "ModalBottomSheet");
            }
        });


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

                    case AppCommonConstants.API_REQUEST.REQUEST_ID_1031:

                        Log.d("SelectHostActivityResponse" , apiResponse.data.toString());

                        GetHostList connectionsListResp = (GetHostList) apiResponse.data;
                        selectHostBinding.hostRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
                        hostsList = (ArrayList<GetHostList.Datum>) connectionsListResp.getData();
                        adapter = new SelectHostAdapter(hostsList);
                        selectHostBinding.hostRecycler.setAdapter(adapter);



                        break;

                }
                break;
            case ERROR:
                //-------
                Utility.showToast(this, getString(R.string.api_failure_error_msg));
                break;
            default:
                break;
        }

    }
}