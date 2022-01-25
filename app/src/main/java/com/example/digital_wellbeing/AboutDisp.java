package com.example.digital_wellbeing;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.digital_wellbeing.settings.AboutFragment;

public class AboutDisp extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        AboutFragment abtFrag = new AboutFragment();
        fragmentTransaction.replace(android.R.id.content,abtFrag);
        fragmentTransaction.commit();
    }
}
