package com.example.hellokitty;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button   mRavenCounterButton;
    private int      mRavenCounter;
    private TextView mInfoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRavenCounter       = 0;
        mInfoTextView = findViewById(R.id.info_counter_raven);
        mRavenCounterButton = findViewById(R.id.button_counter);

        mRavenCounterButton.setOnClickListener(
                view -> mInfoTextView.setText("Я насчитал: " + ++mRavenCounter)
        );
    }

    public void onClick(View view) {
        TextView helloTextView = findViewById(R.id.textView);
        helloTextView.setText("Hello Kitty!");
    }
}