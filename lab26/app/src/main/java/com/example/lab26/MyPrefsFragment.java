package com.example.lab26;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceFragment;

public class MyPrefsFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);

        updateListPrefSummary();
    }

    @Override
    public void onResume() {
        super.onResume();
        getPreferenceScreen().getSharedPreferences()
                .registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        getPreferenceScreen().getSharedPreferences()
                .unregisterOnSharedPreferenceChangeListener(this);
    }

    // Apply for ListPreference with key="pref_style"
    private void updateListPrefSummary() {
        ListPreference preference = (ListPreference) findPreference("pref_style");
        CharSequence entry = ((ListPreference) preference).getEntry();
        preference.setSummary("Текущая настройка: " + entry);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences,
                                          String key) {

        // if changed SharedPreference is ListPreference with key="pref_style",
        // update summary
        if (key.equals("pref_style")) {
            updateListPrefSummary();
        }
    }
}
