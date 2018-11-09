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

    private String[] scope = new String[] {VKScope.FRIENDS};
//    private APIClient client = new APIClient();
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
                        vkAuthPresenter.onVkAuthResult(vkList);
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

    private void intentToMainActivity() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    private void intentToWelcomeActivity() {
        //Intent intent = new Intent(getApplicationContext(), WelcomeActivity.class);
        //startActivity(intent);
    }
}
