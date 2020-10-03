package com.am.engsabbagh.thejewel.HelperClass;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Check_connection {
    public int check_intrenet_connection (Context context)
    {
        ConnectivityManager mgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = mgr.getActiveNetworkInfo();

        if (netInfo != null) {
            if (netInfo.isConnected()) {
                // Internet Available
                return 1;
            }else {
                //No internet
                return 0;
            }
        } else {
            //No internet
            return 0;
        }
    }
}
