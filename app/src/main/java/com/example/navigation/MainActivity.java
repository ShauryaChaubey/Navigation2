package com.example.navigation;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.support.v4.view.*;
import android.support.v4.widget.*;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
private DrawerLayout drawer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer=findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawer,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        NavigationView navigationView=findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        toggle.syncState();
        if(savedInstanceState==null){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Home()).commit();
    navigationView.setCheckedItem(R.id.nav_home);
    }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch(menuItem.getItemId())
        {
            case R.id.nav_home:
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Home()).commit();
                break;
            case R.id.nav_corporate:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Corporate()).commit();
                break;
            case R.id.nav_domestic:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Domestic()).commit();
                break;
            case R.id.nav_student:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Student()).commit();
                break;
            case R.id.nav_others:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Other()).commit();
                break;
            case R.id.nav_about:
                Toast.makeText(this,"The app is deseigned to maintain the criminal records",Toast.LENGTH_SHORT).show();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onBackPressed()
        {
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
            super.onBackPressed();
         }
        }
    }
