package com.am.engsabbagh.thejewel.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.am.engsabbagh.thejewel.HelperClass.AttolSharedPreference;
import com.am.engsabbagh.thejewel.R;

public class PrivacyPolicy extends AppCompatActivity {
    AttolSharedPreference attolSharedPreference=new AttolSharedPreference(this);
    CheckBox checkBox;
    String PrivacyPolicyState="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);
        PrivacyPolicy();
        checkBox=(CheckBox)findViewById(R.id.checkboxagree);
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
    //----------------------------------------------------------------------------------------------
    //-> PrivacyPolicyState Check
    public void PrivacyPolicy() {
        PrivacyPolicyState=attolSharedPreference.getKey("PrivacyPolicy");
        if (PrivacyPolicyState != null) {
       if (PrivacyPolicyState.equals("Accepted")) {
                Intent intent = new Intent(this, LoginActivity.class); // the user is already accepted privacy policy
                this.startActivity(intent);
                this.finish();
            }
        }
    }  //----------------------------------------------------------------------------------------------
}// end Class