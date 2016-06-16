package com.codika.androidmvp.loader;

import android.content.Context;
import android.support.v4.content.Loader;

import com.codika.androidmvp.presenter.BasePresenter;

/**
 * A base implementation of {@link android.content.Loader}
 *
 * @param <T> type of the {@link BasePresenter}
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

        if(presenter == null){
            throw new NullPointerException("Presenter is null! Do you return null in getPresenter()?");
        }

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
