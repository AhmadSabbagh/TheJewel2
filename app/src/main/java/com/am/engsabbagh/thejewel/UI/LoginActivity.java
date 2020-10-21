package com.am.engsabbagh.thejewel.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.am.engsabbagh.thejewel.HelperClass.AttolSharedPreference;
import com.am.engsabbagh.thejewel.Pogo.Webservice;
import com.am.engsabbagh.thejewel.R;

import java.util.Locale;

public class LoginActivity extends AppCompatActivity {
    EditText username;  //username
    EditText password; // password
    Button login_btn;   //login button
    CheckBox rememberMe;
    Button forgetbutton,register;
AttolSharedPreference attolSharedPreference=new AttolSharedPreference(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username=(EditText)findViewById(R.id.editTextTextPersonName) ;
        password=(EditText)findViewById(R.id.edittext_password);
        login_btn=(Button)findViewById(R.id.login); // button login
        rememberMe=(CheckBox)findViewById(R.id.remembermecheckbox);  // getting checkbox
        forgetbutton=(Button)findViewById(R.id.forgetbutton);
        register=(Button)findViewById(R.id.register); // go to register activity
        LoadLoginData(); //  check if there is already username and password saved
        //------------------------------------------------------------------------------------------
        //-> Go to Register Activity
        /*
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegisterActivity.this,ForgetPassword.class);
                RegisterActivity.this.startActivity(intent);
                RegisterActivity.this.finish();
            }
        });
        */
        //------------------------------------------------------------------------------------------
        //-> Go to  Forget Password
        login_btn.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
                login();
           //setLocale("ar");  //just for trying tost different language
                Toast.makeText(LoginActivity.this, "Button is Pressed", Toast.LENGTH_SHORT).show();
            }
        });
        //------------------------------------------------------------------------------------------
        rememberMe.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true) {
                    SaveLoginData();   //save data to attol shared
                }
            }
        });
        //------------------------------------------------------------------------------------------
        //-> go to forgetpasswordactivity
        forgetbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,ForgetPassword.class);
                LoginActivity.this.startActivity(intent);
                LoginActivity.this.finish();
            }
        });
    }  //end onCreate
    //----------------------------------------------------------------------------------------------

    private void login() {
        String username_;
        String password_;
        username_=username.getText().toString();//getting input text from user
        password_=password.getText().toString(); // getting input password from user

        if (username_.isEmpty())
        {
            Toast.makeText(this, "Please Enter Your Username", Toast.LENGTH_SHORT).show();
        }
        else if (password_.isEmpty())
        {
            Toast.makeText(this, "Please Enter Your Password", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Webservice webservice=new Webservice();
            webservice.Login(this,username_,password_);  // send it to webservice activity

        }

    }
//--------------------------------------------------------------------------------------------------
    //-> Save Data for login in Attol Shared Preference
private void SaveLoginData() {
    String username_;
    String password_;
    username_=username.getText().toString();//getting input text from user
    password_=password.getText().toString(); // getting input password from user
        attolSharedPreference.setKey("usernameLogin",username_);
        attolSharedPreference.setKey("passwordLogin",password_);
    Toast.makeText(this, username.getText().toString(), Toast.LENGTH_SHORT).show();
}

//--------------------------------------------------------------------------------------------------
  private void LoadLoginData()
  {
      String UsernameLoaded="";
      String PasswordLoaded="";
      UsernameLoaded=attolSharedPreference.getKey("usernameLogin");
      PasswordLoaded=attolSharedPreference.getKey("passwordLogin");
      if (UsernameLoaded !=null && PasswordLoaded !=null)
      {
       rememberMe.setChecked(true);
       username.setText(UsernameLoaded);
       password.setText(PasswordLoaded);
      }
  }

    //----------------------------------------------------------------------------------------------
} //end class

