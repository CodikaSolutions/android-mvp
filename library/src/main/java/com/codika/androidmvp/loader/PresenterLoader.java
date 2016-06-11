package com.codika.androidmvp.loader;

import android.content.Context;
import android.support.v4.content.Loader;

import com.codika.androidmvp.presenter.BasePresenter;

/**
 * Created by ignacio on 09/06/16.
 */
public abstract class PresenterLoader<T extends BasePresenter> extends Loader<T> {

    private T presenter;

    public PresenterLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();

        if (presenter != null) {
            deliverResult(presenter);
            return;
        }

        forceLoad();
    }

    @Override
    protected void onForceLoad() {

        presenter = getPresenter();

        deliverResult(presenter);
    }

    @Override
    protected void onReset() {
        if (presenter != null) {
            presenter.onDestroy();
            presenter = null;
        }
    }

    public abstract T getPresenter();
}
