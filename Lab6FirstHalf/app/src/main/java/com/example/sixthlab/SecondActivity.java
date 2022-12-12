package com.example.sixthlab;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView secondActivityTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String user = "User";
        String gift = "gift";

        user = getIntent().getExtras().getString("user");
        gift = getIntent().getExtras().getString("gift");

        secondActivityTextView = findViewById(R.id.secondActivityTextView);
        secondActivityTextView.setText(user + ", вам передали " + gift);

    }
}
