package com.myapplicationdev.android.taskmanager;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;

public class ScheduledNotificationReceiver extends BroadcastReceiver {
    int reqCode = 12345;
    int notificationID = 888;




    @Override
    public void onReceive(Context context, Intent intent) {


        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new
                    NotificationChannel("default", "Default Channel",
                    NotificationManager.IMPORTANCE_DEFAULT);

            channel.setDescription("Task Manager Reminder");
            notificationManager.createNotificationChannel(channel);
        }
        Intent i = new Intent(context,MainActivity.class);
        PendingIntent pIntent =  PendingIntent.getActivity(context,reqCode,i,PendingIntent.FLAG_CANCEL_CURRENT);
        NotificationCompat.Builder builder = new
                NotificationCompat.Builder(context, "default");
        builder.setContentTitle("Task Manager Reminder!");
        builder.setContentText(intent.getStringExtra("name"));
        builder.setContentIntent(pIntent);
        builder.setSmallIcon(android.R.drawable.btn_star_big_off);
        builder.setAutoCancel(true);
        Notification n = builder.build();
        notificationManager.notify(888,n);

    }
}
