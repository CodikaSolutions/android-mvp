package com.codika.androidmvp.presenter;

import android.util.Log;

import com.codika.androidmvp.view.BaseView;

/**
 * A base implementation of {@link Presenter}
 *
 * @param <V> type of the {@link BaseView}
 */
public class BasePresenter<V extends BaseView> implements Presenter<V> {

    static final String TAG = "BasePresenter";

    private V view;

    @Override
    public void onAttachView(V view) {
        if(view == null){
            throw new NullPointerException("View is null! Do you return null in getMvpView()?");
        }

        Log.v(TAG, "onAttach " + view.toString());
        this.view = view;
    }

    @Override
    public void onDetachView() {
        if(view != null){
            Log.v(TAG, "onDetach " + view.toString());
            view = null;
        }
    }

    /**
     * Checks if a view is attached to this presenter. You should always call this method before
     * calling {@link #getView()} to get the view instance.
     */
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
