package com.am.engsabbagh.thejewel.Pogo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.am.engsabbagh.thejewel.HelperClass.AttolSharedPreference;
import com.am.engsabbagh.thejewel.R;
import com.am.engsabbagh.thejewel.UI.RegisterActivity;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Webservice {



    public void Register(final Context activity, final String user_name, final String password_, final String email_, final String phone_number, final String city_, final String adress_, final String photo) {
        String requestUrl = activity.getString(R.string.api_link) + "sign_up";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, requestUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("Volley Result", "" + response); //the response contains the result from the server, a json string or any other object returned by your server
                if (response != null) {
                    if (response.contains("succ")) {
                        try {
                            JSONObject jo=new JSONObject(response);
                           // AttolSharedPreference attolSharedPreference = new AttolSharedPreference((Activity) activity);
                            String id = String.valueOf(jo.getInt("customer_id"));
                           // attolSharedPreference.setKey("id", id);
                            Toast.makeText(activity, " Thank you for registration", Toast.LENGTH_LONG).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        //Register_Page.loading.setVisibility(View.GONE);
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {
                                //((Activity)activity).finish();
                                // ((Activity)activity).startActivity(new Intent(activity,MainActivity.class));
                            }
                        });



                    } else if (response.contains("Incorrect")) {
                        Toast.makeText(activity, "Data Incorrect", Toast.LENGTH_LONG).show();

                        //Register_Page.loading.setVisibility(View.GONE);

                    }
                    else if (response.contains("exists")) {
                        Toast.makeText(activity, "The user is already exsist", Toast.LENGTH_LONG).show();
                        // Register_Page.loading.setVisibility(View.GONE);


                    }
                }
                else {
                    // Register_Page.loading.setVisibility(View.GONE);

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace(); //log the error resulting from the request for diagnosis/debugging

                Toast.makeText(activity,"Check Internet Connection try again later please OR try to sign in",Toast.LENGTH_LONG).show();
                Log.e("Volley Result",  "Error"+error.getLocalizedMessage()); //the response contains the result from the server, a json string or any other object returned by your server
                // Register_Page.loading.setVisibility(View.GONE);

            }
        }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("username", user_name);
                params.put("phone",phone_number );
                params.put("password", password_);
                params.put("city", city_);
                params.put("conf_password", password_);
                params.put("email", email_);
                params.put("country",city_); // Design should updated
               params.put("picture",photo );// Design should updated
                params.put("address",adress_ );


                return params;
            }
        };
        Volley.newRequestQueue(activity).add(stringRequest);
    }
}
