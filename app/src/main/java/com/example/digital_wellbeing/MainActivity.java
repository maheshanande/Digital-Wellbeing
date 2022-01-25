package com.example.digital_wellbeing;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.digital_wellbeing.Productivity.productivity;


public class MainActivity extends AppCompatActivity {
    ImageButton btn_activity,btn_focus,btn_productivity,Healthfitness,menu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getSupportActionBar().hide();
        btn_activity = findViewById(R.id.Activity);
        btn_focus = findViewById(R.id.focused);
        btn_productivity = findViewById(R.id.product);
        Healthfitness = findViewById(R.id.health_btn);
        menu = findViewById(R.id.menu_btn);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(MainActivity.this, menu);
                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.main_screen_option_menu, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {

                        switch (item.getItemId()) {

                            case R.id.action_settings:
                                //Launch settings page
                                Intent intent2 = new Intent(MainActivity.this , SettingActivity.class);
                                startActivity(intent2);
                                return true;
                            case R.id.action_about:
                                Intent intent3= new Intent(MainActivity.this , AboutDisp.class);
                                startActivity(intent3);
                                //Launch about page

                                return true;

                        }

                        return true;
                    }
                });

                popup.show();//showing popup menu
            }
        });

        btn_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread = new Thread(() -> {
                    try {
                        Thread.sleep(1);

                    }catch (Exception e){
                        e.printStackTrace();

                    }finally{
                        Intent intent2 = new Intent(MainActivity.this , mainFragment.class);
                        startActivity(intent2);
                    }
                });thread.start();

            }
        });
        btn_focus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread1 = new Thread(() -> {
                    try {
                        Thread.sleep(1);

                    }catch (Exception e){
                        e.printStackTrace();

                    }finally{
                        Intent intent2 = new Intent(MainActivity.this , StayFocused.class);
                        startActivity(intent2);
                    }
                });thread1.start();


            }
        });
        btn_productivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this , productivity.class);
                startActivity(intent2);
            }
        });
        Healthfitness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(MainActivity.this , HealthFitness.class);
                startActivity(intent3);
            }
        });

    }


}