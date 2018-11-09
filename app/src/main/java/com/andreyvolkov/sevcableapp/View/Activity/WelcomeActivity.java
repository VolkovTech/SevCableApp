package com.andreyvolkov.sevcableapp.View.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.andreyvolkov.sevcableapp.R;
import com.vk.sdk.util.VKUtil;

public class WelcomeActivity extends AppCompatActivity {

    Button userLoginButton;
    TextView residentLoginButton;

    private static final String TAG = "WelcomeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        init();
    }

    private void init() {
        userLoginButton = findViewById(R.id.userLoginButton);
        residentLoginButton = findViewById(R.id.residentLoginButton);
    }

    public void userLoginButtonClick(View view) {
        fillSharedPref("user");
        intentToMainActivity();
    }

    public void residentLoginButtonClick(View view) {
        fillSharedPref("resident");
        intentToMainActivity();
    }

    private void intentToMainActivity() {
        Intent intent = new Intent(WelcomeActivity.this, VkAuthActivity.class);
        startActivity(intent);
    }

    private void fillSharedPref(String name) {

    }
}
