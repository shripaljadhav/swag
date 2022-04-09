package com.app.swagliv.model.livestream;

import com.app.swagliv.constant.AppConstant;
import com.app.swagliv.model.livestream.pojo.AllLiveStreamCommentsResp;
import com.app.swagliv.model.livestream.pojo.ConnectionsListResp;
import com.app.swagliv.model.livestream.pojo.GetListOfActiveViewers;
import com.app.swagliv.model.livestream.pojo.SendLiveStreamNotification;
import com.app.swagliv.model.livestream.pojo.StartLiveStreamResp;
import com.app.swagliv.model.store.WalletBalanceResponse;
import com.app.swagliv.shripal.GetHostList;
import com.google.android.gms.wallet.Wallet;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface LiveStreamService {

    @POST(AppConstant.API.PostCommentOnLiveStream)
    Call<Object> postCommentOnLiveStream(
            @Body JsonObject jsonObject
    );

    @POST(AppConstant.API.StartLiveStream)
    Call<StartLiveStreamResp> startLiveStream(
            @Body JsonObject jsonObject
    );

    @POST(AppConstant.API.SendLiveStreamNotification)
    Call<SendLiveStreamNotification> sendLiveStreamNotification(
            @Body JsonObject jsonObject
    );

    @POST(AppConstant.API.shareCoinsToHost)
    Call<Object> shareCoinsToHost(
            @Body JsonObject jsonObject
    );



    @POST(AppConstant.API.showInterestOnLiveStream)
    Call<Object> showInterestOnLiveStream(
            @Body JsonObject jsonObject
    );

    @POST(AppConstant.API.CreateConnection)
    Call<Object> createConnection(
            @Body JsonObject jsonObject
    );

    @POST(AppConstant.API.ActionOnConnectionRequest)
    Call<Object> actionOnConnectionRequest(
            @Body JsonObject jsonObject
    );

    @GET(AppConstant.API.GetConnectionsList)
    Call<ConnectionsListResp> getConnectionsList();

    @POST(AppConstant.API.AddHost)
    Call<Object> addHost(
            @Body JsonObject jsonObject
    );

    @POST(AppConstant.API.sendPushNotificationToHosts)
    Call<Object> sendPushNotificationToHosts(
            @Body JsonObject jsonObject
    );

    @GET
    Call<AllLiveStreamCommentsResp> getAllLiveStreamComments(@Url String url);

    @GET(AppConstant.API.GetWalletBalance)
    Call<WalletBalanceResponse> getWalletBalance();

    @POST(AppConstant.API.GetListOfActiveViewers)
    Call<GetListOfActiveViewers> getListOfActiveViewers(
            @Body JsonObject jsonObject
    );

    @POST(AppConstant.API.GetHostList)
    Call<GetHostList> getHostList(
            @Body JsonObject jsonObject
    );
}
