package com.example.navigationdrawerdemo.demoone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.icu.lang.UScript;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;


import com.example.navigationdrawerdemo.R;
import com.google.android.material.navigation.NavigationView;

public class MainActivityOne extends AppCompatActivity {

    Toolbar toolbar;
    NavigationView nav_view;

    DrawerLayout drawer_layout;

    ActionBarDrawerToggle toggle;

    FrameLayout frm_main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.navigationdrawerdemo.R.layout.activity_main_one);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nav_view = (NavigationView) findViewById(R.id.nav_view);
        drawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);

        frm_main = (FrameLayout) findViewById(R.id.frm_main);

        //mention in string res

        toggle = new ActionBarDrawerToggle(this, drawer_layout,toolbar,R.string.open,R.string.close);

        //toggle par click karne ke bad open hoge profile page
        drawer_layout.addDrawerListener(toggle);
        toggle.syncState();

        //perform operation n Home setting....

        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                int item_id = item.getItemId();

                if (item_id == R.id.home)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frm_main,new HomeFrgment()).commit();

                   // Toast.makeText(MainActivityOne.this, "Home Clicked.....", Toast.LENGTH_SHORT).show();
                    drawer_layout.closeDrawer(GravityCompat.START);// after click on home or profile as it is ho jayega
                    return true;
                }
                else if (item_id == R.id.profile)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frm_main,new MyProfileFrgment()).commit();

                    //Toast.makeText(MainActivityOne.this, "Profile Clicked.....", Toast.LENGTH_SHORT).show();
                    drawer_layout.closeDrawer(GravityCompat.START);
                    return true;
                }
                else if (item_id == R.id.message)
                {
                    Toast.makeText(MainActivityOne.this, "Message Clicked.....", Toast.LENGTH_SHORT).show();
                    drawer_layout.closeDrawer(GravityCompat.START);
                    return true;
                }
                else if (item_id == R.id.setting)
                {
                    Toast.makeText(MainActivityOne.this, "Setting Clicked.....", Toast.LENGTH_SHORT).show();
                    drawer_layout.closeDrawer(GravityCompat.START);
                    return true;
                }

                return false;
            }
        });

    }
}