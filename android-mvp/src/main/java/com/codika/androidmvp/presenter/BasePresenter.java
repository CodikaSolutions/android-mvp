package com.codika.androidmvp.presenter;

import android.util.Log;

import com.codika.androidmvp.view.BaseView;

/**
 * Created by Ignacio Oviedo on 14/05/16.
 */
public class BasePresenter<V extends BaseView> implements Presenter<V> {

    static final String TAG = "BasePresenter";

    private V view;

    @Override
    public void onAttachView(V view) {
        this.view = view;
        Log.v(TAG, "onAttach " + view.toString());
    }

    @Override
    public void onDetachView() {
        if(view != null){
            Log.v(TAG, "onDetach " + view.toString());
            view = null;
        }
    }

    public boolean isViewAttached(){
        return view != null;
    }

    @Override
    public void onDestroy() {
        Log.v(TAG, "onDestroy");
    }

    public V getView(){
        return view;
    }
}
