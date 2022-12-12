package com.example.lab7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.Surface;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static final String ORIENTATION_PORTRAIT = "Портретный режим";
    static final String ORIENTATION_LANDSCAPE = "Альбомный режим";

    // определяем изменение ориентации экрана
    boolean mState = false;
    private int crowCounter = 0;

    private static final String KEY_CROW_COUNT = "CROW_COUNT";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.editText);

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(view -> {
            switch (getResources().getConfiguration().orientation) {
                case Configuration.ORIENTATION_PORTRAIT:
                    editText.setText("Портретная ориентация");
                    break;
                case Configuration.ORIENTATION_LANDSCAPE:
                    editText.setText("Альбомная ориентация");
                    break;
                default:
                    editText.setText("");
                    break;
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(view -> {
            Display display = getWindowManager().getDefaultDisplay();
            Point point = new Point();
            display.getSize(point);
            int screenWidth = point.x;
            int screenHeight = point.y;

            boolean isLandscape = screenWidth > screenHeight;

            editText.setText("isLandscapeMode - " + isLandscape);
        });

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(view -> {
            int rotate = getWindowManager().getDefaultDisplay().getRotation();
            switch (rotate) {
                case Surface.ROTATION_0:
                    editText.setText("Не поворачивали");
                    break;
                case Surface.ROTATION_90:
                    editText.setText("Повернули на 90 градусов по часовой стрелке");
                    break;
                case Surface.ROTATION_180:
                    editText.setText("Повернули на 180 градусов");
                    break;
                case Surface.ROTATION_270:
                    editText.setText("Повернули на 90 градусов против часовой стрелки");
                    break;
                default:
                    editText.setText("Не понятно");
                    break;
            }
        });

        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        Button button4 = findViewById(R.id.button4);
        button4.setText(ORIENTATION_LANDSCAPE);
        button4.setOnClickListener(view -> {
            if (!mState) {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                button4.setText(ORIENTATION_PORTRAIT);
            }
            // state TRUE: переключаемся на PORTRAIT
            else {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                button4.setText(ORIENTATION_LANDSCAPE);
            }
            // обновляем state на противоположное значение
            mState = !mState;
        });

        Button button5  = findViewById(R.id.button5);
        button5.setOnClickListener(view -> {
            /*if(savedInstanceState != null){
                crowCounter = savedInstanceState.getInt(KEY_CROW_COUNT, 0);
                editText.setText("я насчитал " + crowCounter + " ворон");
                return;
            }*/
            editText.setText("я насчитал " + crowCounter++ + " ворон");
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_CROW_COUNT, crowCounter);
    }
}