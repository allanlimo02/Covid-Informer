package com.moringaschool.covidinformer.UI;

import static com.moringaschool.covidinformer.Constant.COUNTRY_ACTIVE;
import static com.moringaschool.covidinformer.Constant.COUNTRY_CONFIRMED;
import static com.moringaschool.covidinformer.Constant.COUNTRY_DECEASED;
import static com.moringaschool.covidinformer.Constant.COUNTRY_NAME;
import static com.moringaschool.covidinformer.Constant.COUNTRY_NEW_CONFIRMED;
import static com.moringaschool.covidinformer.Constant.COUNTRY_NEW_DECEASED;
import static com.moringaschool.covidinformer.Constant.COUNTRY_RECOVERED;
import static com.moringaschool.covidinformer.Constant.COUNTRY_TESTS;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.moringaschool.covidinformer.R;

import java.text.NumberFormat;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StatsData extends AppCompatActivity{

    private TextView tv_confirmed, tv_confirmed_new, tv_active, tv_active_new, tv_death, tv_death_new,
            tv_recovered, tv_recovered_new, tv_tests;

    Button countryName;

    private String str_countryName, str_confirmed, str_confirmed_new, str_active, str_active_new, str_death, str_death_new,
            str_recovered, str_recovered_new, str_tests;
    private MainActivity activity = new MainActivity();
    ImageView back,info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats_data);

        back = findViewById(R.id.backImageView);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(StatsData.this, CovidStats.class);
                startActivity(i);
                finish();

            }
        });

        GetIntent();

        Init();

        LoadCountryData();
    }

    private void Init() {
        countryName=findViewById(R.id.countryButton);
        tv_confirmed = findViewById(R.id.confirmedNumbers);
        tv_active = findViewById(R.id.activeNumbers);
        tv_recovered = findViewById(R.id.recoveredNumbers);
        tv_death = findViewById(R.id.deathNumbers);
    }

    private void LoadCountryData() {

        Handler postDelayToshowProgress = new Handler();
        postDelayToshowProgress.postDelayed(new Runnable() {
            @Override
            public void run() {
                countryName.setText(str_countryName);
                tv_confirmed.setText(NumberFormat.getInstance().format(Integer.parseInt(str_confirmed)));
                tv_active.setText(NumberFormat.getInstance().format(Integer.parseInt(str_active)));
                tv_death.setText(NumberFormat.getInstance().format(Integer.parseInt(str_death)));
                tv_recovered.setText(NumberFormat.getInstance().format(Integer.parseInt(str_recovered)));
            }
        },1000);

    }

    private void GetIntent() {
        Intent intent = getIntent();
        str_countryName = intent.getStringExtra(COUNTRY_NAME);
        str_confirmed = intent.getStringExtra(COUNTRY_CONFIRMED);
        str_active = intent.getStringExtra(COUNTRY_ACTIVE);
        str_death = intent.getStringExtra(COUNTRY_DECEASED);
        str_recovered = intent.getStringExtra(COUNTRY_RECOVERED);
        str_confirmed_new = intent.getStringExtra(COUNTRY_NEW_CONFIRMED);
        str_death_new = intent.getStringExtra(COUNTRY_NEW_DECEASED);
        str_tests = intent.getStringExtra(COUNTRY_TESTS);
    }
}