package com.moringaschool.covidinformer.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.moringaschool.covidinformer.R;

public class CovidStats extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid_stats);

        Intent intent = getIntent();
        String country =  intent.getStringExtra("country");
    }
}