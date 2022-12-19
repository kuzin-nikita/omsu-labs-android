package com.example.lab26;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button settingsButton = findViewById(R.id.settingsButton);
        settingsButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, MyPreferenceActivity.class);
            startActivity(intent);
        });

        Button ringtoneButton = findViewById(R.id.ringtone_button);
        ringtoneButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, RingtonePreferenceActivity.class);
            startActivity(intent);
        });

    }

    public void onClick(View v){
        Intent intent = new Intent(MainActivity.this, MyPreferenceActivity.class);
        startActivity(intent);
    }


}