package com.example.mobilediagnosticapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
    TextView splashtext;
    com.airbnb.lottie.LottieAnimationView splash_anime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_splash);
        splash_anime=findViewById(R.id.splash_anime);
        splashtext=findViewById(R.id.splashtext);
        splashtext.animate().translationY(-1200).setDuration(2000).setStartDelay(0);
        splash_anime.animate().translationX(550).setDuration(400).setStartDelay(4000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent iHome=new Intent(SplashActivity.this,MainActivity.class);
                startActivity(iHome);
                finish();
            }
        },5000);
    }
}