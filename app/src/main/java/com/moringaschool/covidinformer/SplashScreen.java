package com.moringaschool.covidinformer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.moringaschool.covidinformer.UI.CovidStats;
import com.moringaschool.covidinformer.UI.LogIn;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashScreen extends AppCompatActivity {
    @BindView(R.id.splashimage) ImageView splashimage;
    Animation topAnim;
    private static int SPLASH_SCREEN=5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ButterKnife.bind(this);
        setContentView(R.layout.activity_splash_screen);
        topAnim=AnimationUtils.loadAnimation(this,R.anim.top_animation);
        delayer();


    }
    void delayer(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashScreen.this, LogIn.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);
    }
}