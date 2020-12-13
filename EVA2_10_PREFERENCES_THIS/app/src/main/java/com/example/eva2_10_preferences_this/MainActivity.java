package com.example.eva2_10_preferences_this;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.preference.PreferenceManager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import java.util.prefs.Preferences;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.settings, new SettingsFragment());
        fragmentTransaction.commit();

        SharedPreferences spreferences = PreferenceManager.getDefaultSharedPreferences(this);
        Toast.makeText(this, "hey"+spreferences.getString("dia_semana","Nada"), Toast.LENGTH_SHORT).show();
    }
}