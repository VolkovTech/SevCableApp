package com.andreyvolkov.sevcableapp.Model.Activity.ResidentActivity;

import android.util.Log;

import com.andreyvolkov.sevcableapp.Model.JSONParseHelper;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static android.support.constraint.Constraints.TAG;

public class ResidentAPIRequests {

    private String baseURL = "http://9d5432d8.ngrok.io/";
    private String user = "register?vkId=";
    private String wall = "getWall?vkId=";
    private JSONParseHelper parser = new JSONParseHelper();

    public void sendSignInRequest(String userId) {

        String query = baseURL + user + userId;

        OkHttpClient client = new OkHttpClient()
                .newBuilder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();
        Request request = new Request.Builder()
                .url(query)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String bodyResponse = response.body().string();
                Log.d(TAG, "onResponse bodyResponse: " + bodyResponse);
            }
        });
    }
}
