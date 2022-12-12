package com.example.lab14;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.Person;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // Идентификатор уведомления
    private static final int NOTIFY_ID = 101;

    private int counter = 1;

    // Идентификатор канала
    private static String CHANNEL_ID = "Cat channel";

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent notificationIntent = new Intent(MainActivity.this, MainActivity.class);
                PendingIntent contentIntent = PendingIntent.getActivity(MainActivity.this,
                        0, notificationIntent,
                        PendingIntent.FLAG_CANCEL_CURRENT);



                NotificationCompat.Builder builder =
                        new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                                .setSmallIcon(R.drawable.ic_baseline_pets_24)
                                .setContentTitle("Напоминание")
                                .setContentText("Пора покормить кота")
                                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                                .setContentIntent(contentIntent)
                                .setAutoCancel(true);


                createChannelIfNeeded(notificationManager);
                notificationManager.notify(counter++, builder.build());
            }
        });

        Button webButton = findViewById(R.id.webButton);
        webButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String link = "http://developer.alexanderklimov.ru/android/";
                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));

                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, webIntent, 0);

                NotificationCompat.Builder builder =
                        new NotificationCompat.Builder(MainActivity.this, CHANNEL_ID)
                                .setContentTitle("Посетите мой сайт")
                                .setContentText("http://developer.alexanderklimov.ru/android/")
                                .setContentIntent(pendingIntent)
                                .setDefaults(Notification.DEFAULT_SOUND)
                                .setAutoCancel(true)
                                .addAction(R.drawable.ic_baseline_lock_open_24, "Открыть", pendingIntent)
                                .addAction(R.drawable.ic_baseline_refresh_24, "Отказаться", pendingIntent)
                                .addAction(R.drawable.ic_baseline_pets_24, "Другой вариант", pendingIntent)
                                .setSmallIcon(R.mipmap.ic_launcher);

                NotificationManagerCompat notificationManager =
                        NotificationManagerCompat.from(MainActivity.this);
                notificationManager.notify(NOTIFY_ID, builder.build());
            }
        });

        String bigText = "Это я, почтальон Печкин. Принёс для вас посылку. "
                + "Только я вам её не отдам. Потому что у вас документов нету. ";

        Button bigTextButton = findViewById(R.id.bigTextButton);
        bigTextButton.setOnClickListener(view -> {
            NotificationCompat.Builder builder =
                    new NotificationCompat.Builder(MainActivity.this, CHANNEL_ID)
                            .setSmallIcon(R.drawable.ic_baseline_pets_24)
                            .setContentTitle("Посылка")
                            .setContentText("Это я, почтальон Печкин. Принес для вас посылку")
                            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                            .setStyle(new NotificationCompat.BigTextStyle().bigText(bigText))
                            .setAutoCancel(true);

            notificationManager.notify(NOTIFY_ID + 1, builder.build());
        });

        Intent notificationIntent = new Intent(MainActivity.this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,
                0, notificationIntent,
                PendingIntent.FLAG_CANCEL_CURRENT);

        Button bigPictureButton = findViewById(R.id.bigPictureButton);
        bigPictureButton.setOnClickListener(view -> {
            NotificationCompat.Builder builder =
                    new NotificationCompat.Builder(MainActivity.this, CHANNEL_ID)
                            .setSmallIcon(R.drawable.ic_baseline_pets_24)
                            .setContentTitle("Посылка")
                            .setContentText("Это я, почтальон Печкин. Принёс для вас посылку")
                            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                            .setContentIntent(pendingIntent)
                            .setLargeIcon(BitmapFactory.decodeResource(getResources(),
                                    R.drawable.cat)) // большая картинка
                            .addAction(R.drawable.ic_baseline_pets_24, "Запустить активность",
                                    pendingIntent)
                            // большая картинка из ресурсов
                            .setStyle(new NotificationCompat.BigPictureStyle()
                                    .bigPicture(BitmapFactory.decodeResource(getResources(),
                                            R.drawable.cat)))
                            .setAutoCancel(true); // автоматически закрыть уведомление после нажатия

            notificationManager.notify(NOTIFY_ID, builder.build());
        });

        Button messengerButton = findViewById(R.id.messengerButton);
        messengerButton.setOnClickListener(view -> {

            Person murzik = new Person.Builder().setName("Мурзик").build();
            Person vaska = new Person.Builder().setName("Васька").build();

            NotificationCompat.MessagingStyle messagingStyle = new NotificationCompat.MessagingStyle
                    (murzik)
                    .setConversationTitle("Android chat")
                    .addMessage("Привет котаны!", System.currentTimeMillis(), murzik)
                    .addMessage("А вы знали, что chat по-французски кошка?", System
                                    .currentTimeMillis(),
                            murzik)
                    .addMessage("Круто!", System.currentTimeMillis(),
                            vaska)
                    .addMessage("Ми-ми-ми", System.currentTimeMillis(), vaska)
                    .addMessage("Мурзик, откуда ты знаешь французский?", System.currentTimeMillis(),
                            vaska)
                    .addMessage("Шерше ля фам, т.е. ищите кошечку!", System.currentTimeMillis(),
                            murzik);

            NotificationCompat.Builder builder =
                    new NotificationCompat.Builder(MainActivity.this, CHANNEL_ID)
                            .setSmallIcon(R.drawable.ic_baseline_pets_24)
                            .setContentIntent(pendingIntent)
                            .addAction(R.drawable.ic_baseline_pets_24, "Запустить активность",
                                    pendingIntent)
                            .setStyle(messagingStyle)
                            .setPriority(Notification.PRIORITY_HIGH)
                            .setAutoCancel(true); // автоматически закрыть уведомление после нажатия

            notificationManager.notify(NOTIFY_ID, builder.build());
        });



    }

    public static void createChannelIfNeeded(NotificationManager manager) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_ID, NotificationManager.IMPORTANCE_DEFAULT);
            manager.createNotificationChannel(notificationChannel);
        }
    }
}