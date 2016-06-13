package com.codika.androidmvp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;

import com.codika.androidmvp.presenter.BasePresenter;
import com.codika.androidmvp.view.BaseView;

/**
 * Created by ignacio on 09/06/16.
 */
public abstract class BaseMvpFragment<V extends BaseView, P extends BasePresenter<V>> extends Fragment implements LoaderManager.LoaderCallbacks<P>{

    static final int PRESENTER_LOADER_ID = 1;

    private P presenter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getLoaderManager().initLoader(PRESENTER_LOADER_ID, null, this);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onAttachView(getMvpView());
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.onDetachView();
    }

    public P getPresenter(){
        return presenter;
    }

    public abstract V getMvpView();

    public abstract Loader<P> getPresenterLoader();

    @Override
    public Loader<P> onCreateLoader(int id, Bundle args) {
        return getPresenterLoader();
    }

    @Override
    public void onLoadFinished(Loader<P> loader, P data) {
        presenter = data;
    }

    @Override
    public void onLoaderReset(Loader<P> loader) {
        presenter = null;
    }
}
