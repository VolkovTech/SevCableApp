package com.andreyvolkov.sevcableapp.Model.Activity.VkAuthModel;

import android.content.Context;
import android.content.SharedPreferences;
import com.vk.sdk.api.model.VKList;

import org.json.JSONException;

public class VkAuthModel implements IVkAuthModel {

    private String ownerId;
    private String ownerFullName;

    @Override
    public void createNewUser(VKList vkList) {
        try {
            ownerId = (String) vkList.get(0).fields.getString("id");
            ownerFullName = (String) vkList.get(0).fields.getString("first_name")
                    + " " + (String) vkList.get(0).fields.getString("last_name");

            // logic with posting user to db via request

            saveInfoToSharedPref(ownerId, ownerFullName);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void makeRequest(String userId) {

    }

    private void saveInfoToSharedPref(String id, String userName) {
        //SharedPreferences sharedPref = MyApplication.getInstance().getSharedPreferences("userId", Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPref.edit();
//        editor.putString("id", id);
//        editor.putString("userName", userName);
//        editor.apply();
    }
}
