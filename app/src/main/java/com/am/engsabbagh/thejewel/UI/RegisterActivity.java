package com.am.engsabbagh.thejewel.UI;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.am.engsabbagh.thejewel.HelperClass.Check_connection;
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
    String photo = "/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDAKBueIx4ZKCMgoy0qqC+8P//8Nzc8P//////////////\n" +
            "////////////////////////////////////////////2wBDAaq0tPDS8P//////////////////\n" +
            "////////////////////////////////////////////////////////////wAARCADIAMgDASIA\n" +
            "AhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQA\n" +
            "AAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3\n" +
            "ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWm\n" +
            "p6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEA\n" +
            "AwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSEx\n" +
            "BhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElK\n" +
            "U1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3\n" +
            "uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwCaiiig\n" +
            "AooooAKKKKACigkAZJxUTTf3R+NAEtNLqOpqBmZuppKYiYzL2BNJ53+zUVFAEnnH0FHnH+7UdFAE\n" +
            "wmHcGnCRT3x9ar0UAWqKqgkdDipFmP8AEM0hk1FIrBhwaWgAooooAKKKKACiiigAooooAKKKKACm\n" +
            "PIF4HJpskvZfzqKgBWYsck0lFFMQUUUUAFFFFABRRRQAUUUUAFFFFAACQcipUl7N+dRUUAWqKgjk\n" +
            "K8HkVODkZFIYUUUUAFFFFABRRRQAVFLJ/CPxp0r7RgdTUFABRRRTEFFFFABRRRQAUUU4Rse2PrQA\n" +
            "2inmJvY0wqR1BFABRRRQAUUUUAFFFFABT432nB6UyigC1RUML/wn8KmpDCiiigAoJwCTRUUzdF/O\n" +
            "gCNiWJJpKKKYgooooAKKKKACgc0VLCvVqAHRxheTyafRRSGFFFFADGiU+xqFlKnBqzSOu5cUAVqK\n" +
            "KKYgooooAKKKKACrEbbl9+9V6fE21/Y0AT0UUUhhVZjuYmp5DhDVemIKKKKACiiigAooooAKnh+5\n" +
            "UFTQ/cP1oAkooopDCiiigAooooArP98/WkpWOWJ96SmIKKKKACiiigAooooAsodyg0VHAeCKKQxZ\n" +
            "zwBUNST/AHh9KjpiCiiigAooooAKKKKACp4gAmfWoKmhb5cdxQBJRRRSGFFFFABRRQSFBJoAqsMM\n" +
            "R70UHk0UxBRRRQAUUUUAFFFFAD4Th/rRSR/fFFIY6f74+n+NR1JP94fSo6YgooooAKKKKACiiigA\n" +
            "p0Rw49+KbRQBaopqNuXPfvTqQwooooAKjmPygetSHgZNVnbc2aAEooopiCiiigAooooAKKKKAFT7\n" +
            "6/UUUJ98fWikMknHQ1FU8wyn0qCmIKKKKACiiigAooooAKKKesbN14FADUYqcirCsGGRSbF27ccV\n" +
            "GY2U5Xn6Uhk1BOBk1B5knT+lG1365/GgAkk3cDp/OmVOsagYPNMeIjleaYiOigjHWigAooooAKKK\n" +
            "KACiiigB0QzIKKdAOSaKQyYjII9aqng4q1UEy4bPrQAyiiimIKKKKAAAk4FSrD/eP5U6Jdq57mn0\n" +
            "hiKir0FLRRQAUUUUAFFFFABRRRQAEA9Rmo2hB+6cVJRQBWZSp5FJVllDDBqsRg4NMQUUUUAFFFKi\n" +
            "7mAoAniGEHvzRTqKQwprruUinUUAVaKkmTB3D8ajpiClQbmApKkgHzE+lAE1FFFIYUUUUAFFFFAB\n" +
            "RRRQAUUUUAFFFFABUMww2fWpqjmGUz6GgCGiiimIKmhXA3HvUcabm9u9WKACiiikMKKKKAAjIwar\n" +
            "umw+1WKCAwwaAKtTQD5Sfeo3Qofb1qWHGymIfRRRSGFFFFABRRRQAUUUUAFFFFABRRRQAU2QZQ/S\n" +
            "nUjY2nNAFahQWOBQoLHAqwiBB70xCqoUYFLRRSGFFFFABRRRQAUUUUABAIwahZGQ7l6VNRQAxJQe\n" +
            "DwafTHjDcjg0z54/cfpQBNRUazKevFSAg9DmgAooooAKKKKACiijpQAUUxpVHfP0pm934UYH+e9A\n" +
            "EjSBfc+lR/NKfQU5YgOW5qSgBFUKMCloooAKKKKACiiigAooooAKKKKACiiigAooooAa0at2/KmG\n" +
            "Ej7rUUUAJiVff9aN8g6r+lFFAB5r/wB39DR5kh/h/Q0UUxB+9Pt+lHlMfvN/WiikMesSj3+tP6UU\n" +
            "UAFFFFABRRRQAUUUUAFFFFAH/9k=\n";
    @BindView(R.id.user_photo)
    ImageView userPhoto;
    public static ProgressBar regProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        regProgressBar=findViewById(R.id.reg_progress_bar);
        Reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Validate();
            }
        });
        userPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void Validate() {
        String user_name = username.getText().toString();
        String password_ = password.getText().toString();
        String confirm_password = confirmpassword.getText().toString();
        String email_ = email.getText().toString();
        String phone_number = phonenumber.getText().toString();
        String city_ = city.getText().toString();
        String adress_ = address.getText().toString();
        if (user_name.isEmpty()) {
            username.setError("Can not be empity");
        } else if (password_.isEmpty()) {
            password.setError("Can not be empity");
        } else if (confirm_password.isEmpty()) {
            confirmpassword.setError("Can not be empity");
        } else if (phone_number.isEmpty()) {
            phonenumber.setError("Can not be empity");
        } else if (email_.isEmpty()) {
            email.setError("Can not be empity");
        } else if (city_.isEmpty()) {
            city.setError("Can not be empity");
        } else if (adress_.isEmpty()) {
            address.setError("Can not be empity");
        } else if (!email_.contains("@")) {
            email.setError("Enter Valid Email");
        } else if (password_.length() < 8) {
            password.setError("pasword should be at least 8 char");
        } else if (!password_.equals(confirm_password)) {
            Message m = new Message("Passwords don't match", this);
        } else {
            int internet_starus = new Check_connection().check_intrenet_connection(this);
            if( internet_starus==1) {
                Webservice webservice = new Webservice();
                webservice.Register(this, user_name, password_, email_, phone_number, city_, adress_, photo);
                regProgressBar.setVisibility(View.VISIBLE);
            }
            else
            {
                Message m = new Message(getResources().getString(R.string.check_internet_connection), this);

            }
        }

    }
}