package com.example.fragmentprova;

import android.content.res.ColorStateList;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        bottomNavigationView.setItemTextColor(ColorStateList.valueOf(getColor(R.color.green)));
                        selectedFragment = new FragmentOne();
                        break;
                    case R.id.navigation_dashboard:
                        selectedFragment = new FragmentTwo();
                        break;
                    case R.id.navigation_registrati:
                        selectedFragment = new FragmentLogin();
                        break;
                    case R.id.navigation_settings:
                        selectedFragment = new FragmentSettings();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container, selectedFragment).commit();
                return true;
            }
        });
    }
}
