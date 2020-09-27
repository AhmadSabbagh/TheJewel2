package com.am.engsabbagh.thejewel.HelperClass;

import android.app.Activity;
import android.widget.Toast;

public class Message {
    public  Message(String text , Activity activity)
    {
        Toast.makeText(activity,text,Toast.LENGTH_LONG).show();
    }
}
