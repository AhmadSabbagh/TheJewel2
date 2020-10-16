package com.am.engsabbagh.thejewel.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.am.engsabbagh.thejewel.HelperClass.AttolSharedPreference;
import com.am.engsabbagh.thejewel.R;

public class CountryChooser extends AppCompatActivity {
    AttolSharedPreference attolSharedPreference=new AttolSharedPreference(this);
    Button uae,SaudiArabic;
    String CountrySelectionState="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_chooser);
        Country(); // check if country already selected
        uae=(Button)findViewById(R.id.uae);  // uae country selection
        SaudiArabic=(Button)findViewById(R.id.saudiarabia); //  saudiarabic country selection
        uae.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attolSharedPreference.setKey("Country","UAE");  //saving to phone uae
                Intent intent=new Intent(CountryChooser.this,LoginActivity.class);
                CountryChooser.this.startActivity(intent);
                CountryChooser.this.finish();
            }
        }); //end uae selection
        SaudiArabic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attolSharedPreference.setKey("Country","SaudiArabic"); // saving to phone saudi arabic
                Intent intent=new Intent(CountryChooser.this,LoginActivity.class);
                CountryChooser.this.startActivity(intent);
                CountryChooser.this.finish();
            }
        });//end saudi arabic button
    }// end onCreate Method
    //----------------------------------------------------------------------------------------------
    //-> Country Selection Check
    /*
    if country is selected go then to login activity
    else display country selection
    */
    public void Country() {
        CountrySelectionState = attolSharedPreference.getKey("Country");
        if (CountrySelectionState != null) {
            if (CountrySelectionState.equals("UAE")) {
                Intent intent = new Intent(this, LoginActivity.class); // the user is already accepted privacy policy
                this.startActivity(intent);
                this.finish();
            }
            if (CountrySelectionState.equals("SaudiArabic")) {
                Intent intent = new Intent(this, LoginActivity.class); // the user is already accepted privacy policy
                this.startActivity(intent);
                this.finish();
            }
        }
    }
//--------------------------------------------------------------------------------------------------
}//end class
