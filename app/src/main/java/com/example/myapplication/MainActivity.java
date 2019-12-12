package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doSomething(View view){
        NotificationManagerCompat myManager = NotificationManagerCompat.from(this);
        NotificationCompat.Builder myNotif = new NotificationCompat.Builder(this);

        myNotif.setContentTitle("1 New Message");
        myNotif.setContentText("Congratulations your application letter has been Approved");
        myNotif.setSmallIcon(R.drawable.harvard);
        myNotif.setColor(ContextCompat.getColor(this,R.color.colorHarvard));
        myNotif.setLargeIcon(BitmapFactory.decodeResource(this.getResources(),R.drawable.harvard));

        Intent il = new Intent (this, MainActivity.class);
        PendingIntent pd = PendingIntent.getActivity(this, 1, il, 0);

        myNotif.setContentIntent(pd);
        myNotif.setAutoCancel(true);
        myManager.notify(1,myNotif.build());

        finish();
    }
}
