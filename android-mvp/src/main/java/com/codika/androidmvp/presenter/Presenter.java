package com.codika.androidmvp.presenter;

import android.app.Activity;
import android.app.Fragment;

import com.codika.androidmvp.view.BaseView;

/**
 * The base interface for each presenter
 */
public interface Presenter<V extends BaseView> {

    /**
     * Set view to this presenter. This method will be invoked from
     * {@link Activity#onResume()} or {@link Fragment#onResume()}
     */
    void onAttachView(V view);

    /**
     * Will be called if the view has been destroyed. This method will be invoked from
     * {@link Activity#onStop()} or {@link Fragment#onStop()}
     */
    void onDetachView();


    void onDestroy();
}
