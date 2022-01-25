package com.example.digital_wellbeing;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.digital_wellbeing.settings.SettingsFragment;

public class SettingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        settingDisp();

    }
    public void settingDisp(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        SettingsFragment settingsFrag = new SettingsFragment();
        fragmentTransaction.replace(android.R.id.content, settingsFrag);
        fragmentTransaction.commit();
    }

}
