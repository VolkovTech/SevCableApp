package com.andreyvolkov.sevcableapp.Presenter.Activity;

import com.andreyvolkov.sevcableapp.Model.Activity.VkAuthModel.IVkAuthModel;
import com.andreyvolkov.sevcableapp.Model.Activity.VkAuthModel.VkAuthModel;
import com.andreyvolkov.sevcableapp.View.Activity.VkAuthActivity;
import com.vk.sdk.api.model.VKList;

public class VkAuthPresenter implements IVkAuthPresenter {

    VkAuthActivity vkAuthActivity;

    public VkAuthPresenter(VkAuthActivity vkAuthActivity) {
        this.vkAuthActivity = vkAuthActivity;
    }

    @Override
    public void onRequestSend(String userId) {
        IVkAuthModel vkAuthModel = new VkAuthModel();
        vkAuthModel.sendRequest(userId);
    }
}
