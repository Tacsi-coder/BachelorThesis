package com.example.adamtacsik.MyReminder;

import android.app.Notification;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

//    private NotificationView mNotificationView;   //in case if we create a Notification channel

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mNotificationView = new NotificationView(this);
    }

    public void Click(View view) {

        Intent intent = new Intent(MainActivity.this, Reminders.class);
        startActivity(intent);  //starting activity is the intent of the MainActivity class

//         Notification.Builder nb = new NotificationView.getAndroidChannel();
//         mNotificationView.getManager().notify(101, nb.build());
    }
}

