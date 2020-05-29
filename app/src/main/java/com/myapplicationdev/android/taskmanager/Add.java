package com.myapplicationdev.android.taskmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Calendar;

public class Add extends AppCompatActivity {

    Button btnAdd, cancel;
    EditText nameET, descET;
    int requestCode = 123;
    int notificationID = 888;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        nameET = findViewById(R.id.nameET);
        descET = findViewById(R.id.descET);
        btnAdd = findViewById(R.id.addTask);
        cancel = findViewById(R.id.cancel);

        btnAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.HOUR, 8);

                Intent intent = new Intent(Add.this,
                        ScheduledNotificationReceiver.class);

                intent.putExtra("name", nameET.getText().toString());

                PendingIntent pendingIntent = PendingIntent.getBroadcast(
                        Add.this, requestCode,
                        intent, PendingIntent.FLAG_CANCEL_CURRENT);

                AlarmManager am = (AlarmManager)
                        getSystemService(Activity.ALARM_SERVICE);
                am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),
                        pendingIntent);
                finish();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }


}

