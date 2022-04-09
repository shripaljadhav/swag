package com.app.swagliv;

import android.app.Activity;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

import com.app.common.utils.Utility;
import com.app.swagliv.annotation.Example;
import com.app.swagliv.constant.AppConstant;
import com.app.swagliv.constant.AppInstance;
import com.app.swagliv.model.Examples;
import com.app.swagliv.model.GlobalSettings;
import com.app.swagliv.utils.ClassUtils;
import com.app.swagliv.view.activities.BroadcastPlayerActivity;
import com.app.swagliv.view.activities.ChatActivity;
import com.app.swagliv.view.fragment.GoLiveActivity;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.onesignal.OSInAppMessageAction;
import com.onesignal.OSNotification;
import com.onesignal.OneSignal;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.annotation.Annotation;
import java.util.Set;

import io.agora.rtc.IRtcEngineEventHandler;
import io.agora.rtc.RtcEngine;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;


public class SwagLivApplication extends Application implements LifecycleEventObserver {

    private GlobalSettings globalSettings;


    //Constants
    public static final String TAG = SwagLivApplication.class.getSimpleName();

    private static SwagLivApplication ourInstance;
    private static boolean isAppInForeground;
    private GoogleSignInClient googleSignInClient;
    private Socket mSocket;

    public static SwagLivApplication getInstance() {
        return ourInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ourInstance = this;
        isAppInForeground = true;

        OneSignal.setNotificationOpenedHandler(
                result -> {

                    if(result!=null) {

                        try {
                            String channelName = result.getNotification().getAdditionalData().getString("channelName");
                            String uid = result.getNotification().getAdditionalData().getString("uid");
                            int role = result.getNotification().getAdditionalData().getInt("role");
                            String agoraToken = result.getNotification().getAdditionalData().getString("publisherToken");
                            String liveStreamId = result.getNotification().getAdditionalData().getString("liveStreamId");
                            Intent intent = new Intent(this, BroadcastPlayerActivity.class);
                            intent.putExtra("channelName", channelName);
                            intent.putExtra("agoraToken", agoraToken);
                            intent.putExtra("client_role",role );
                            intent.putExtra("liveStreamId", liveStreamId);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }


                });

        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {

            }

            @Override
            public void onActivityStarted(@NonNull Activity activity) {

            }

            @Override
            public void onActivityResumed(@NonNull Activity activity) {
            }

            @Override
            public void onActivityPaused(@NonNull Activity activity) {

            }

            @Override
            public void onActivityStopped(@NonNull Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {

            }

            @Override
            public void onActivityDestroyed(@NonNull Activity activity) {

            }
        });
    }


    private void initExamples() {
        try {
            Set<String> packageName = ClassUtils.getFileNameByPackageName(this, "io.agora.api.example.examples");
            for (String name : packageName) {
                if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.N && name.contains("io.agora.api.example.examples.advanced.ARCore")) {
                    continue;
                }
                Class<?> aClass = Class.forName(name);
                Annotation[] declaredAnnotations = aClass.getAnnotations();
                for (Annotation annotation : declaredAnnotations) {
                    if (annotation instanceof Example) {
                        Example example = (Example) annotation;
                        Examples.addItem(example);
                    }
                }
            }
            Examples.sortItem();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public GlobalSettings getGlobalSettings() {
        if(globalSettings == null){
            globalSettings = new GlobalSettings();
        }
        return globalSettings;
    }

    public GoogleSignInClient getGoogleSignInClient() {
        if (googleSignInClient == null) {
            //we need a GoogleSignInOptions object
            //And we need to build it as below
            GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestIdToken(getString(R.string.default_web_client_id))
                    .requestEmail()
                    .build();

            //Then we will get the GoogleSignInClient object from GoogleSignIn class
            googleSignInClient = GoogleSignIn.getClient(this, gso);
        }
        return googleSignInClient;
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onAppBackgrounded() {
        //App in background
        isAppInForeground = false;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onAppForegrounded() {
        // App in foreground
        isAppInForeground = true;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onAppDestroyed() {
    }

    public boolean isAppInForeground() {
        return isAppInForeground;
    }


    @Override
    public void onStateChanged(@NonNull LifecycleOwner source, @NonNull Lifecycle.Event event) {

    }

}
