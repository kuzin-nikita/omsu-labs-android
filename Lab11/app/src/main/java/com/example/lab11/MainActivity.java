package com.example.lab11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        TextView textView = findViewById(R.id.textView);
        switch (item.getItemId()){
            case R.id.action_cat1:
                textView.setText("Вы выбрали кота");
                return true;
            case R.id.action_cat2:
                textView.setText("Вы выбрали барсика");
                return true;
            case R.id.action_cat3:
                textView.setText("Вы выбрали котенка");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onSettingsMenuClick(MenuItem item){
        TextView textView = findViewById(R.id.textView);
        textView.setText("Вы нажали на Settings.");
    }
}