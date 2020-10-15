package com.example.adamtacsik.MyReminder;

import com.example.adamtacsik.MyReminder.R;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

//import androidx.core.app.NotificationCompat;
//import androidx.core.app.TaskStackBuilder;


public class NotificationView extends AppCompatActivity {

    public static final String ANDROID_CHANNEL_ID = "com.example.adamtacsik.trynotification.ANDROID";
    public static final String IOS_CHANNEL_ID = "com.example.adamtacsik.trynotification.IOS";
    public static final String ANDROID_CHANNEL_NAME = "ANDROID CHANNEL";
    public static final String IOS_CHANNEL_NAME = "IOS_CHANNEL";
    private NotificationManager mManager;

    public NotificationView(Context base) {
        super();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);  //Calling the setter method of ContentView
    }


/*
    public void createChannels() {      //in case if SDK version of android is bigger than Android.O, then a Notification channel needs to be created

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // create android channel
            NotificationChannel androidChannel = new NotificationChannel(ANDROID_CHANNEL_ID,
                    ANDROID_CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
            // Sets whether notifications posted to this channel should display notification lights
            androidChannel.enableLights(true);
            // Sets whether notification posted to this channel should vibrate.
            androidChannel.enableVibration(true);
            // Sets the notification light color for notifications posted to this channel
            androidChannel.setLightColor(Color.GREEN);
            // Sets whether notifications posted to this channel appear on the lockscreen or not
            androidChannel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

            getManager().createNotificationChannel(androidChannel);

            // create ios channel
            NotificationChannel iosChannel = new NotificationChannel(IOS_CHANNEL_ID,
                    IOS_CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH);
            iosChannel.enableLights(true);
            iosChannel.enableVibration(true);
            iosChannel.setLightColor(Color.GRAY);
            iosChannel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
            getManager().createNotificationChannel(iosChannel);
        }
    }

    NotificationManager getManager() {
        if (mManager == null) {
            mManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return mManager;
    }*/

    /*public Notification.Builder getAndroidChannelNotification(String title, String body) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            return new Notification.Builder(getApplicationContext(), ANDROID_CHANNEL_ID)
                    .setContentTitle(title)
                    .setContentText(body)
                    .setSmallIcon(android.R.drawable.stat_notify_more)
                    .setAutoCancel(true);
        }
        return null;
    }*/

    /*public Notification.Builder getIosChannelNotification(String title, String body) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            return new Notification.Builder(getApplicationContext(), IOS_CHANNEL_ID)
                    .setContentTitle(title)
                    .setContentText(body)
                    .setSmallIcon(android.R.drawable.stat_notify_more)
                    .setAutoCancel(true);
        }
        return null;
    }

     /*  public Notification.Builder getAndroidChannelNotification(String title, String body) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    return new Notification.Builder(getApplicationContext(), ANDROID_CHANNEL_ID)
                            .setContentTitle("REMINDER: "+message)
                            .setContentText(contentText+" "+contentText2)
                            .setSmallIcon(R.drawable.color_mustard_yellow)
                            .setStyle(new NotificationCompat.BigTextStyle().bigText("REMINDER: "+message))
                            .setStyle(new NotificationCompat.BigTextStyle().bigText(contentText+" "+contentText2));
                }
                return null;
            }*/
}