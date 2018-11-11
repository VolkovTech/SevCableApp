package com.andreyvolkov.sevcableapp.Model.Activity.VkAuthModel;

import android.util.Log;

import com.andreyvolkov.sevcableapp.Model.JSONParseHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.json.JSONArray;
import org.json.JSONException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static android.support.constraint.Constraints.TAG;

public class VkAuthModel implements IVkAuthModel {

    private ArrayList<String> eventNames = new ArrayList<>();
    private ArrayList<String> eventDescriptions = new ArrayList<>();
    private ArrayList<String> eventDates = new ArrayList<>();
    private ArrayList<String> imageViews = new ArrayList<>();

    public ArrayList<String> getNames() {
        return eventNames;
    }
    public ArrayList<String> getDescription() {
        return eventDescriptions;
    }
    public ArrayList<String> getDates() {
        return eventDates;
    }
    public ArrayList<String> getImages() {
        return imageViews;
    }

    private String baseURL = "http://448769fb.ngrok.io/";
    private String user = "register?vkId=";
    private String wall = "getWall?vkId=";
    private JSONParseHelper parser = new JSONParseHelper();

    @Override
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
                System.out.print("Hello!");

                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String bodyResponse = response.body().string();
                Log.d(TAG, "onResponse bodyResponse: " + bodyResponse);
            }
        });
    }

    @Override
    public void sendWallRequest(String userId) {

        String query = baseURL + wall + userId;

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

                try {
                    ArrayList<Object> ja = parser.toList(new JSONArray(bodyResponse));
                    ArrayList<HashMap<String, String>> result = new ArrayList<>();
                    for (int i = 0; i < ja.size(); i++) {
                        result.add((HashMap<String, String>) ja.get(i));
                    }
                    if (result != null) {
                        fillLists(result);
                    } else {
                        makeListsNull();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void fillLists(ArrayList<HashMap<String, String>> result) {
        for (int i = 0; i < result.size(); i++) {
            eventNames.add(result.get(i).get("title"));
            eventDescriptions.add(result.get(i).get("shortDescription"));
            eventDates.add("22 ноября, утро");
            imageViews.add("https://img.fonwall.ru/o/5y/eiffel-tower-paris-france-eyfeleva-bashnya-7n74.jpg");
        }
    }

    private void makeListsNull() {
        eventNames = null;
        eventDescriptions = null;
        eventDates = null;
    }
}
