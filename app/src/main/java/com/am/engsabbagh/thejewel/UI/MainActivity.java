package com.am.engsabbagh.thejewel.UI;

import android.os.Bundle;

import com.am.engsabbagh.thejewel.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        //Delete Action Bar
       /* AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_offers, R.id.navigation_cart, R.id.navigation_notifications, R.id.navigation_profile)
                .build();*/
        NavController navController = Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment);
     //   NavigationUI.setupActionBarWithNavController(MainActivity.this, navController, appBarConfiguration);  //delete action abr
        NavigationUI.setupWithNavController(navView, navController);


    }
}