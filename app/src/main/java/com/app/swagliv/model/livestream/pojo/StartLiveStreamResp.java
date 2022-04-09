
package com.app.swagliv.model.livestream.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StartLiveStreamResp {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("Data")
    @Expose
    private Data data;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }


    public class Data {

        @SerializedName("liveStreamId")
        @Expose
        private String liveStreamId;
        @SerializedName("agoraToken")
        @Expose
        private String agoraToken;
        @SerializedName("channelName")
        @Expose
        private String channelName;
        @SerializedName("uid")
        @Expose
        private String uid;

        public String getLiveStreamId() {
            return liveStreamId;
        }

        public void setLiveStreamId(String liveStreamId) {
            this.liveStreamId = liveStreamId;
        }

        public String getAgoraToken() {
            return agoraToken;
        }

        public void setAgoraToken(String agoraToken) {
            this.agoraToken = agoraToken;
        }

        public String getChannelName(){
            return channelName;
        }

        public void setChannelName(String channelName){

            this.channelName = channelName ;
        }


        public  String getUid(){
            return uid;
        }

        public void setUid(String uid){
            this.uid=uid;
        }


    }

}








