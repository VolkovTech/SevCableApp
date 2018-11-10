package com.andreyvolkov.sevcableapp.Model.Activity.VkAuthModel;

public interface IVkAuthModel {
    void sendSignInRequest(String userId);
    void sendWallRequest(String userId);
}
