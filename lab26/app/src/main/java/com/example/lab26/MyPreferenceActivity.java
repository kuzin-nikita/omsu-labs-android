package com.example.lab26;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceActivity;

public class MyPreferenceActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);
        //поменять цвет бэкграунда
        findViewById(android.R.id.list).setBackgroundColor(Color.MAGENTA);
    }

    public void showSettings()
    {
        Intent intent = new Intent(this, MyPreferenceActivity.class);
        startActivity(intent);
    }


}
