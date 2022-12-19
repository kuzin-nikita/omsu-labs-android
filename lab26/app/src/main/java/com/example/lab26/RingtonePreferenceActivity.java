package com.example.lab26;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;

public class RingtonePreferenceActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.ringtone_preference);
    }

    public void showSettings()
    {
        Intent intent = new Intent(this, RingtonePreferenceActivity.class);
        startActivity(intent);
    }
}
