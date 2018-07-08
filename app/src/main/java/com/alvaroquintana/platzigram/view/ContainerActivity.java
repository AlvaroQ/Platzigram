package com.alvaroquintana.platzigram.view;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.alvaroquintana.platzigram.R;
import com.alvaroquintana.platzigram.view.fragment.HomeFragment;
import com.alvaroquintana.platzigram.view.fragment.ProfileFragment;
import com.alvaroquintana.platzigram.view.fragment.SearchFragment;

public class ContainerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationView);
        fragmentToHomeFadeTransition();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.navigation_search:
                        fragmentToSearchFadeTransition();
                        break;

                    case R.id.navigation_home:
                        fragmentToHomeFadeTransition();
                        break;

                    case R.id.navigation_profile:
                        fragmentToProfileFadeTransition();
                        break;
                }
                return false;
            }
        });
    }

    public void fragmentToSearchFadeTransition() {
        SearchFragment searchFragment = new SearchFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, searchFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .addToBackStack(null).commit();
    }

    public void fragmentToHomeFadeTransition() {
        HomeFragment homeFragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .addToBackStack(null).commit();
    }

    public void fragmentToProfileFadeTransition() {
        ProfileFragment profileFragment = new ProfileFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, profileFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .addToBackStack(null).commit();
    }
}
