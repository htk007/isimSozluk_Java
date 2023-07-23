package com.heka.isimsozlukapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.heka.isimsozlukapp.R;


public class SplashScreenActivity extends AppCompatActivity {
    // Süre (milisaniye cinsinden) - Splash ekranın ne kadar süre gösterileceğini belirler.
    private static final int SPLASH_DURATION = 5000; // 3000 milisaniye (3 saniye)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // Belirtilen süre sonunda ana uygulamayı başlatma
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(mainIntent);
                finish();
            }
        }, SPLASH_DURATION);
    }
}
