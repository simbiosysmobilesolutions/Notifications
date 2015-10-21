package com.simbiosyscorp.tutorials.notifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiConfiguration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class StatusBarActivity extends AppCompatActivity {
Button sendBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_bar);
        sendBtn= (Button) findViewById(R.id.send);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent(getApplicationContext(), StatusBarTarget.class);

                PendingIntent pi = PendingIntent.getActivity(getApplicationContext(), 0, resultIntent, 0);

                //Notification.Builder makes it easier to construct Notifications.
                Notification.Builder builder =  new Notification.Builder(getApplicationContext())
                        .setContentIntent(pi)
                //Makes this notification automatically dismiss when the user touches it.
                        .setAutoCancel(true)
                        //Sets the title for the Notification
                        .setContentTitle("StatusBar Notification")
                        //Add image to the Notification
                        .setSmallIcon(R.mipmap.ic_launcher)
                        //Sets content
                        .setContentText("This is a status bar notification.")
                        //Sets sound, Vibrate and LED alerts. These can be set individually as well.
                        .setDefaults(Notification.DEFAULT_ALL);

                NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                nm.notify(1111, builder.build());
            }
        });

    }


}
