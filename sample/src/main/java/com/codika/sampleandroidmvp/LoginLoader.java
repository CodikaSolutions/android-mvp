package com.codika.sampleandroidmvp;

import android.content.Context;

import com.codika.androidmvp.loader.PresenterLoader;

/**
 * Created by ignacio on 13/06/16.
 */
public class LoginLoader extends PresenterLoader<LoginPresenter> {

    public LoginLoader(Context context) {
        super(context);
    }

    @Override
    public LoginPresenter getPresenter() {
        return new LoginPresenter();
    }
}
