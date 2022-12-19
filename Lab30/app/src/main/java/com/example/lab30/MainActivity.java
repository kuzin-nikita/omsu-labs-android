package com.example.lab30;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    public static final String WHERE_MY_CAT_ACTION = "com.example.lab30.CAT";
    public static final String ALARM_MESSAGE = "Срочно пришлите кота!";
    private TimeBroadcastReceiver mTimeBroadCastReceiver = new TimeBroadcastReceiver();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button = findViewById(R.id.button);
        button.setOnClickListener(view -> {
            MessageReceiver messageReceiver = new MessageReceiver();
            this.registerReceiver(messageReceiver, new IntentFilter(
                    "com.example.lab30.CAT"));
            Intent intent = new Intent();
            intent.setAction(WHERE_MY_CAT_ACTION);
            intent.putExtra("com.example.lab30.Message", ALARM_MESSAGE);
            intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
            sendBroadcast(intent);
        });
    }

    // регистрируем широковещательный приёмник
    // для намерения "android.intent.action.TIME_TICK".
    // Данное намерение срабатывает каждую минуту
    public void registerBroadcastReceiver(View view) {
        this.registerReceiver(mTimeBroadCastReceiver, new IntentFilter(
                "android.intent.action.TIME_TICK"));
        Toast.makeText(getApplicationContext(), "Приёмник включен",
                Toast.LENGTH_SHORT).show();
    }

    // Отменяем регистрацию
    public void unregisterBroadcastReceiver(View view) {
        this.unregisterReceiver(mTimeBroadCastReceiver);
        Toast.makeText(getApplicationContext(), "Приёмник выключён", Toast.LENGTH_SHORT)
                .show();
    }
}