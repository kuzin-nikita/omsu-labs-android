package com.example.lab13;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private float mBackLightValue = 0.5f;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.textView);


        //перейти в настройки
        /*Intent intent = new Intent(Settings.ACTION_DISPLAY_SETTINGS);
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }*/

        //найти ширину и высоту
        /*Display display = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        int screenWidth = point.x;
        int screenHeight = point.y;

        String width = Integer.toString(screenWidth);
        String height = Integer.toString(screenHeight);

        String info = "Ширина: " + width + "; Высота: " + height;

        textView.setText(info);*/

        //найти плотность экрана, масштабирование шрифта и тд
        /*DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        String strScreen = "";
        strScreen += "Width: " + metrics.widthPixels + " pixels"
                + "\n";
        strScreen += "Height: " + metrics.heightPixels + " pixels"
                + "\n";
        strScreen += "The Logical Density: " + metrics.density
                + "\n";
        strScreen += "X Dimension: " + metrics.xdpi + " dot/inch"
                + "\n";
        strScreen += "Y Dimension: " + metrics.ydpi + " dot/inch"
                + "\n";
        strScreen += "The screen density expressed as dots-per-inch: "
                + metrics.densityDpi + "\n";
        strScreen += "A scaling factor for fonts displayed on the display: "
                + metrics.scaledDensity + "\n";

        textView.setText(strScreen);*/

        //текущее значение яркости
        /*Button brightnessButton = findViewById(R.id.brightness_button);
        brightnessButton.setOnClickListener(view -> {
            try {
                int curBrightnessValue = android.provider.Settings.System.getInt(
                        getContentResolver(),
                        android.provider.Settings.System.SCREEN_BRIGHTNESS);
                textView.setText("Текущая яркость экрана: " + curBrightnessValue);
            } catch (Settings.SettingNotFoundException e) {
                e.printStackTrace();
            }
        });*/


        //поменять значение яркости
        SeekBar backLightSeekBar = findViewById(R.id.seekBar);
        Button updateButton = findViewById(R.id.updateButton);
        int brightness = Settings.System.getInt(getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, 0);
        backLightSeekBar.setProgress(brightness);

        textView.setText("Screen Brightness: " + brightness);

        boolean canWrite = Settings.System.canWrite(this);

        if(!canWrite){
            backLightSeekBar.setEnabled(false);
            allowWritePermission();
        }

        updateButton.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View view) {
                int sysBackLightValue = (int) (mBackLightValue * 255);

                android.provider.Settings.System.putInt(getContentResolver(),
                        android.provider.Settings.System.SCREEN_BRIGHTNESS,
                        sysBackLightValue);
            }
        });

        backLightSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView.setText("Screen brightness: " + progress);
                setBrightness(progress);
                WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
                layoutParams.screenBrightness = mBackLightValue;
                getWindow().setAttributes(layoutParams);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void setBrightness(int value){
        Settings.System.putInt(getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, value);
    }

    private void allowWritePermission(){
        Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS, Uri.parse("package:" + getPackageName()));
        startActivity(intent);
    }
}