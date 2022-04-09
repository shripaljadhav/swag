package com.app.swagliv.viewmodel.livestream.repository;


import android.util.Log;

import com.app.common.interfaces.APIResponseListener;
import com.app.common.utils.Utility;
import com.app.swagliv.model.home.pojo.Passions;
import com.app.swagliv.model.livestream.LiveStreamService;
import com.app.swagliv.model.livestream.pojo.AllLiveStreamCommentsResp;
import com.app.swagliv.model.livestream.pojo.ConnectionsListResp;
import com.app.swagliv.model.livestream.pojo.GetListOfActiveViewers;
import com.app.swagliv.model.livestream.pojo.SendLiveStreamNotification;
import com.app.swagliv.model.livestream.pojo.StartLiveStreamResp;
import com.app.swagliv.model.store.WalletBalanceResponse;
import com.app.swagliv.network.ApplicationRetrofitServices;
import com.app.swagliv.shripal.AddHostmodel;
import com.app.swagliv.shripal.GetHostList;
import com.app.swagliv.viewmodel.livestream.LiveStreamViewModel;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LivestreamRepository {
    public void postCommentOnLiveStream(String liveStreamId, String comment, APIResponseListener apiResponseListener, Integer requestID) {
        LiveStreamService liveStreamService = ApplicationRetrofitServices.getInstance().getLiveStreamService();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("liveStreamId", liveStreamId);
        jsonObject.addProperty("comment", comment);
        Utility.printLogs("RequestJSON", jsonObject.toString());
        Call<Object> call = liveStreamService.postCommentOnLiveStream(jsonObject);
        call.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                Object loginResponse = response.body();
                if (response.isSuccessful() && loginResponse != null) {
                    //----------
                    apiResponseListener.onSuccess(loginResponse, requestID);
                } else {
                    apiResponseListener.onSuccess(Utility.getApiFailureErrorMsg(response.errorBody()), requestID);
                }
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                apiResponseListener.onFailure(new Exception(), requestID);
            }
        });

    }

    public void createConnection(String viewerId, APIResponseListener apiResponseListener, Integer requestID) {
        LiveStreamService liveStreamService = ApplicationRetrofitServices.getInstance().getLiveStreamService();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("viewerId", viewerId);
        Utility.printLogs("RequestJSON", jsonObject.toString());
        Call<Object> call = liveStreamService.createConnection(jsonObject);
        call.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                Object loginResponse = response.body();
                if (response.isSuccessful() && loginResponse != null) {
                    //----------
                    apiResponseListener.onSuccess(loginResponse, requestID);
                    //  apiResponseListener.onSuccess(loginResponse.getMessage(), requestID);
                } else {
                    apiResponseListener.onSuccess(Utility.getApiFailureErrorMsg(response.errorBody()), requestID);
                }
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                apiResponseListener.onFailure(new Exception(), requestID);
            }
        });

    }

    public void actionOnConnectionRequest(String connectionId, String connectionStatus, APIResponseListener apiResponseListener, Integer requestID) {
        LiveStreamService liveStreamService = ApplicationRetrofitServices.getInstance().getLiveStreamService();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("connectionId", connectionId);
        jsonObject.addProperty("connectionStatus", connectionStatus);//accepted
        Utility.printLogs("RequestJSON", jsonObject.toString());
        Call<Object> call = liveStreamService.actionOnConnectionRequest(jsonObject);
        call.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                Object loginResponse = response.body();
                if (response.isSuccessful() && loginResponse != null) {
                    //----------
                    apiResponseListener.onSuccess(loginResponse, requestID);
                    //  apiResponseListener.onSuccess(loginResponse.getMessage(), requestID);
                } else {
                    apiResponseListener.onSuccess(Utility.getApiFailureErrorMsg(response.errorBody()), requestID);
                }
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                apiResponseListener.onFailure(new Exception(), requestID);
            }
        });

    }

    public void getConnectionsList(APIResponseListener apiResponseListener, Integer requestID) {
        LiveStreamService liveStreamService = ApplicationRetrofitServices.getInstance().getLiveStreamService();

        Call<ConnectionsListResp> call = liveStreamService.getConnectionsList();
        call.enqueue(new Callback<ConnectionsListResp>() {
            @Override
            public void onResponse(Call<ConnectionsListResp> call, Response<ConnectionsListResp> response) {
                ConnectionsListResp loginResponse = response.body();
                if (response.isSuccessful() && loginResponse != null) {
                    //----------
                    apiResponseListener.onSuccess(loginResponse, requestID);
                } else {
                    apiResponseListener.onSuccess(Utility.getApiFailureErrorMsg(response.errorBody()), requestID);
                }
            }

            @Override
            public void onFailure(Call<ConnectionsListResp> call, Throwable t) {
                apiResponseListener.onFailure(new Exception(), requestID);
            }
        });

    }

    public void getWalletBalance(APIResponseListener apiResponseListener, Integer requestID) {
        LiveStreamService liveStreamService = ApplicationRetrofitServices.getInstance().getLiveStreamService();

        Call<WalletBalanceResponse> call = liveStreamService.getWalletBalance();
        call.enqueue(new Callback<WalletBalanceResponse>() {
            @Override
            public void onResponse(Call<WalletBalanceResponse> call, Response<WalletBalanceResponse> response) {
                WalletBalanceResponse loginResponse = response.body();
                if (response.isSuccessful() && loginResponse != null) {
                    //----------
                    apiResponseListener.onSuccess(loginResponse, requestID);
                } else {
                    apiResponseListener.onSuccess(Utility.getApiFailureErrorMsg(response.errorBody()), requestID);
                }
            }

            @Override
            public void onFailure(Call<WalletBalanceResponse> call, Throwable t) {
                apiResponseListener.onFailure(new Exception(), requestID);
            }
        });

    }


    public void addHost(JsonArray hosts , String liveStreamId,APIResponseListener apiResponseListener, Integer requestID) {
        LiveStreamService liveStreamService = ApplicationRetrofitServices.getInstance().getLiveStreamService();
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("hosts", hosts);
        jsonObject.addProperty("liveStreamId", liveStreamId);//accepted
        Utility.printLogs("RequestJSON", jsonObject.toString());
        Call<Object> call = liveStreamService.addHost(jsonObject);
        call.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                Object loginResponse = response.body();
                if (response.isSuccessful() && loginResponse != null) {
                    //----------
                    apiResponseListener.onSuccess(loginResponse, requestID);
                    //  apiResponseListener.onSuccess(loginResponse.getMessage(), requestID);
                } else {
                    apiResponseListener.onSuccess(Utility.getApiFailureErrorMsg(response.errorBody()), requestID);
                }
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                apiResponseListener.onFailure(new Exception(), requestID);
            }
        });

    }


    public void sendPushNotificationToHosts(String channelName, String token, String liveStreamId, int role, boolean isforcoHost,APIResponseListener apiResponseListener, int requestID) {

        LiveStreamService liveStreamService = ApplicationRetrofitServices.getInstance().getLiveStreamService();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("channelName", channelName);//accepted
        jsonObject.addProperty("publisherToken", token);
        jsonObject.addProperty("liveStreamId", liveStreamId);
        jsonObject.addProperty("role", role);
        jsonObject.addProperty("isforcoHost", true);
        Utility.printLogs("sendPushNotificationToHosts", jsonObject.toString());
        Call<Object> call = liveStreamService.sendPushNotificationToHosts(jsonObject);
        call.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                Object loginResponse = response.body();
                if (response.isSuccessful() && loginResponse != null) {
                    //----------
                    apiResponseListener.onSuccess(loginResponse, requestID);
                    //  apiResponseListener.onSuccess(loginResponse.getMessage(), requestID);
                } else {
                    apiResponseListener.onSuccess(Utility.getApiFailureErrorMsg(response.errorBody()), requestID);
                }
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                apiResponseListener.onFailure(new Exception(), requestID);
            }
        });


    }


    public void getAllLiveStreamComments(String url, APIResponseListener apiResponseListener, Integer requestID) {
        LiveStreamService liveStreamService = ApplicationRetrofitServices.getInstance().getLiveStreamService();

        Call<AllLiveStreamCommentsResp> call = liveStreamService.getAllLiveStreamComments(url);
        call.enqueue(new Callback<AllLiveStreamCommentsResp>() {
            @Override
            public void onResponse(Call<AllLiveStreamCommentsResp> call, Response<AllLiveStreamCommentsResp> response) {
                AllLiveStreamCommentsResp loginResponse = response.body();
                if (response.isSuccessful() && loginResponse != null) {
                    //----------
                    apiResponseListener.onSuccess(loginResponse, requestID);
                } else {
                    apiResponseListener.onSuccess(Utility.getApiFailureErrorMsg(response.errorBody()), requestID);
                }
            }

            @Override
            public void onFailure(Call<AllLiveStreamCommentsResp> call, Throwable t) {
                apiResponseListener.onFailure(new Exception(), requestID);
            }
        });

    }

    public void getListOfActiveViewers(String liveStreamId, APIResponseListener apiResponseListener, Integer requestID) {
        LiveStreamService liveStreamService = ApplicationRetrofitServices.getInstance().getLiveStreamService();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("liveStreamId", liveStreamId);
        Call<GetListOfActiveViewers> call = liveStreamService.getListOfActiveViewers(jsonObject);
        call.enqueue(new Callback<GetListOfActiveViewers>() {
            @Override
            public void onResponse(Call<GetListOfActiveViewers> call, Response<GetListOfActiveViewers> response) {
                GetListOfActiveViewers loginResponse = response.body();
                if (response.isSuccessful() && loginResponse != null) {
                    //----------
                    apiResponseListener.onSuccess(loginResponse, requestID);
                } else {
                    apiResponseListener.onSuccess(Utility.getApiFailureErrorMsg(response.errorBody()), requestID);
                }
            }

            @Override
            public void onFailure(Call<GetListOfActiveViewers> call, Throwable t) {
                apiResponseListener.onFailure(new Exception(), requestID);
            }
        });

    }

    public void startLiveStream(String role, APIResponseListener apiResponseListener, Integer requestID) {
        LiveStreamService liveStreamService = ApplicationRetrofitServices.getInstance().getLiveStreamService();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("role", role);
        Utility.printLogs("RequestJSON", jsonObject.toString());
        Call<StartLiveStreamResp> call = liveStreamService.startLiveStream(jsonObject);
        call.enqueue(new Callback<StartLiveStreamResp>() {
            @Override
            public void onResponse(Call<StartLiveStreamResp> call, Response<StartLiveStreamResp> response) {
                StartLiveStreamResp loginResponse = response.body();
                if (response.isSuccessful() && loginResponse != null) {

                    Log.e("TAG", "shriresponse: "+new Gson().toJson(response.body()) );


                    apiResponseListener.onSuccess(loginResponse, requestID);

                } else {

                    apiResponseListener.onSuccess(Utility.getApiFailureErrorMsg(response.errorBody()), requestID);

                }
            }

            @Override
            public void onFailure(Call<StartLiveStreamResp> call, Throwable t) {
                apiResponseListener.onFailure(new Exception(), requestID);
            }
        });
    }


    public void sendLiveStreamNotification(String channelName,  String role, String agoraToken, String liveStreamId,  APIResponseListener apiResponseListener, Integer requestID ) {

        LiveStreamService liveStreamService = ApplicationRetrofitServices.getInstance().getLiveStreamService();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("channelName", channelName);
        jsonObject.addProperty("role", role);
        jsonObject.addProperty("agoraToken", agoraToken);
        jsonObject.addProperty("liveStreamId", liveStreamId);

        Utility.printLogs("RequestJSON", jsonObject.toString());
        Call<SendLiveStreamNotification> call = liveStreamService.sendLiveStreamNotification(jsonObject);
        call.enqueue(new Callback<SendLiveStreamNotification>() {
            @Override
            public void onResponse(Call<SendLiveStreamNotification> call, Response<SendLiveStreamNotification> response) {
                SendLiveStreamNotification loginResponse = response.body();
                if (response.isSuccessful() && loginResponse != null) {

                    Log.e("TAG", "shriresponse: "+new Gson().toJson(response.body()) );


                    apiResponseListener.onSuccess(loginResponse, requestID);

                } else {

                    apiResponseListener.onSuccess(Utility.getApiFailureErrorMsg(response.errorBody()), requestID);

                }
            }


            @Override
            public void onFailure(Call<SendLiveStreamNotification> call, Throwable t) {
                apiResponseListener.onFailure(new Exception(), requestID);
            }
        });

    }

    public void showInterestOnLiveStream(String resourceURI, APIResponseListener apiResponseListener, Integer requestID) {
        LiveStreamService liveStreamService = ApplicationRetrofitServices.getInstance().getLiveStreamService();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("resourceURI", resourceURI);
        Utility.printLogs("RequestJSON", jsonObject.toString());
        Call<Object> call = liveStreamService.showInterestOnLiveStream(jsonObject);
        call.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                Object loginResponse = response.body();
                if (response.isSuccessful() && loginResponse != null) {
                    //----------
                    apiResponseListener.onSuccess(loginResponse, requestID);
                } else {
                    apiResponseListener.onSuccess(Utility.getApiFailureErrorMsg(response.errorBody()), requestID);
                }
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                apiResponseListener.onFailure(new Exception(), requestID);
            }
        });
    }


    public void getHostList(String liveStreamId, APIResponseListener apiResponseListener, Integer requestID) {
        LiveStreamService liveStreamService = ApplicationRetrofitServices.getInstance().getLiveStreamService();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("liveStreamId", liveStreamId);
        Utility.printLogs("RequestJSONGetHostList", jsonObject.toString());

        Call<GetHostList> call = liveStreamService.getHostList(jsonObject);
        call.enqueue(new Callback<GetHostList>() {
            @Override
            public void onResponse(Call<GetHostList> call, Response<GetHostList> response) {
                GetHostList loginResponse = response.body();
                if (response.isSuccessful() && loginResponse != null) {
                    //----------
                    apiResponseListener.onSuccess(loginResponse, requestID);
                } else {
                    apiResponseListener.onSuccess(Utility.getApiFailureErrorMsg(response.errorBody()), requestID);
                }
            }

            @Override
            public void onFailure(Call<GetHostList> call, Throwable t) {
                apiResponseListener.onFailure(new Exception(), requestID);
            }
        });

    }

    public void shareCoinsToHost(String coins,  String liveStreamId, String hostId,  APIResponseListener apiResponseListener, Integer requestID ) {

        LiveStreamService liveStreamService = ApplicationRetrofitServices.getInstance().getLiveStreamService();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("coins", coins);
        jsonObject.addProperty("liveStreamId", liveStreamId);
        jsonObject.addProperty("hostId", hostId);

        Utility.printLogs("RequestJSON", jsonObject.toString());
        Call<Object> call = liveStreamService.shareCoinsToHost(jsonObject);
        call.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                Object loginResponse = response.body();
                if (response.isSuccessful() && loginResponse != null) {

                    Log.e("TAG", "shriresponse: "+new Gson().toJson(response.body()) );


                    apiResponseListener.onSuccess(loginResponse, requestID);

                } else {

                    apiResponseListener.onSuccess(Utility.getApiFailureErrorMsg(response.errorBody()), requestID);

                }
            }


            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                apiResponseListener.onFailure(new Exception(), requestID);
            }
        });

    }

}
