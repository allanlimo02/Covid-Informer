package com.moringaschool.covidinformer.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.moringaschool.covidinformer.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth.AuthStateListener mAuthListener;

    @BindView(R.id.buttonCall) Button mButtonCall;
    @BindView(R.id.buttonText) Button mButtonText;
    @BindView(R.id.buttonStats) Button mButtonStats;
    @BindView(R.id.imageViewTest) ImageView mImageViewTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mButtonCall.setOnClickListener(this);
        mButtonText.setOnClickListener(this);
        mButtonStats.setOnClickListener(this);
        mImageViewTest.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void logout() {
        FirebaseAuth.getInstance().signOut();

        Intent intent = new Intent(MainActivity.this, LogIn.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.logout) {
            logout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View view) {
        if (view == mButtonCall) {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:+254-202-717-077"));
            startActivity(intent);
        }

        if (view == mButtonStats) {
            Intent intent = new Intent(MainActivity.this, CovidStats.class);
            startActivity(intent);
        }

        if (view == mButtonText) {
            String mobileNumber = "+254-20-2717077";
            String message = "Hi! I'm experiencing covid symptoms.Thank you!";
            boolean installed = appInstalledOrNot("com.whatsapp");

            if (installed) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://api.whatsapp.com/send?phone=" + mobileNumber + "&text=" + message));
                startActivity(intent);
            }

            else if (!installed) {
                Toast.makeText(MainActivity.this, "Whatsapp not installed on your device", Toast.LENGTH_SHORT).show();
            }
        }

        if (view == mImageViewTest) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.cdc.gov/coronavirus/2019-ncov/testing/self-testing.html"));
            startActivity(intent);
        }
    }

    private boolean appInstalledOrNot(String url) {
        PackageManager packageManager = getPackageManager();
        boolean app_installed;
        try {
            packageManager.getPackageInfo(url,PackageManager.GET_ACTIVITIES);
            app_installed = true;
        }
        catch (PackageManager.NameNotFoundException e){
            app_installed = false;
        }
        return app_installed;
    }
}

