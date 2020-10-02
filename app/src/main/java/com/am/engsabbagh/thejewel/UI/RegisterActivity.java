package com.am.engsabbagh.thejewel.UI;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.am.engsabbagh.thejewel.HelperClass.Message;
import com.am.engsabbagh.thejewel.Pogo.Webservice;
import com.am.engsabbagh.thejewel.R;
import com.google.android.material.textfield.TextInputEditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.edittxt_username)
    TextInputEditText username;
    @BindView(R.id.edittext_password)
    TextInputEditText password;
    @BindView(R.id.confirmpassword)
    TextInputEditText confirmpassword;
    @BindView(R.id.email)
    TextInputEditText email;
    @BindView(R.id.phonenumber)
    TextInputEditText phonenumber;
    @BindView(R.id.city)
    TextInputEditText city;
    @BindView(R.id.address)
    TextInputEditText address;
    @BindView(R.id.button)
    Button Reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        Reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Validate();
            }
        });
    }
    private void Validate ()
    {
        String user_name=username.getText().toString();
        String password_=password.getText().toString();
        String confirm_password=confirmpassword.getText().toString();
        String email_=email.getText().toString();
        String phone_number=phonenumber.getText().toString();
        String city_=city.getText().toString();
        String adress_=address.getText().toString();
        if(user_name.isEmpty())
        {
            username.setError("Can not be empity");
        }
        else if (password_.isEmpty())
        {
            password.setError("Can not be empity");
        }
        else if (confirm_password.isEmpty())
        {
            confirmpassword.setError("Can not be empity");
        }
        else if (phone_number.isEmpty())
        {
            phonenumber.setError("Can not be empity");
        }
        else if (email_.isEmpty())
        {
            email.setError("Can not be empity");
        }
        else if (city_.isEmpty())
        {
            city.setError("Can not be empity");
        }
        else if (adress_.isEmpty())
        {
            address.setError("Can not be empity");
        }
        else if (!email_.contains("@"))

        {
            email.setError("Enter Valid Email");
        }
        else if (password_.length()<8)
        {
            password.setError("pasword should be at least 8 char");
        }
        else if (!password_.equals(confirm_password))
        {
            Message m = new Message("Passwords don't match",this);
        }
       else
        {
            Webservice webservice= new Webservice();
            webservice.Register(this,user_name,password_,email_,phone_number,city_,adress_);
        }

    }
}