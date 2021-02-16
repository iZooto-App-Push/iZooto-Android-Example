package com.example.native_android_app;

import android.app.Application;
import android.content.Intent;
import android.util.Log;

import com.izooto.NotificationHelperListener;
import com.izooto.NotificationWebViewListener;
import com.izooto.Payload;
import com.izooto.TokenReceivedListener;
import com.izooto.iZooto;

import org.json.JSONException;
import org.json.JSONObject;

public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        iZooto.initialize(this)
                .setTokenReceivedListener(new ExampleNotificationTokenHandler())
                .setNotificationReceiveListener(new ExampleNotificationHandler())
                .setLandingURLListener(new ExampleNotificationWebViewHandler())
                .build();
    }
    class ExampleNotificationTokenHandler implements TokenReceivedListener {
        @Override
        public void onTokenReceived(String token) {
            Log.i("iZootoExample","token = " + token);
        }
    }
    class ExampleNotificationHandler implements NotificationHelperListener {
        @Override
        public void onNotificationReceived(Payload payload) {
            Log.i("iZootoExample","payload = " + payload.getTitle());
        }
        /*
        1. If we clicked on notification then, it will show actionType 0.
        2. If we clicked on button 1 then, it will show action type 1.
        3. If we clicked on button 2 then, it will show action type 2.*/
        @Override
        public void onNotificationOpened(String data) {
            String actionType;
            try {
                JSONObject jsonObj = new JSONObject(data);
                actionType = jsonObj.getString("actionType");
                if (actionType.equalsIgnoreCase("0")){
                    Intent intent =new Intent(getApplicationContext(), MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }else if (actionType.equalsIgnoreCase("1")){
                    Intent intent =new Intent(getApplicationContext(), MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }else if (actionType.equalsIgnoreCase("2")){
                    Intent intent =new Intent(getApplicationContext(), MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
    class ExampleNotificationWebViewHandler implements NotificationWebViewListener {
        /*To open landing url inside your activity*/
        @Override
        public void onWebView(String landingUrl) {
            if (landingUrl!=null){
                Intent intent =new Intent(getApplicationContext(), MainActivity.class);//Replace activity name
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("openURL", landingUrl);
                startActivity(intent);
            }
        }
    }
}

