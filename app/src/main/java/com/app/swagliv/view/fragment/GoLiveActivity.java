package com.app.swagliv.view.fragment;


import static com.app.common.constant.AppCommonConstants.API_REQUEST.REQUEST_ID_1021;
import static com.app.common.constant.AppCommonConstants.API_REQUEST.REQUEST_ID_1024;
import static com.app.common.constant.AppCommonConstants.API_REQUEST.REQUEST_ID_1025;
import static com.app.common.constant.AppCommonConstants.API_REQUEST.REQUEST_ID_1026;
import static com.app.common.constant.AppCommonConstants.API_REQUEST.REQUEST_ID_1027;
import static com.app.common.constant.AppCommonConstants.API_REQUEST.REQUEST_ID_1028;
import static com.app.common.network.RetrofitClient.BASE_URL;
import static com.app.swagliv.model.Examples.BASIC;

import static io.agora.rtc.Constants.RENDER_MODE_HIDDEN;
import static io.agora.rtc.video.VideoEncoderConfiguration.STANDARD_BITRATE;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.common.interfaces.APIResponseHandler;
import com.app.common.preference.AppPreferencesManager;
import com.app.common.utils.Utility;
import com.app.common.utils.api_response_handler.APIResponse;
import com.app.swagliv.R;
import com.app.swagliv.SwagLivApplication;
import com.app.swagliv.annotation.Example;
import com.app.swagliv.constant.AppConstant;
import com.app.swagliv.model.BaseFragment;
import com.app.swagliv.model.StatisticsInfo;
import com.app.swagliv.model.livestream.pojo.AllLiveStreamCommentsResp;
import com.app.swagliv.model.livestream.pojo.GetListOfActiveViewers;
import com.app.swagliv.model.livestream.pojo.SendLiveStreamNotification;
import com.app.swagliv.model.livestream.pojo.StartLiveStreamResp;
import com.app.swagliv.view.activities.ManageConnectionActivity;
import com.app.swagliv.view.activities.SearchGIFActivity;
import com.app.swagliv.view.activities.SelectHostActivity;
import com.app.swagliv.view.adaptor.ChatCommentsAdapter;
import com.app.swagliv.viewmodel.livestream.LiveStreamViewModel;
import com.bambuser.broadcaster.Broadcaster;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.runtime.Permission;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

import io.agora.rtc.Constants;
import io.agora.rtc.IRtcEngineEventHandler;
import io.agora.rtc.RtcEngine;
import io.agora.rtc.models.ChannelMediaOptions;
import io.agora.rtc.video.VideoCanvas;
import io.agora.rtc.video.VideoEncoderConfiguration;
import io.agora.rtc.video.WatermarkOptions;
import okhttp3.OkHttpClient;

@Example(
        index = 0, group = BASIC, name = R.string.item_joinvideo, actionId = 0, tipsId = R.string.joinchannelvideo)

public class GoLiveActivity extends BaseFragment implements APIResponseHandler {
    private static final String LOGTAG = "GoLiveActivity";
    private static final String API_KEY = "AymJuqtonAkJfAMQg5YKKm";
    private static final String APPLICATION_ID = "pZLjLsZY8QPXUPsrTr56pA";
    SurfaceView mPreviewSurface;
    Broadcaster mBroadcaster;
    RelativeLayout BroadcastButton;
    Context context;
    final OkHttpClient mOkHttpClient = new OkHttpClient();

    private LiveStreamViewModel liveStreamViewModel;

    private ArrayList<AllLiveStreamCommentsResp.Datum> connectionsList;

    private ChatCommentsAdapter adapter;




    private static final String TAG = GoLiveActivity.class.getSimpleName();


    LinearLayout video_container , video_container_row1 ,video_container_row2 ,video_container_row3 ;

    private FrameLayout  fl_local_video, fl_remote, fl_remote_2, fl_remote_3, fl_remote_4, fl_remote_5;
    private Button join;
    private EditText et_channel;
    private io.agora.rtc.RtcEngine engine;
    private int myUid;
    private boolean joined = false;
    private Map<Integer, ViewGroup> remoteViews = new ConcurrentHashMap<Integer, ViewGroup>();
    //private AppCompatTextView localStats, remoteStats;
    private StatisticsInfo statisticsInfo;

    RecyclerView commentRecycleView;
    ImageView img_addConnections, heart, coin, imgBack, img_host;
    EditText et_comment;
    LinearLayout cloneContainer;
    AllLiveStreamCommentsResp allLiveStreamCommentsResp;
    StartLiveStreamResp startLiveStreamResp ;
    SendLiveStreamNotification sendLiveStreamNotification ;
    GetListOfActiveViewers getListOfActiveViewers;

    TextView signals, gif;


    String channel_name ;

    String liveStreamId = "livestreamid_0005826678";
    private String channelName , token ;

    int role ;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_joinchannel_video, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        join = view.findViewById(R.id.btn_join);
        et_channel = view.findViewById(R.id.et_channel);
       // view.findViewById(R.id.btn_join).setOnClickListener(this);

        video_container = view.findViewById(R.id.video_container);


        video_container_row1 = view.findViewById(R.id.video_container_row1);

        video_container_row2 = view.findViewById(R.id.video_container_row2);

        video_container_row3 = view.findViewById(R.id.video_container_row3);




        fl_local_video = view.findViewById(R.id.fl_local_video);
        fl_remote = view.findViewById(R.id.fl_remote_video);
        fl_remote_2 = view.findViewById(R.id.fl_remote2);
        fl_remote_3 = view.findViewById(R.id.fl_remote3);
        fl_remote_4 = view.findViewById(R.id.fl_remote4);
        fl_remote_5 = view.findViewById(R.id.fl_remote5);
     //   localStats = view.findViewById(R.id.local_stats);


        commentRecycleView = view.findViewById(R.id.commentRecycleView);
        img_addConnections = view.findViewById(R.id.img_addConnections);
        signals = view.findViewById(R.id.signals);
        heart = view.findViewById(R.id.heart);
        coin = view.findViewById(R.id.coin);
        imgBack = view.findViewById(R.id.img_back);
        et_comment = view.findViewById(R.id.et_comment);
        img_host = view.findViewById(R.id.img_host);
        cloneContainer = view.findViewById(R.id.cloneContainer);
        gif = view.findViewById(R.id.gif);

    //    localStats.bringToFront();
    //    remoteStats = view.findViewById(R.id.remote_stats);
     //   remoteStats.bringToFront();
        statisticsInfo = new StatisticsInfo();

        liveStreamViewModel = new ViewModelProvider(this).get(LiveStreamViewModel.class);


        liveStreamViewModel.responseMutableLiveData.observe(getViewLifecycleOwner(), new Observer<APIResponse>() {
            @Override
            public void onChanged(APIResponse apiResponse) {
                onAPIResponseHandler(apiResponse);
            }
        });


            try {

                if (this.getArguments().getString("channelName") != null) {


                     channelName = this.getArguments().getString("channelName");

                     token = this.getArguments().getString("agoraToken");

                    liveStreamId = this.getArguments().getString("liveStreamId");

                    int uid = gen();

                     role =  this.getArguments().getInt("client_role", 2);

                    joinChannel(channelName, token, role , liveStreamId);

                } else {


                    getStream();


                }


            }   catch (NullPointerException e) {

                getStream();

            } catch (Exception e) {
                e.printStackTrace();
            }


        img_addConnections.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoTOListConnection = new Intent(getActivity(), ManageConnectionActivity.class);
                gotoTOListConnection.putExtra("liveStreamId", liveStreamId);
                gotoTOListConnection.putExtra("channelName", channelName);
                gotoTOListConnection.putExtra("publisherToken", token);
                gotoTOListConnection.putExtra("role", role);
                startActivity(gotoTOListConnection);
            }
        });

        heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                heartOnClick();
            }
        });

        coin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //openRequestDialog();
                startActivity(new Intent(getActivity(), SelectHostActivity.class));

                Intent selecthostactivity = new Intent(getActivity(), SelectHostActivity.class);
                selecthostactivity.putExtra("liveStreamId", liveStreamId);
                startActivity(selecthostactivity);
            }
        });
        gif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoSearchGif = new Intent(getActivity(), SearchGIFActivity.class);
                startActivity(gotoSearchGif);
            }
        });
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                engine.leaveChannel();

                getActivity().finish();

            }
        });
        et_comment.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    String msg_comment = v.getText().toString();
                    if (!msg_comment.isEmpty()) {
                        postComment(msg_comment);
                        et_comment.getText().clear();
                    }
                    handled = true;
                }
                return handled;
            }

            private void postComment(String msg_comment) {
                if (Utility.isNetworkAvailable(getActivity())) {
                    liveStreamViewModel.postCommentOnLiveStream(liveStreamId
                            , msg_comment, REQUEST_ID_1021);
                }
            }
        });
        img_host.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent gotoTOListConnection = new Intent(getActivity(), SelectHostActivity.class);
                startActivity(gotoTOListConnection);

            }
        });

        if (Utility.isNetworkAvailable(getActivity())) {
            try {
                liveStreamViewModel.getAllLiveStreamCommentsResp(BASE_URL + AppConstant.API.GetAllLiveStreamComments + "/" + liveStreamId
                        , REQUEST_ID_1024);

            } catch (NullPointerException e) {

                e.getMessage();

            }

        }

        if (Utility.isNetworkAvailable(getActivity())) {

            try {
                liveStreamViewModel.getListOfActiveViewers(liveStreamId
                        , REQUEST_ID_1025);

            }catch (NullPointerException e){

                e.getMessage();
            }


        }

        if(fl_local_video.getChildCount() == 0){

            video_container.setWeightSum(1);

            video_container_row1.setOrientation(LinearLayout.VERTICAL);

            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(FrameLayout.LayoutParams.FILL_PARENT, FrameLayout.LayoutParams.FILL_PARENT,1);

            video_container_row1.setLayoutParams(lp);

            fl_local_video.setLayoutParams(lp);

            fl_remote.setVisibility(View.GONE);

            video_container_row2.setVisibility(View.GONE);

            video_container_row3.setVisibility(View.GONE);

        }


    }

    private void updateLocalStats(){
       // localStats.setText(statisticsInfo.getLocalVideoStats());
    }

    private void updateRemoteStats(){
       // remoteStats.setText(statisticsInfo.getRemoteVideoStats());
    }


    void heartOnClick() {

        // Disable clips on all parent generations
        disableAllParentsClip();

        // Create clone
        ImageView imageClone = cloneImage();

        // Animate
        animateFlying(imageClone);
        animateFading(imageClone);

        if (Utility.isNetworkAvailable(getActivity())) {
            liveStreamViewModel.showInterestOnLiveStream(liveStreamId
                    , REQUEST_ID_1026);
        }

    }



    private void disableAllParentsClip() {
        LinearLayout parent = cloneContainer;
        for (int i = 0; i < parent.getChildCount(); i++) {
            View child = parent.getChildAt(i);
            child.setEnabled(false);
        }
    }

    private ImageView cloneImage() {
        ImageView clone = new ImageView(getActivity());
        clone.setLayoutParams(heart.getLayoutParams());
        clone.setImageDrawable(heart.getDrawable());
        clone.setColorFilter(ContextCompat.getColor(getActivity(), R.color.red), android.graphics.PorterDuff.Mode.MULTIPLY);
        cloneContainer.addView(clone);
        return clone;
    }


    private void animateFlying(ImageView image) {
        ObjectAnimator.ofFloat(image, View.TRANSLATION_Y, 800, -290f).setDuration(1800).start();
    }

    private void animateFading(ImageView image) {
        image.animate()
                .alpha(0f)
                .setDuration(2000).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                cloneContainer.removeView(image);
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        // Check if the context is valid
        Context context = getActivity();
        if (context == null)
        {
            return;
        }
        try
        {

            engine = RtcEngine.create(context.getApplicationContext(), getString(R.string.agora_app_id), iRtcEngineEventHandler);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            getActivity().onBackPressed();
        }
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        /**leaveChannel and Destroy the RtcEngine instance*/
        if(engine != null)
        {
            engine.leaveChannel();
        }
        handler.post(RtcEngine::destroy);
        engine = null;
    }

    public int gen() {
        Random r = new Random( System.currentTimeMillis() );
        return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
    }

 public  void getStream() {
     if (!joined) {

         int UserId = gen() ;


         liveStreamViewModel.startLiveStream(AppPreferencesManager.getString(AppConstant.LiveStream.Host, getActivity()),
                  REQUEST_ID_1027);



     }




     }




    private void joinChannel(String channelId , String token, int role , String liveStreamId) throws Exception {
        Context context = getActivity();
        if (context == null)
        {
            return;
        }


        SurfaceView surfaceView = RtcEngine.CreateRendererView(context);


        if(fl_local_video.getChildCount() > 0)
        {
            fl_local_video.removeAllViews();
        }


        if(role == 2) {

            coin.setVisibility(View.VISIBLE);

            heart.setVisibility(View.VISIBLE);

            engine = RtcEngine.create(context.getApplicationContext(), getString(R.string.agora_app_id), iRtcEngineEventHandler);


            fl_remote.addView(surfaceView, new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            // Setup local video to render your local camera preview
            engine.setupRemoteVideo(new VideoCanvas(surfaceView, RENDER_MODE_HIDDEN, 0));
            // Set audio route to microPhone
            engine.setDefaultAudioRoutetoSpeakerphone(true);


            engine.setChannelProfile(Constants.CHANNEL_PROFILE_LIVE_BROADCASTING);


            engine.setClientRole(IRtcEngineEventHandler.ClientRole.CLIENT_ROLE_AUDIENCE);

            Log.d("ShripalBlock","");

        }
        else {

            coin.setVisibility(View.GONE);

            heart.setVisibility(View.GONE);





            Log.d("ShripalBlockElse","");

            engine = RtcEngine.create(context.getApplicationContext(), getString(R.string.agora_app_id), iRtcEngineEventHandler);


            fl_local_video.addView(surfaceView, new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            // Setup local video to render your local camera preview
            engine.setupLocalVideo(new VideoCanvas(surfaceView, RENDER_MODE_HIDDEN, 0 ));
            // Set audio route to microPhone
            engine.setDefaultAudioRoutetoSpeakerphone(true);


            engine.setChannelProfile(Constants.CHANNEL_PROFILE_LIVE_BROADCASTING);



            engine.setClientRole(IRtcEngineEventHandler.ClientRole.CLIENT_ROLE_BROADCASTER);

            String streamId = liveStreamId;


            Log.d("ShripalLogCat", streamId);

            liveStreamViewModel.sendLiveStreamNotification(channelId ,"audience", token, streamId, REQUEST_ID_1028);



        }


        final long period = 5000;
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {

                liveStreamViewModel.getAllLiveStreamCommentsResp(BASE_URL + AppConstant.API.GetAllLiveStreamComments + "/" + liveStreamId
                        , REQUEST_ID_1024);

            }
        }, 5000, period);




        engine.enableVideo();
            // Setup video encoding configs

            engine.setVideoEncoderConfiguration(new VideoEncoderConfiguration(
                    ((SwagLivApplication)getActivity().getApplication()).getGlobalSettings().getVideoEncodingDimensionObject(),
                    VideoEncoderConfiguration.FRAME_RATE.valueOf(((SwagLivApplication)getActivity().getApplication()).getGlobalSettings().getVideoEncodingFrameRate()),
                    STANDARD_BITRATE,
                    VideoEncoderConfiguration.ORIENTATION_MODE.valueOf(((SwagLivApplication)getActivity().getApplication()).getGlobalSettings().getVideoEncodingOrientation())
            ));


            // Setup watermark options
            WatermarkOptions watermarkOptions = new WatermarkOptions();
            int size = ((SwagLivApplication)getActivity().getApplication()).getGlobalSettings().getVideoEncodingDimensionObject().width / 6;
            int height = ((SwagLivApplication)getActivity().getApplication()).getGlobalSettings().getVideoEncodingDimensionObject().height;
            watermarkOptions.positionInPortraitMode = new WatermarkOptions.Rectangle(10,height/2,size,size);
            watermarkOptions.positionInLandscapeMode = new WatermarkOptions.Rectangle(10,height/2,size,size);
            watermarkOptions.visibleInPreview = true;
            // engine.addVideoWatermark(Constant.WATER_MARK_FILE_PATH, watermarkOptions);


            String accessToken = token;
            if (TextUtils.equals(accessToken, "") || TextUtils.equals(accessToken, "<#YOUR ACCESS TOKEN#>"))
            {
                accessToken = null;
            }
            /** Allows a user to join a channel.
             if you do not specify the uid, we will generate the uid for you*/

            ChannelMediaOptions option = new ChannelMediaOptions();
            option.autoSubscribeAudio = true;
            option.autoSubscribeVideo = true;
            int res = engine.joinChannel(accessToken, channelId, "Extra Optional Data", 0, option);
            if (res != 0)
            {
                // Usually happens with invalid parameters
                // Error code description can be found at:
                // en: https://docs.agora.io/en/Voice/API%20Reference/java/classio_1_1agora_1_1rtc_1_1_i_rtc_engine_event_handler_1_1_error_code.html
                // cn: https://docs.agora.io/cn/Voice/API%20Reference/java/classio_1_1agora_1_1rtc_1_1_i_rtc_engine_event_handler_1_1_error_code.html
                showAlert(RtcEngine.getErrorDescription(Math.abs(res)));
                return;
            }




            // Prevent repeated entry
            join.setEnabled(false);


        // Enable video module



    }

    /**
     * IRtcEngineEventHandler is an abstract class providing default implementation.
     * The SDK uses this class to report to the app on SDK runtime events.
     */
    private final IRtcEngineEventHandler iRtcEngineEventHandler = new IRtcEngineEventHandler()
    {
        /**Reports a warning during SDK runtime.
         * Warning code: https://docs.agora.io/en/Voice/API%20Reference/java/classio_1_1agora_1_1rtc_1_1_i_rtc_engine_event_handler_1_1_warn_code.html*/
        @Override
        public void onWarning(int warn)
        {
            Log.w(TAG, String.format("onWarning code %d message %s", warn, RtcEngine.getErrorDescription(warn)));
        }


        @Override
        public void onError(int err)
        {
            Log.e(TAG, String.format("onError code %d message %s", err, RtcEngine.getErrorDescription(err)));
            showAlert(String.format("onError code %d message %s", err, RtcEngine.getErrorDescription(err)));
        }


        @Override
        public void onLeaveChannel(RtcStats stats)
        {
            super.onLeaveChannel(stats);
            Log.i(TAG, String.format("local user %d leaveChannel!", myUid));
            showLongToast(String.format("local user %d leaveChannel!", myUid));
        }

        @Override
        public void onJoinChannelSuccess(String channel, int uid, int elapsed)
        {
            Log.i(TAG, String.format("onJoinChannelSuccess channel %s uid %d", channel, uid));
            showLongToast(String.format("onJoinChannelSuccess channel %s uid %d", channel, uid));
            myUid = uid;
            joined = true;
            handler.post(new Runnable()
            {
                @Override
                public void run()
                {
                    join.setEnabled(true);
                    join.setText("Live");
                }
            });
        }

        @Override
        public void onRemoteAudioStateChanged(int uid, int state, int reason, int elapsed)
        {
            super.onRemoteAudioStateChanged(uid, state, reason, elapsed);
            Log.i(TAG, "onRemoteAudioStateChanged->" + uid + ", state->" + state + ", reason->" + reason);
        }


        @Override
        public void onRemoteVideoStateChanged(int uid, int state, int reason, int elapsed)
        {
            super.onRemoteVideoStateChanged(uid, state, reason, elapsed);
            Log.i(TAG, "onRemoteVideoStateChanged->" + uid + ", state->" + state + ", reason->" + reason);



        }


        @Override
        public void onUserJoined(int uid, int elapsed)
        {
            super.onUserJoined(uid, elapsed);
            Log.i(TAG, "onUserJoined->" + uid);
            showLongToast(String.format("user %d joined!", uid));
            /**Check if the context is correct*/
            Context context = getActivity();
            if (context == null) {
                return;
            }
            if(remoteViews.containsKey(uid)){
                return;
            }
            else{
                handler.post(() ->
                {
                    /**Display remote video stream*/
                    SurfaceView surfaceView = null;
                    // Create render view by RtcEngine
                    surfaceView = RtcEngine.CreateRendererView(context);
                    surfaceView.setZOrderMediaOverlay(true);
                    ViewGroup view = getAvailableView();
                    remoteViews.put(uid, view);
                    // Add to the remote container
                    view.addView(surfaceView, new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                    // Setup remote video to render
                    engine.setupRemoteVideo(new VideoCanvas(surfaceView, RENDER_MODE_HIDDEN, uid));
                });
            }
        }


        @Override
        public void onUserOffline(int uid, int reason)
        {
            Log.i(TAG, String.format("user %d offline! reason:%d", uid, reason));
            showLongToast(String.format("user %d offline! reason:%d", uid, reason));
            handler.post(new Runnable() {
                @Override
                public void run() {

                    engine.setupRemoteVideo(new VideoCanvas(null, RENDER_MODE_HIDDEN, uid));
                    remoteViews.get(uid).removeAllViews();
                    remoteViews.remove(uid);




                }
            });


           getActivity().runOnUiThread(new Runnable() {

                @Override
                public void run() {

                    getAvailableView();


                }
            });


        }

        @Override
        public void onRemoteAudioStats(io.agora.rtc.IRtcEngineEventHandler.RemoteAudioStats remoteAudioStats) {
            statisticsInfo.setRemoteAudioStats(remoteAudioStats);
            updateRemoteStats();
        }

        @Override
        public void onLocalAudioStats(io.agora.rtc.IRtcEngineEventHandler.LocalAudioStats localAudioStats) {
            statisticsInfo.setLocalAudioStats(localAudioStats);
            updateLocalStats();
        }

        @Override
        public void onRemoteVideoStats(io.agora.rtc.IRtcEngineEventHandler.RemoteVideoStats remoteVideoStats) {
            statisticsInfo.setRemoteVideoStats(remoteVideoStats);
            updateRemoteStats();
        }

        @Override
        public void onLocalVideoStats(io.agora.rtc.IRtcEngineEventHandler.LocalVideoStats localVideoStats) {
            statisticsInfo.setLocalVideoStats(localVideoStats);
            updateLocalStats();
        }

        @Override
        public void onRtcStats(io.agora.rtc.IRtcEngineEventHandler.RtcStats rtcStats) {
            statisticsInfo.setRtcStats(rtcStats);
        }
    };

    private ViewGroup getAvailableView() {

        if(fl_remote.getChildCount() == 0){

            video_container.setWeightSum(1);

            fl_remote.setVisibility(View.VISIBLE);


            video_container_row1.setOrientation(LinearLayout.VERTICAL);

            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(FrameLayout.LayoutParams.FILL_PARENT, FrameLayout.LayoutParams.FILL_PARENT,2);

            video_container_row1.setLayoutParams(lp);

            LinearLayout.LayoutParams lp1 = new LinearLayout.LayoutParams(FrameLayout.LayoutParams.FILL_PARENT, FrameLayout.LayoutParams.FILL_PARENT,1);

            fl_local_video.setLayoutParams(lp1);

            fl_remote.setLayoutParams(lp1);

            video_container_row2.setVisibility(View.GONE);

            video_container_row3.setVisibility(View.GONE);


            return fl_remote;
        }
        else if(fl_remote_2.getChildCount() == 0){

            video_container.setWeightSum(2);

            video_container_row2.setVisibility(View.VISIBLE);


            video_container_row1.setOrientation(LinearLayout.HORIZONTAL);

            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT,1);


            video_container_row1.setLayoutParams(lp);

            LinearLayout.LayoutParams lp1 = new LinearLayout.LayoutParams(FrameLayout.LayoutParams.FILL_PARENT, FrameLayout.LayoutParams.FILL_PARENT,1);

            fl_local_video.setLayoutParams(lp1);

            fl_remote.setLayoutParams(lp1);

            video_container_row2.setOrientation(LinearLayout.HORIZONTAL);

            video_container_row2.setLayoutParams(lp);

            fl_remote_2.setLayoutParams(lp1);

            fl_remote_3.setVisibility(View.GONE);

            video_container_row3.setVisibility(View.GONE);

            return fl_remote_2;
        }
        else if(fl_remote_3.getChildCount() == 0){


            fl_remote_3.setVisibility(View.VISIBLE);


            video_container.setWeightSum(2);


            video_container_row1.setOrientation(LinearLayout.HORIZONTAL);

            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT,1);


            video_container_row1.setLayoutParams(lp);

            LinearLayout.LayoutParams lp1 = new LinearLayout.LayoutParams(FrameLayout.LayoutParams.FILL_PARENT, FrameLayout.LayoutParams.FILL_PARENT,1);

            fl_local_video.setLayoutParams(lp1);

            fl_remote.setLayoutParams(lp1);

            video_container_row2.setOrientation(LinearLayout.HORIZONTAL);

            video_container_row2.setLayoutParams(lp);

            fl_remote_2.setLayoutParams(lp1);

            fl_remote_3.setLayoutParams(lp1);

            video_container_row3.setVisibility(View.GONE);

            return fl_remote_3;
        }
        else if(fl_remote_4.getChildCount() == 0){

            video_container_row3.setVisibility(View.VISIBLE);

            video_container.setWeightSum(3);


            video_container_row1.setOrientation(LinearLayout.HORIZONTAL);

            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT,1);


            video_container_row1.setLayoutParams(lp);

            LinearLayout.LayoutParams lp1 = new LinearLayout.LayoutParams(FrameLayout.LayoutParams.FILL_PARENT, FrameLayout.LayoutParams.FILL_PARENT,1);

            fl_local_video.setLayoutParams(lp1);

            fl_remote.setLayoutParams(lp1);

            video_container_row2.setOrientation(LinearLayout.HORIZONTAL);

            video_container_row2.setLayoutParams(lp);

            fl_remote_2.setLayoutParams(lp1);

            fl_remote_3.setLayoutParams(lp1);

            fl_remote_4.setLayoutParams(lp1);

            fl_remote_5.setVisibility(View.GONE);




            return fl_remote_4;
        }
        else if(fl_remote_5.getChildCount() == 0){

            fl_remote_5.setVisibility(View.VISIBLE);

            video_container.setWeightSum(3);


            video_container_row1.setOrientation(LinearLayout.HORIZONTAL);

            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT,1);


            video_container_row1.setLayoutParams(lp);

            LinearLayout.LayoutParams lp1 = new LinearLayout.LayoutParams(FrameLayout.LayoutParams.FILL_PARENT, FrameLayout.LayoutParams.FILL_PARENT,1);

            fl_local_video.setLayoutParams(lp1);

            fl_remote.setLayoutParams(lp1);

            video_container_row2.setOrientation(LinearLayout.HORIZONTAL);

            video_container_row2.setLayoutParams(lp);

            fl_remote_2.setLayoutParams(lp1);

            fl_remote_3.setLayoutParams(lp1);

            fl_remote_4.setLayoutParams(lp1);

            fl_remote_5.setLayoutParams(lp1);

            return fl_remote_5;
        }
        else{
            return fl_remote;
        }
    }

    @Override
    public void onAPIResponseHandler(APIResponse apiResponse) {

        switch (apiResponse.status) {

            case LOADING:
                //------
                break;
            case SUCCESS:

                switch (apiResponse.requestID) {


                    case REQUEST_ID_1027:

                        startLiveStreamResp = (StartLiveStreamResp) apiResponse.data;

                        if (startLiveStreamResp != null) {

                           liveStreamId =  startLiveStreamResp.getData().getLiveStreamId();

                           token = startLiveStreamResp.getData().getAgoraToken();

                             channelName = startLiveStreamResp.getData().getChannelName();

                             role = IRtcEngineEventHandler.ClientRole.CLIENT_ROLE_BROADCASTER;

                             AndPermission.with(this).runtime().permission(
                                     Permission.Group.STORAGE,
                                     Permission.Group.MICROPHONE,
                                     Permission.Group.CAMERA
                             ).onGranted(permissions ->
                             {
                                 try {
                                     joinChannel(channelName,token,role,liveStreamId);
                                 } catch (Exception e) {
                                     e.printStackTrace();
                                 }

                             }).start();

                        }

                        break;

                       case REQUEST_ID_1028:


                        break;


                    case REQUEST_ID_1024:
                        allLiveStreamCommentsResp = (AllLiveStreamCommentsResp) apiResponse.data;
                        if (allLiveStreamCommentsResp != null) {
                            commentRecycleView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, true));
                            connectionsList = (ArrayList<AllLiveStreamCommentsResp.Datum>) allLiveStreamCommentsResp.getData();
                            adapter = new ChatCommentsAdapter(connectionsList);
                            commentRecycleView.setAdapter(adapter);
                        }
                        break;
                    case REQUEST_ID_1021:
                        if (Utility.isNetworkAvailable(getActivity()))
                            liveStreamViewModel.getAllLiveStreamCommentsResp(BASE_URL + AppConstant.API.GetAllLiveStreamComments + "/" + liveStreamId
                                    , REQUEST_ID_1024);
                        break;

                    case REQUEST_ID_1025:
                        getListOfActiveViewers = (GetListOfActiveViewers) apiResponse.data;
                        if (getListOfActiveViewers != null) {
                            int viewerCount = getListOfActiveViewers.getData().getActiveViewersData().size();
                            signals.setText(viewerCount + "");
                        }
                        break;


                    // startActivity(new Intent(getActivity(), BroadcastPlayerActivity.class));
                }
                break;

            case ERROR:
                //-------
                Utility.showToast(getActivity(), getString(R.string.api_failure_error_msg));
                break;
            default:
                break;
        }

    }

}


