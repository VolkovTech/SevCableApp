package com.andreyvolkov.sevcableapp.Model.Activity.VkAuthModel;

import com.andreyvolkov.sevcableapp.Model.MyApplication;
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
        } catch (JSONException e) {
            e.printStackTrace();
        }
        // logic with posting user to db via request

    }

    private void makeRequest(String userId) {

    }
}
