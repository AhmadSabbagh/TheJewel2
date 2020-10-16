package com.am.engsabbagh.thejewel.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.am.engsabbagh.thejewel.HelperClass.AttolSharedPreference;
import com.am.engsabbagh.thejewel.R;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PrivacyPolicy extends AppCompatActivity {
    AttolSharedPreference attolSharedPreference=new AttolSharedPreference(this);
    CheckBox checkBox;
    String PrivacyPolicyState="";
    String Language="";
    TextView PrivacyPolicyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);
        PrivacyPolicyTextView=(TextView)findViewById(R.id.privacy_policy_text);
        checkBox=(CheckBox)findViewById(R.id.checkboxagree);
        PrivacyPolicyState=attolSharedPreference.getKey("PrivacyPolicy");
        Language=attolSharedPreference.getKey("languageSelected");
        try
        {
            ReadTextFile();
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        PrivacyPolicy();
    checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            //-> If the user agree the privacy policy of app we must go to select country
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked==true)
                {
                    attolSharedPreference.setKey("PrivacyPolicy","Accepted"); // save this to phone
                    Intent intent=new Intent(PrivacyPolicy.this, CountryChooser.class); // go to country chooser
                    PrivacyPolicy.this.startActivity(intent);
                    PrivacyPolicy.this.finish();// finish this activity
                }
            }
        });// end checkbox listner
    }//end onCreate
//--------------------------Reading Privacy Policy--------------------------------------------------
           public void ReadTextFile() throws IOException {
            String string = "";
            StringBuilder stringBuilder = new StringBuilder();
            InputStream is;
           // if (Language!=null) {
                if (Language.equals("ar")) {
                    is = this.getResources().openRawResource(R.raw.privacypolicy_ar);
                } else {
                    is = this.getResources().openRawResource(R.raw.privacypolicy_en);
                }
        //    }//end if null
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            while (true) {
                try {
                    if ((string = reader.readLine()) == null) break;
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                stringBuilder.append(string).append("\n");
                PrivacyPolicyTextView.setText(stringBuilder);
            }
            is.close();
        }
       //----------------------------------------------------------------------------------------------
    //-> PrivacyPolicyState Check
    public void PrivacyPolicy() {
        if (PrivacyPolicyState != null) {
       if (PrivacyPolicyState.equals("Accepted")) {
                Intent intent = new Intent(this, CountryChooser.class); // the user is already accepted privacy policy
                this.startActivity(intent);
                this.finish();
            }
        }
    }  //----------------------------------------------------------------------------------------------
}// end Class