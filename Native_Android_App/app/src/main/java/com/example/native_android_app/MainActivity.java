package com.example.native_android_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.izooto.iZooto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button addEvents,addProperties,addTopic,removeTopic,subscription,analytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addEvents=findViewById(R.id.addEvents);
        addEvents.setOnClickListener(this);
        addProperties=findViewById(R.id.addProperties);
        addProperties.setOnClickListener(this);
        addTopic=findViewById(R.id.addTopic);
        addTopic.setOnClickListener(this);
        removeTopic=findViewById(R.id.removeTopic);
        removeTopic.setOnClickListener(this);
        subscription=findViewById(R.id.subscription);
        subscription.setOnClickListener(this);
        analytics=findViewById(R.id.analytics);
        analytics.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.addEvents:
                String eventName ="Demo";
                HashMap<String,Object> data =new HashMap<>();
                data.put("Card","HDFC");
                iZooto.addEvent(eventName,data);

                break;
            case R.id.addProperties:
                HashMap<String,Object> datav =new HashMap<>();
                datav.put("Language","English");
                iZooto.addUserProperty(datav);

                break;
            case R.id.addTopic:
                List<String> topicList =new ArrayList<>();
                topicList.add("Cricekt");
                iZooto.addTag(topicList);;

                break;
            case R.id.removeTopic:
                List<String> rtopicList =new ArrayList<>();
                rtopicList.add("Cricekt");
                iZooto.removeTag(rtopicList);;
                break;
            case R.id.subscription:
                iZooto.setSubscription(true);

                break;
            case R.id.analytics:
                iZooto.setFirebaseAnalytics(true);

                break;

        }
    }
}