package com.example.sixthlabsecondpart;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int CHOOSE_THIEF = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button choiceButton = findViewById(R.id.choiсeButton);

        choiceButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivityForResult(intent, CHOOSE_THIEF);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        TextView resultTextView = findViewById(R.id.resultTextView);

        if(requestCode == CHOOSE_THIEF){
            if(resultCode == RESULT_OK){
                resultTextView.setText(data.getStringExtra(SecondActivity.THIEF));
            }
        }
        else{
            resultTextView.setText("");
        }
    }
}