package com.andreyvolkov.sevcableapp.View.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.andreyvolkov.sevcableapp.R;

public class WelcomeActivity extends AppCompatActivity {

    Button userLoginButton;
    TextView residentLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        init();
    }

    private void init() {
        TextView welcome_subtitle = findViewById(R.id.welcome_subtitle);
        TextView welcome_subtitle_2 = findViewById(R.id.welcome_subtitle_2);
        userLoginButton = findViewById(R.id.userLoginButton);
        residentLoginButton = findViewById(R.id.residentLoginButton);

        Typeface skRegular = Typeface.createFromAsset(getAssets(), "fonts/AkzidenzGroteskPro-Regular.ttf");
        welcome_subtitle.setTypeface(skRegular);
        welcome_subtitle_2.setTypeface(skRegular);
        userLoginButton.setTypeface(skRegular);
        residentLoginButton.setTypeface(skRegular);
    }

    public void userLoginButtonClick(View view) {
        fillSharedPref("user");
        intentToAuthActivity();
    }

    public void residentLoginButtonClick(View view) {
        fillSharedPref("resident");
        intentToAuthActivity();
    }

    private void intentToAuthActivity() {
        Intent intent = new Intent(WelcomeActivity.this, VkAuthActivity.class);
        startActivity(intent);
    }

    private void fillSharedPref(String role) {
        SharedPreferences sharedPref = getSharedPreferences("role", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("role", role);
        editor.apply();
    }
}
