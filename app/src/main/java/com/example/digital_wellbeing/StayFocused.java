package com.example.digital_wellbeing;

import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class StayFocused extends AppCompatActivity {
    private ListView mListAppInfo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // set layout for the main screen
        setContentView(R.layout.stay_focused);

        // load list application
        mListAppInfo = findViewById(R.id.lvApps);
        // create new adapter
        AppInfoAdapter adapter = new AppInfoAdapter(this, Utilities.getInstalledApplication(this), getPackageManager());
        // set adapter to list view
        mListAppInfo.setAdapter(adapter);
        // implement event when an item on list view is selected
        mListAppInfo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int pos, long id) {
                // get the list adapter
                AppInfoAdapter appInfoAdapter = (AppInfoAdapter)parent.getAdapter();
                // get selected item on the list
                ApplicationInfo appInfo = (ApplicationInfo)appInfoAdapter.getItem(pos);
                // launch the selected application
                Utilities.launchApp(parent.getContext(), getPackageManager(), appInfo.packageName);
            }
        });


    }
}

