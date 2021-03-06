package com.app.swagliv.constant;

public class AppConstant {

    public static final String CHAT_SERVER_URL = "http://swaglivchat-env.eba-mcta3mmt.ap-south-1.elasticbeanstalk.com/";
//    public static final String CHAT_SERVER_URL = "http://192.168.29.105:4000";

    public static final String USER = "USER";
    public static final String USER_SUBSCRIPTION_PLAN = "USER_SUBSCRIPTION_PLAN";
    public static final String PERSONAL_IMAGES = "personalImages";
    public static final String PROFILE_IMAGES = "profileImages";
    public static final int MAX_PASSION_SELECTION_COUNT = 5;
    public static final String MEN = "Men";
    public static final String WOMEN = "Women";

    public class INTENT_KEYS {
        public static final String IS_NEED_TO_CHECK_GPS = "IS_NEED_TO_CHECK_GPS";
        public static final String IS_CALL_FOR_LOCATION_PERMISSION = "IS_CALL_FOR_LOCATION_PERMISSION";
        public static final String SELECTED_PASSIONS = "SELECTED_PASSIONS";
        public static final String USER_DATA = "USER_DATA";
    }


    public class LiveStream {
        public static final String Host = "publisher";
        public static final String Audience = "Subscriber";

    }

    public class PREFERENCE_KEYS {
        public static final String CURRENT_USER_PROFILE_STATUS = "CURRENT_USER_PROFILE_STATUS";
        public static final String CURRENT_USER_ID = "CURRENT_USER_ID";
        public static final String IS_APP_ALREADY_OPEN = "IS_FIRST_TIME_APP_OPEN";
        public static final String APP_TOKEN = "APP_TOKEN";
        public static final String TWILIO_ACCESS_TOKEN = "TWILIO_ACCESS_TOKEN";
        public static final String LiveStreamId = "LiveStreamId";
        public static final String ConnectionId = "ConnectionId";
    }

    public class PROFILE_STATUS {
        public static final String SIGN_UP = "SIGN_UP";
        public static final String MOBILE_NO_UPDATED = "MOBILE_NO_UPDATED";
        public static final String PROFILE_COMPLETED = "PROFILE_COMPLETED";
    }

    public class RequestCodes {
        public static final int PROFILE = 101;
        public static final int OTHER_IMAGES = 102;
        public static final int CAMERA = 103;
        public static final int GALLERY = 104;

    }

    public class API {
        public static final String GET_ALL_PASSION = "getAllPassions";
        public static final String UPLOAD_PROFILE_IMAGES = "uploadImage";
        public static final String REGISTER = "createUser";
        public static final String UPDATE_MOBILE_NUMBER = "updateMobileNumber";
        public static final String VERIFY_MOBILE_OTP = "verifyMobileOtp";
        public static final String LOGIN = "login";
        public static final String GET_NEW_PROFILES = "getNewProfiles";
        public static final String ACTION_ON_PROFILE = "actionOnProfiles";
        public static final String GET_USER_LIKE = "getUserLikes";
        public static final String UPDATE_PROFILE = "updateProfile";
        public static final String GET_SUBSCRIPTION_PLAN = "getAllSubscriptionPlans";
        public static final String CREATE_ORDER = "createOrder";
        public static final String VERIFY_ORDER = "verifyOrder";
        public static final String GET_TWILIO_ACCESS_TOKEN = "getTwilioAccessToken";
        public static final String REMOVE_IMAGE = "removeImage";
        public static final String PostCommentOnLiveStream = "postCommentOnLiveStream";
        public static final String CreateConnection = "createConnection";
        public static final String ActionOnConnectionRequest = "actionOnConnectionRequest";
        public static final String AddHost = "addHostsToLiveStream";
        public static final String sendPushNotificationToHosts = "sendPushNotificationToHosts";
        public static final String GetConnectionsList = "getConnectionsList";
        public static final String StartLiveStream = "startLiveStream";
        public static final String SendLiveStreamNotification = "sendLiveStreamNotification";
        public static final String shareCoinsToHost = "shareCoinsToHost";
        public static final String showInterestOnLiveStream = "showInterestOnLiveStream";
        public static final String GetAllLiveStreamComments = "getAllLiveStreamComments";
        public static final String GetListOfActiveViewers = "getListOfActiveViewers";
        public static final String exitLiveStream = "exitLiveStream";
        public static final String GetHostList = "getAllHostsList";
        public static final String GetWalletBalance = "getWalletBalance";


    }

    public class SWIPE {
        public static final int LIKE = 1;
        public static final int DISLIKE = 2;
        public static final int SUPER_LIKE = 3;

    }

    public class CHAT {
        public static final int MESSAGE_TYPE_IMAGE = 100;
        public static final String GET_PREVIOUS_CHATS = "getPreviousChat";
        public static final int MESSAGE_TYPE_TEXT = 101;
        public static final int MESSAGE_TYPE_LOCATION = 102;
        public static final int MESSAGE_RECEIVED_CODE_LEFT = 0;
        public static final int MESSAGE_RECEIVED_CODE_RIGHT = 1;
        public static final String ADD_USER = "addUser";
        public static final String USER_STATUS = "userStatus";
        public static final String SET_UP_CONVERSATION_ID = "setUpConversationId";
        public static final String SET_UP_CONVERSATION_STATUS = "setupConversation_status";
        public static final String TYPING_STATUS = "typingStatus";
        public static final String IS_TYPING = "isTyping";
        public static final String SEND_MESSAGE = "sendMessage";
        public static final String GET_MESSAGE = "getMessage";
        public static final String GET_USER_CHATS = "allConversations";

    }

    public class IMAGE_UPLOAD_MESSAGE {
        public static final String PROFILE_IMAGE_UPLOADED = "Profile image uploaded";
        public static final String IMAGE_UPLOADED = "Image uploaded";
    }

    public static final int SWIPE_LIMIT = 5;
    public static final String SWIPE_LIMIT_EXCEED = "SWIPE_LIMIT_EXCEED";

}
