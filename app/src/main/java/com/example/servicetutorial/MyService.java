package com.example.servicetutorial;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import static com.example.servicetutorial.MyApplication.CHANNEL_ID;

public class MyService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("log","oncreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String dataIntent = intent.getStringExtra("key data intent");
        sendNotification(dataIntent);
        return START_NOT_STICKY;
    }

    private void sendNotification(String dataIntent) {
        Intent intent = new Intent(this,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);

        Notification notification = new NotificationCompat.Builder(this,CHANNEL_ID)
                .setContentTitle("Title notification service")
                .setContentText(dataIntent)
                .setSmallIcon(R.drawable.ic_notification)
                .setContentIntent(pendingIntent)
                .build();

        startForeground(1,notification);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("log","ondestroy");
    }
}
