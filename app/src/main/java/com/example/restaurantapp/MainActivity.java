package com.example.restaurantapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener

{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = findViewById(R.id.toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer);
        Button logOutBtn =findViewById(R.id.logOutButton);

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.nav_open, R.string.nav_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        logOutBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               FirebaseAuth.getInstance().signOut();
               Intent i = new Intent(MainActivity.this,WelcomeActivity.class);
               startActivity(i);
           }
       });

    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        DrawerLayout drawer = findViewById(R.id.drawer);

        switch(menuItem.getItemId()) {
            case R.id.drinks:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new DrinksFragment()).commit();
                drawer.closeDrawer(GravityCompat.START);
                break;

            case R.id.maincourse:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new MainCourseFragment()).commit();
                drawer.closeDrawer(GravityCompat.START);
                break;
        }

        return true;
    }
}