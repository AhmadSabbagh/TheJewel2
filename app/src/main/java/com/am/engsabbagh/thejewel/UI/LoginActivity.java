package com.am.engsabbagh.thejewel.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.am.engsabbagh.thejewel.Pogo.Webservice;
import com.am.engsabbagh.thejewel.R;

public class LoginActivity extends AppCompatActivity {
    EditText username;  //username
    EditText password; // password
    Button login_btn;   //login button




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username=(EditText)findViewById(R.id.edittxt_username);
        password=(EditText)findViewById(R.id.edittext_password);
        login_btn=(Button)findViewById(R.id.login); // button login
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
                Toast.makeText(LoginActivity.this, "Button is Pressed", Toast.LENGTH_SHORT).show();
            }
        });
    }  //

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


}