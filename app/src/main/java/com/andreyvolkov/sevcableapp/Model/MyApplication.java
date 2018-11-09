package com.andreyvolkov.sevcableapp.Model;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MyApplication extends Application {

    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static MyApplication getInstance() {
        return instance;
    }
}
