package com.codika.androidmvp.presenter;

import com.codika.androidmvp.view.BaseView;

/**
 * Created by Emiliano Mallo on 14/05/16.
 */
public interface Presenter<V extends BaseView> {
    void onAttachView(V view);
    void onDetachView();
    void onDestroy();
}
