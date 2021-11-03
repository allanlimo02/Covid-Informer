package com.moringaschool.covidinformer.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.moringaschool.covidinformer.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CovidSearch extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.searchEditText) EditText mSearchEditText;
    @BindView(R.id.searchButton) Button mSearchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid_search);

        ButterKnife.bind(this);
        mSearchButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == mSearchButton) {
            String country = mSearchEditText.getText().toString();
            if (country.equals("")) {
                mSearchEditText.setError("Search input cannot be empty");
            }
            else {
                Intent intent = new Intent(CovidSearch.this, CovidStats.class);
                intent.putExtra("country", country);
                startActivity(intent);
            }
        }
    }
}