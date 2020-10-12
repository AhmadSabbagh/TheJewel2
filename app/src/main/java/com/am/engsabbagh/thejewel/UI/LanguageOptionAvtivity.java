package com.am.engsabbagh.thejewel.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.widgets.Helper;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.am.engsabbagh.thejewel.HelperClass.AttolSharedPreference;
import com.am.engsabbagh.thejewel.R;

import java.util.Locale;

public class LanguageOptionAvtivity extends AppCompatActivity {
    Button SelectLanguage,Arabic,English;
    AttolSharedPreference attolSharedPreference=new AttolSharedPreference(this); // getting this context


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_option_avtivity);
        SelectLanguage=(Button)findViewById(R.id.selectlanguage); // select language button
        Arabic=(Button)findViewById(R.id.arabic);  //arabic language
        English=(Button)findViewById(R.id.english);  //english language
        Arabic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              SetLanguageArabic();   // save language selected to phome
            }
        }); // end Arabic Selection

        English.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetLanguageEnglish();
            }
        });

    } //end onCreate Method

    //-> Set language english and save it to locale
    private void SetLanguageEnglish() {
        attolSharedPreference.setKey("language","en");
        Locale myLocale = new Locale("en");
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, LanguageOptionAvtivity.class);
        finish();
        startActivity(refresh);
        Toast.makeText(this, "English Selected", Toast.LENGTH_SHORT).show();

    }

    //-> set language in locale phone to english
    private void SetLanguageArabic() {
        attolSharedPreference.setKey("language","ar");
        Locale myLocale = new Locale("ar");
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, LanguageOptionAvtivity.class);
        finish();
        startActivity(refresh);
        Toast.makeText(this, "تم اختيار العربية", Toast.LENGTH_SHORT).show();
    }
   }//end Class