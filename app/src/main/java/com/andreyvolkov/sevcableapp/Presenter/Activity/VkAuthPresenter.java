package com.andreyvolkov.sevcableapp.Presenter.Activity;

import com.andreyvolkov.sevcableapp.Model.Activity.VkAuthModel.VkAuthModel;
import com.andreyvolkov.sevcableapp.View.Activity.IVkAuthActivity;
import com.vk.sdk.api.model.VKList;

import org.json.JSONException;

public class VkAuthPresenter implements IVkAuthPresenter {

    IVkAuthActivity vkAuthActivity;

    public VkAuthPresenter(IVkAuthActivity vkAuthActivity) {
        this.vkAuthActivity = vkAuthActivity;
    }

    @Override
    public void onVkAuthResult(VKList vkList) {
        VkAuthModel vkAuthModel = new VkAuthModel();
        vkAuthModel.createNewUser(vkList);
    }
}
