package com.app.swagliv.model.livestream.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SendLiveStreamNotification {

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
        @SerializedName("channelName")
        @Expose
        private String channelName;
        @SerializedName("role")
        @Expose
        private String role;
        @SerializedName("uid")
        @Expose
        private Integer uid;
        @SerializedName("publisherToken")
        @Expose
        private String publisherToken;
        @SerializedName("audienceToken")
        @Expose
        private String audienceToken;

        public String getLiveStreamId() {
            return liveStreamId;
        }

        public void setLiveStreamId(String liveStreamId) {
            this.liveStreamId = liveStreamId;
        }

        public String getChannelName() {
            return channelName;
        }

        public void setChannelName(String channelName) {
            this.channelName = channelName;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public Integer getUid() {
            return uid;
        }

        public void setUid(Integer uid) {
            this.uid = uid;
        }

        public String getPublisherToken() {
            return publisherToken;
        }

        public void setPublisherToken(String publisherToken) {
            this.publisherToken = publisherToken;
        }

        public String getAudienceToken() {
            return audienceToken;
        }

        public void setAudienceToken(String audienceToken) {
            this.audienceToken = audienceToken;
        }

    }

}
