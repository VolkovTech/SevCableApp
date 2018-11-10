package com.andreyvolkov.sevcableapp.View.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.andreyvolkov.sevcableapp.Presenter.Activity.IVkAuthPresenter;
import com.andreyvolkov.sevcableapp.Presenter.Activity.VkAuthPresenter;
import com.andreyvolkov.sevcableapp.R;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKScope;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;
import com.vk.sdk.api.model.VKList;

import org.json.JSONException;

public class VkAuthActivity extends AppCompatActivity {

    private String[] scope = new String[] {VKScope.GROUPS, VKScope.WALL};
    private IVkAuthPresenter vkAuthPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vk_auth);
        init();
    }

    public void init() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        VKSdk.login(this, scope);
        vkAuthPresenter = new VkAuthPresenter(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
            @Override
            public void onResult(VKAccessToken res) {
                VKRequest request = VKApi.users().get(VKParameters.from(VKApiConst.FIELDS, "id, full_name"));
                request.executeWithListener(new VKRequest.VKRequestListener() {
                    @Override
                    public void onComplete(VKResponse response) {
                        super.onComplete(response);
                        VKList vkList = (VKList) response.parsedModel;
                        onVkAuthResult(vkList);
                        intentToMainActivity();
                    }
                });
            }

            @Override
            public void onError(VKError error) {
                // Произошла ошибка авторизации (например, пользователь запретил авторизацию)
                Toast.makeText(getApplicationContext(), "Повторите попытку авторизации", Toast.LENGTH_LONG).show();
                intentToWelcomeActivity();
            }})) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void intentToWelcomeActivity() {
        Intent intent = new Intent(getApplicationContext(), WelcomeActivity.class);
        startActivity(intent);
    }

    private void onVkAuthResult(VKList vkList) {
        try {
            String ownerId = (String) vkList.get(0).fields.getString("id");
            String ownerFullName = (String) vkList.get(0).fields.getString("first_name")
                    + " " + (String) vkList.get(0).fields.getString("last_name");

            // posting user to db via request
            vkAuthPresenter.onRequestSend(ownerId);

            saveInfoToSharedPref(ownerId, ownerFullName);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void saveInfoToSharedPref(String id, String userName) {
        SharedPreferences sharedPref = getSharedPreferences("userId", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("id", id);
        editor.putString("userName", userName);
        editor.apply();
    }

    private String getSP() {
        SharedPreferences sharedPref = getSharedPreferences("role", Context.MODE_PRIVATE);
        return sharedPref.getString("user", null);
    }

    private void intentToMainActivity() {
        Intent intent;
        if (getSP() != null)
            intent = new Intent(getApplicationContext(), CustomerActivity.class);
        else
            intent = new Intent(getApplicationContext(), CustomerActivity.class); // change to retailer
        startActivity(intent);
    }
}
