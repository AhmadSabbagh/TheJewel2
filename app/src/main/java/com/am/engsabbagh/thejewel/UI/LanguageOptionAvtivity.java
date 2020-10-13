package com.am.engsabbagh.thejewel.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.widgets.Helper;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.am.engsabbagh.thejewel.HelperClass.AttolSharedPreference;
import com.am.engsabbagh.thejewel.R;

import java.util.Locale;

public class LanguageOptionAvtivity extends AppCompatActivity {
    Button SelectLanguage,Arabic,English;
    AttolSharedPreference attolSharedPreference=new AttolSharedPreference(this); // getting this context
    String LanguageLoaded="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_option_avtivity);

        LanguageLoaded=attolSharedPreference.getKey("languageSelected"); // load the language that is saved
        LanguageSaved(); // check language
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
        attolSharedPreference.setKey("languageSelected","en");
        Locale myLocale = new Locale("en");
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, PrivacyPolicy.class);
       finish();
       startActivity(refresh);
        Toast.makeText(this, "English Selected", Toast.LENGTH_SHORT).show();

    }

    //-> set language in locale phone to english
    private void SetLanguageArabic() {
        attolSharedPreference.setKey("languageSelected","ar");
        Locale myLocale = new Locale("ar");
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
       Intent refresh = new Intent(this, PrivacyPolicy.class);
        finish();
        startActivity(refresh);
        Toast.makeText(this, "تم اختيار العربية", Toast.LENGTH_SHORT).show();
    }
    //----------------------------------------------------------------------------------------------
    //-> this method make sure that user is already selected language
    public void LanguageSaved()
    {
        if (LanguageLoaded!=null) {
            if (LanguageLoaded.equals("ar")) {
                SetLanguageArabic(); //  set language of app to be arabic based on shard Preference
                Intent intent = new Intent(LanguageOptionAvtivity.this, PrivacyPolicy.class);
                LanguageOptionAvtivity.this.startActivity(intent);
                Log.i("Language", LanguageLoaded.toString());
            } else if (LanguageLoaded.equals("en")) {
                SetLanguageEnglish(); //  set language of app to be English based on shared preference
                Intent intent = new Intent(LanguageOptionAvtivity.this, PrivacyPolicy.class);
                LanguageOptionAvtivity.this.startActivity(intent);

                Log.i("Language", LanguageLoaded.toString());
            } else {
                Intent intent = new Intent(LanguageOptionAvtivity.this, LanguageOptionAvtivity.class);
                LanguageOptionAvtivity.this.startActivity(intent);
                LanguageOptionAvtivity.this.finish();
                Log.i("Language", LanguageLoaded.toString());
            }
        }

    }
    //----------------------------------------------------------------------------------------------
   }//end Class