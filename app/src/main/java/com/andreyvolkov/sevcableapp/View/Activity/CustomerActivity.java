package com.andreyvolkov.sevcableapp.View.Activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.andreyvolkov.sevcableapp.R;
import com.andreyvolkov.sevcableapp.View.Fragment.Customer.CustomerFavoritesFragment;
import com.andreyvolkov.sevcableapp.View.Fragment.Customer.CustomerNewsfeedFragment;
import com.andreyvolkov.sevcableapp.View.Fragment.Customer.CustomerSearchFragment;
import com.andreyvolkov.sevcableapp.View.Helper.BottomNavigationViewHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class CustomerActivity extends AppCompatActivity {

    private static final int ACTIVITY_NUM = 1;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        init();
    }

    private void init() {
        BottomNavigationViewEx bottomNavigationViewEx = findViewById(R.id.bottomNavigationCustomer);
        bottomNavigationViewEx.setOnNavigationItemSelectedListener(navListener);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);

        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Все мероприятия");

//        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SimpleSearchFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.navCusSearch:
                            selectedFragment = new CustomerSearchFragment();
                            getSupportActionBar().setTitle("Поиск");
                            break;
                        case R.id.navCusFeed:
                            selectedFragment = new CustomerNewsfeedFragment();
                            getSupportActionBar().setTitle("Все мероприятия");
                            break;
                        case R.id.navCusFavorite:
                            selectedFragment = new CustomerFavoritesFragment();
                            getSupportActionBar().setTitle("Мои мероприятия");
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.customer_container, selectedFragment).commit();
                    return true;
                }
            };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.right_side_menu, menu);
        for(int i = 0; i < menu.size(); i++){
            Drawable drawable = menu.getItem(i).getIcon();
            if(drawable != null) {
                drawable.mutate();
                drawable.setColorFilter(getResources().getColor(R.color.colorWhite), PorterDuff.Mode.SRC_ATOP);
            }
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.navRightRelevant:
                break;
            case R.id.navRightDate:
                break;
            case R.id.navRightExit:
                Intent intent = new Intent(this, WelcomeActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
