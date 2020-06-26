package com.clg.harsh.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAlert=(Button)findViewById(R.id.btnAlert);

        

    }

    public void open(View view)
    {
        AlertDialog.Builder alertD = new AlertDialog.Builder(this);
        alertD.setMessage("Are you sure ???");
        alertD.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "you clicked yes", Toast.LENGTH_LONG).show();
            }
        });

        alertD.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        AlertDialog ad = alertD.create();
        ad.show();

        if (Build.VERSION.SDK_INT<16)
        {
            Notification n = new Notification.Builder(this)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Notification")
                    .setContentText("test")
                    .setAutoCancel(true).getNotification();
            NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            nm.notify(0, n);
        }
        else
        {
            Notification n = new Notification.Builder(this)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Notification")
                    .setContentText("test")
                    .setAutoCancel(true).build();
            NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            nm.notify(0, n);
        }
    }
}
