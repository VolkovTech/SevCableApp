package com.andreyvolkov.sevcableapp.View.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.andreyvolkov.sevcableapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        String role = getRoleFromSharedPref();
        Intent intent;
        if (role == null)
            intent = new Intent(getApplicationContext(), WelcomeActivity.class);
        else if (role.equals("user"))
            intent = new Intent(getApplicationContext(), CustomerActivity.class);
        else
            intent = new Intent(getApplicationContext(), ResidentActivity.class); // change to resident
        startActivity(intent);
    }

    private String getRoleFromSharedPref() {
        SharedPreferences sharedPref = getSharedPreferences("role", Context.MODE_PRIVATE);
        return sharedPref.getString("role", null); //
    }
}
