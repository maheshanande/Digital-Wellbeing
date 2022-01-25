package com.example.digital_wellbeing;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HealthFitness extends AppCompatActivity {
    EditText height,weight;
    RadioButton male,female;
    Button check;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.healthfitness);
        height = findViewById(R.id.heightval);
        weight = findViewById(R.id.weightval);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        check = findViewById(R.id.check);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getheight = height.getText().toString();
                String getweight = weight.getText().toString();
                float height = Integer.parseInt(getheight);
                float weight = Integer.parseInt(getweight);
                float heightinM= height/100;
                float Bmi = (weight/((heightinM)*(heightinM)));
                if(male.isChecked()){
                    if(Bmi <= 18.5){
                        Toast.makeText(getApplicationContext(), "Your Underweight :("+Bmi, Toast.LENGTH_SHORT).show();

                    }
                    else if(Bmi >=25){
                        Toast.makeText(getApplicationContext(), "Your OverWeight :( "+Bmi, Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Your Normal Weight :("+Bmi, Toast.LENGTH_SHORT).show();
                    }
                }
                if(female.isChecked()){
                    if(Bmi <= 16.5){
                        Toast.makeText(getApplicationContext(), "Your Underweight :("+Bmi, Toast.LENGTH_SHORT).show();

                    }
                    else if(Bmi >=22){
                        Toast.makeText(getApplicationContext(), "Your OverWeight :( "+Bmi, Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Your Normal Weight :("+Bmi, Toast.LENGTH_SHORT).show();
                    }
                }



            }
        });

    }
}
