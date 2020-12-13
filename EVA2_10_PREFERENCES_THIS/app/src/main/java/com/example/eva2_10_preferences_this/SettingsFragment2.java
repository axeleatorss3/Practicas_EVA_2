package com.example.eva2_10_preferences_this;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

public class SettingsFragment2 extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.otras_opciones, rootKey);
    }
}