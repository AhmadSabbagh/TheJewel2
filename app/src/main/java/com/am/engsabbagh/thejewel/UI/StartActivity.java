
package com.am.engsabbagh.thejewel.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.am.engsabbagh.thejewel.HelperClass.AttolSharedPreference;
import com.am.engsabbagh.thejewel.R;

public class StartActivity extends AppCompatActivity {
    AttolSharedPreference attolSharedPreference=new AttolSharedPreference(this);
    String LanguageSaved="";

    /*  Duration of  Waiting  */
    private final int SPLASH_DISPLAY_LENGTH = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
               Intent mainIntent = new Intent(StartActivity.this, LanguageOptionAvtivity.class);
                StartActivity.this.startActivity(mainIntent);
                StartActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);

        //---------------------Test if Language is already Saved------------------------------------

    } // end onCreate Activity
    }  //end Class
