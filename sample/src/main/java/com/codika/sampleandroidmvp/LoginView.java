package com.codika.sampleandroidmvp;

import com.codika.androidmvp.view.BaseView;

/**
 * Created by ignacio on 12/06/16.
 */
public interface LoginView extends BaseView {

    void showProgress();
    void hideProgress();
    void loginSuccess();
    void showEmptyFields();
    void showInvalidMail();
    void showInvalidPassword();
    void loginError(String error);
}
