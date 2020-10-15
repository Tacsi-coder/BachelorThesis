package com.example.adamtacsik.MyReminder;

import android.annotation.SuppressLint;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Reminders extends AppCompatActivity {
    NotificationManager mNotificationManager;
    private String message;    //Creating the class fields
    private String repeatTime;
    private String stayTime;
    private String dropDuration;
    private String dropDuration1;
    private String formattedDate;
    private long timeStay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reminder_set);  //calling reminder_set layout


        EditText text = (EditText) findViewById(R.id.title);   //Finding title id in reminder_set layout
        message = text.getText().toString();  //Convert title's value into a String
        Switch simpleSwitch = (Switch) findViewById(R.id.switch2);  //Finding switch2 id in reminder_set layout

        simpleSwitch.setTextOn("Yes"); // displayed text of the Switch whenever it is in checked or on state
        simpleSwitch.setTextOff("No"); // displayed text of the Switch whenever it is in unchecked i.e. off state

        EditText time = (EditText) findViewById(R.id.everytime); //Finding everytime's id in reminder_set layout
        repeatTime = time.getText().toString();  //Convert everytime's value into a String


        Spinner dropdown = (Spinner) findViewById(R.id.spinner);    /*creating an instance of Spinner
        class and giving spinner as a context argument*/
        ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter //creating an adapter instance of charsequences
                .createFromResource(this, R.array.time, android.R.layout.simple_spinner_item);  /*The adapter's listview items
        will be created from values of time and calling android25-simple_spinner_item.xml*/

        staticAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);   /*Specify the layout to
        use when the list of choices appears*/
        dropdown.setAdapter(staticAdapter); //Apply the adapter to the spinner

        dropDuration1 = dropdown.getSelectedItem().toString();  //Converting the values of adapter into a String

        EditText time2 = (EditText) findViewById(R.id.stayForTime);  //Finding StayForTime id in reminder_set layout
        stayTime = time2.getText().toString();   //Convert stayForTime's value into a String


        Spinner dropdown2 = (Spinner) findViewById(R.id.spinner1);  //Creating another spinner instance from spinner1's id.
        ArrayAdapter<CharSequence> staticAdapter2 = ArrayAdapter    /*Creating our second adapter, it is
        for creting a list of options of time*/
                .createFromResource(this, R.array.time, android.R.layout.simple_spinner_item);

        staticAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);  /* Specify the
        layout to use when the list of choices appears*/

        dropdown2.setAdapter(staticAdapter2); // Apply the adapter to the spinner
        dropDuration = dropdown2.getSelectedItem().toString();
    }

    public void setReminder(View view) {
        EditText text = (EditText) findViewById(R.id.title);  //Finding title id in reminder_set layout
        message = text.getText().toString();  //Getting message's values and convert them into a String

        Switch simpleSwitch = (Switch) findViewById(R.id.switch2);  //Finding switch2's id in reminder_set layout

        simpleSwitch.setTextOn("Yes"); // displayed text of the Switch whenever it is in checked or on state
        simpleSwitch.setTextOff("No"); // displayed text of the Switch whenever it is in unchecked i.e. off state

        EditText time = (EditText) findViewById(R.id.everytime);  //Finding everytime's id in reminder_set layout
        repeatTime = time.getText().toString();  //Getting repeatTime's values and convert them into a String

        Spinner dropdown = (Spinner) findViewById(R.id.spinner);  //Finding spinner's id in reminder_set layout
        dropDuration1 = dropdown.getSelectedItem().toString();  //Getting dropDuration1's values and convert them into a String

        EditText time2 = (EditText) findViewById(R.id.stayForTime);  //Finding stayForTime's id in reminder_set layout
        stayTime = time2.getText().toString();   //Getting stayTime's values and convert them into a String

        Spinner dropdown2 = (Spinner) findViewById(R.id.spinner1);  //Finding spinner1's id in reminder_set layout
        dropDuration = dropdown2.getSelectedItem().toString();  //Getting spinner1's values and convert them into a String


        Calendar cal = Calendar.getInstance();   //Creating an instance of calendar

        switch (dropDuration) {    //Creating Switch-case depending on the first spinner's value (Occur every duration)
            case "Hours":
                timeStay = (Long.parseLong(stayTime) * 60 * 60 * 1000);
                cal.add(Calendar.HOUR_OF_DAY, Integer.parseInt(stayTime));
                break;
            case "Days":
                timeStay = (Long.parseLong(stayTime) * 60 * 60 * 24 * 1000);
                cal.add(Calendar.DAY_OF_MONTH, Integer.parseInt(stayTime));
                break;
            case "Weeks":
                timeStay = (Long.parseLong(stayTime) * 60 * 60 * 1000 * 24 * 7);
                cal.add(Calendar.WEEK_OF_MONTH, Integer.parseInt(stayTime));
                break;
            case "Months":
                timeStay = (Long.parseLong(stayTime) * 60 * 60 * 24 * 1000 * 30);
                cal.add(Calendar.MONTH, Integer.parseInt(stayTime));
                break;
            default:
                timeStay = (Long.parseLong(stayTime) * 60 * 60 * 24 * 1000 * 365);
                cal.add(Calendar.YEAR, Integer.parseInt(stayTime));
                break;
        }


        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormatter =
                new SimpleDateFormat("MMM dd, yyyy, hh:mm aa");  //Creating the format of our timesys


        long timesys = cal.getTimeInMillis();
        cal.setTimeInMillis(timesys);
        String formattedDate = dateFormatter.format(cal.getTime()); //Getting formattedDate's values of time

        if (repeatTime.length() != 0) {
            Calendar cal2 = Calendar.getInstance();
            cal2.setLenient(true);    //Method specifies whether date/time interpretation is to be lenient or not.


            switch (dropDuration1) {  //Creating second switch case depending on the second's spinner's value (Stay for)
                case "Hours":
                    cal2.add(Calendar.HOUR_OF_DAY, Integer.parseInt(repeatTime));
                    break;
                case "Days":
                    cal2.add(Calendar.DAY_OF_MONTH, Integer.parseInt(repeatTime));
                    break;
                case "Weeks":
                    cal2.add(Calendar.WEEK_OF_MONTH, Integer.parseInt(repeatTime));
                    break;
                case "Months":
                    cal2.add(Calendar.MONTH, Integer.parseInt(repeatTime));
                    break;
                default:
                    cal2.add(Calendar.YEAR, Integer.parseInt(repeatTime));
                    break;
            }

            @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormatter2 =
                    new SimpleDateFormat("MMM dd, yyyy, hh:mm aa");  //Creating the format of our timesys

            long timesys2 = cal2.getTimeInMillis();
            cal2.setTimeInMillis(timesys2);
            this.formattedDate = dateFormatter2.format(cal2.getTime());   //This will be counting on the elapsed time
        }

        String contentText;
        String contentText2;
        if (repeatTime.length() != 0) { //If the repeatTime string not empty
            contentText = "Repeat every: " + repeatTime + " " + dropDuration1 + " " + "\nNext at: " + this.formattedDate;
            /*contextText is the starting time of the activity and repeat it from that time*/
            contentText2 = "\nEnds at: " + formattedDate;
        }    //Indicate to the user the end date of the activity
        else {
            contentText = "Ends at: " + formattedDate;   //if repeatTime string is empty, do not repeat just indicate the activity
            contentText2 = "";
        }

          /*  public Notification.Builder getAndroidChannelNotification(String title, String body) {  //if API > android.O (API 26)

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

        NotificationCompat.Builder mBuilder =       //creating a notification
                new NotificationCompat.Builder(getApplicationContext())
                        .setSmallIcon(R.drawable.color_mustard_yellow)  //icon of the notification
                        .setStyle(new NotificationCompat.BigTextStyle().bigText("REMINDER: " + message))
                        .setContentTitle("REMINDER: " + message)
                        .setStyle(new NotificationCompat.BigTextStyle().bigText(contentText + " " + contentText2))  //The style of the contextText
                        .setContentText(contentText + " " + contentText2);  //The context Text


        Intent resultIntent = new Intent(this, MainActivity.class);  // Creates an explicit intent for an Activity in the app

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);  /* The stack builder object will contain an
        artificial back stack for the started Activity. This ensures that navigating backward from the Activity
        leads out of the application to the Home screen.*/

        stackBuilder.addParentStack(MainActivity.class);    // Adds the back stack for the Intent (but not the Intent itself)

        stackBuilder.addNextIntent(resultIntent);  // Adds the Intent that starts the Activity to the top of the stack
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0, PendingIntent.FLAG_UPDATE_CURRENT  //update the current activity if comes any
                );
        mBuilder.setContentIntent(resultPendingIntent);
        mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);  //Return the handle to a system-level service by Reminder class.

        int id = (int) ((new Date().getTime() / 1000L) % Integer.MAX_VALUE);
        mNotificationManager.notify(id, mBuilder.build());  // mId allows you to update the notification later on.
        removeNotification(id);

        Intent intent = new Intent(Reminders.this, MainActivity.class); /*Intent constructor has been called,
        new Intent instance is created, deliver the intent to the MainActivity class*/
        startActivity(intent);     //The activity started
        Toast.makeText(Reminders.this, "Reminder Set", Toast.LENGTH_SHORT).show();  /*Indicate to
        the user a new reminder has been set*/
    }

    private void removeNotification(final int id) {  /*This is the method which services
        that we want to get rid of a notification*/
        Handler handler = new Handler();
        long delayInMilliseconds = timeStay;
        handler.postDelayed(new Runnable() {
            public void run() {
                mNotificationManager.cancel(id);   //Cancel a previously posted notification
            }
        }, delayInMilliseconds);
    }
}


