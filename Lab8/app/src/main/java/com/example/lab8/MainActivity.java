package com.example.lab8;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button dialogButton = findViewById(R.id.dialog_button);
        dialogButton.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AppCompatAlertDialogStyle);
            builder.setTitle("Dialog");
            builder.setMessage("Лада гранта?");
            builder.setNegativeButton("Нет", null);
            builder.setPositiveButton("Да", null);
            builder.show();
        });



        Button aboutButton = findViewById(R.id.aboutButton);
        aboutButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
        });
    }
}