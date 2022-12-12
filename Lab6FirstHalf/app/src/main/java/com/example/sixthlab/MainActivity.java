package com.example.sixthlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button aboutButton;


    Button sendButton;

    EditText editAddress;

    EditText editGift;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aboutButton = findViewById(R.id.aboutButton);
        aboutButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
        });

        editAddress = findViewById(R.id.edit_address);
        editGift = findViewById(R.id.edit_gift);


        sendButton = findViewById(R.id.sendButton);
        sendButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("user", editAddress.getText().toString());
            intent.putExtra("gift", editGift.getText().toString());
            startActivity(intent);
        });




    }
}