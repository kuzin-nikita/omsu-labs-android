package com.example.hellokitty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ConstraintLayout mConstraintLayout ;
    private TextView         mInfoTextView     ;
    private Button           mRedButton        ;
    private Button           mGreenButton      ;
    private Button           mYellowButton     ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mConstraintLayout = findViewById(R.id.root_layout);
        mInfoTextView     = findViewById(R.id.textView_color);
        mRedButton        = findViewById(R.id.button_red);
        mGreenButton      = findViewById(R.id.button_green);
        mYellowButton     = findViewById(R.id.button_yellow);

        mRedButton.setOnClickListener(this);
        mGreenButton.setOnClickListener(this);
        mYellowButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_red : {
                mInfoTextView.setText(R.string.red);
                mConstraintLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.redColor));
                break;
            }
            case R.id.button_green : {
                mInfoTextView.setText(R.string.green);
                mConstraintLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.greenColor));
                break;

            }
            case R.id.button_yellow : {
                mInfoTextView.setText(R.string.yellow);
                mConstraintLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.yellowColor));
                break;

            }
        }
    }
}