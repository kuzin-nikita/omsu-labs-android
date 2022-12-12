package com.example.lab9;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button showToastButton = findViewById(R.id.showToastButton);
        showToastButton.setOnClickListener(view -> {
            Toast toast = Toast.makeText(getApplicationContext(), "Пора покормить кота!", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP, 0, 0);

            LinearLayout toastContainer = (LinearLayout) toast.getView();
            //toastContainer.setBackgroundColor(Color.TRANSPARENT);
            ImageView catImageView = new ImageView(getApplicationContext());
            catImageView.setImageResource(R.drawable.cat);

            toastContainer.addView(catImageView, 0);
            toast.show();
        });


        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(view -> {
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.custom_toast,
                    (ViewGroup) findViewById(R.id.custom_toast_container));

            Toast toast = new Toast(getApplicationContext());
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setView(layout);
            toast.show();
        });
    }
}