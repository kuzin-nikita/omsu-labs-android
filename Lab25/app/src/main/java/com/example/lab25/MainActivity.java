package com.example.lab25;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int crowCounter = 0;
    private SharedPreferences prefs;
    private static final String APP_PREFERENCES_COUNTER = "appCrowCounter";
    Button crowButton;
    TextView crowTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        crowButton = findViewById(R.id.crowButton);
        crowTextView = findViewById(R.id.crowTextView);
        prefs = getSharedPreferences("settings", Context.MODE_PRIVATE);

        crowButton.setOnClickListener(view -> {
            crowTextView.setText("Всего ворон : " + crowCounter++);
        });
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(APP_PREFERENCES_COUNTER, crowCounter).apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        crowCounter = prefs.getInt(APP_PREFERENCES_COUNTER, 0);
        crowTextView.setText("Всего ворон : " + crowCounter);
    }
}