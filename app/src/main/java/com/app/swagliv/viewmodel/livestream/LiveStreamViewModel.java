package com.app.swagliv.viewmodel.livestream;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.app.common.interfaces.APIResponseListener;
import com.app.common.utils.api_response_handler.APIResponse;
import com.app.swagliv.viewmodel.livestream.repository.LivestreamRepository;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class LiveStreamViewModel extends ViewModel implements APIResponseListener {
    public MutableLiveData<APIResponse> responseMutableLiveData;
    private LivestreamRepository livestreamRepository;

    public LiveStreamViewModel() {
        responseMutableLiveData = new MutableLiveData<>();
        livestreamRepository = new LivestreamRepository();
    }

    public void postCommentOnLiveStream(String streamId, String comment, Integer reqId) {
        responseMutableLiveData.setValue(APIResponse.loading(reqId));
        livestreamRepository.postCommentOnLiveStream(streamId, comment, this, reqId);
    }

    public void showInterestOnLiveStream(String streamId, Integer reqId) {
        responseMutableLiveData.setValue(APIResponse.loading(reqId));
        livestreamRepository.showInterestOnLiveStream(streamId, this, reqId);
    }

    public void startLiveStream(String role, Integer reqId) {
        responseMutableLiveData.setValue(APIResponse.loading(reqId));
        livestreamRepository.startLiveStream("publisher", this, reqId);
    }

    public void sendLiveStreamNotification(String channelName,  String role, String agoraToken, String liveStreamId, Integer requestID ){
        responseMutableLiveData.setValue(APIResponse.loading(requestID));
        livestreamRepository.sendLiveStreamNotification(channelName, role, agoraToken, liveStreamId, this, requestID);
    }

    public void getConnectionsList(Integer reqId) {
        responseMutableLiveData.setValue(APIResponse.loading(reqId));
        livestreamRepository.getConnectionsList(this, reqId);
    }

    public void getWalletBalance(Integer reqId) {
        responseMutableLiveData.setValue(APIResponse.loading(reqId));
        livestreamRepository.getWalletBalance(this, reqId);
    }

    public void addHost(JsonArray hosts , String liveStreamId , int  reqId) {
        responseMutableLiveData.postValue(APIResponse.loading(reqId));
        livestreamRepository.addHost(hosts,liveStreamId,this, reqId);
    }

    public void shareCoinsToHost(String coins, String liveStreamId, String hostId, int reqId) {

        responseMutableLiveData.postValue(APIResponse.loading(reqId));
        livestreamRepository.shareCoinsToHost(coins,liveStreamId,hostId,this, reqId);

    }

    public void sendPushNotificationToHosts(String channelName, String token, String liveStreamId, int role,boolean isforcoHost, int reqId) {

        responseMutableLiveData.postValue(APIResponse.loading(reqId));
        livestreamRepository.sendPushNotificationToHosts(channelName,token,liveStreamId,role,isforcoHost,this, reqId);

    }

    public void getAllLiveStreamCommentsResp(String url, Integer reqId) {
        responseMutableLiveData.postValue(APIResponse.loading(reqId));
        livestreamRepository.getAllLiveStreamComments(url, this, reqId);
    }

    public void getListOfActiveViewers(String stremaId, Integer reqId) {
        responseMutableLiveData.setValue(APIResponse.loading(reqId));
        livestreamRepository.getListOfActiveViewers(stremaId, this, reqId);
    }

    public void getHostList(String streamId,  Integer reqId) {
        responseMutableLiveData.postValue(APIResponse.loading(reqId));
        livestreamRepository.getHostList(streamId,  this, reqId);
    }

    @Override
    public void onSuccess(Object callResponse, Integer requestID) {
        responseMutableLiveData.setValue(APIResponse.success(callResponse, requestID));
    }

    @Override
    public void onFailure(Throwable error, Integer requestID) {
        responseMutableLiveData.setValue(APIResponse.error(error, requestID));
    }


}
