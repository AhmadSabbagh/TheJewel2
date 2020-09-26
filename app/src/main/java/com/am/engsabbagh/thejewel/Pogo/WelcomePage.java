package com.am.engsabbagh.thejewel.Pogo;
/*
Note: Class Created By Eng. Riyad AL-Ali
Splash Screen will lanuch the app welcome page for 5 seconds and then display the Privacy policy screen

 */
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.am.engsabbagh.thejewel.R;

public class WelcomePage extends AppCompatActivity {

    /*  Duration of  Waiting  */
    private final int SPLASH_DISPLAY_LENGTH = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(WelcomePage.this, RegisterActivity.class);  // go to privacy policy class
                WelcomePage.this.startActivity(mainIntent);
                WelcomePage.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}