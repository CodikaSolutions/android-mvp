package com.codika.androidmvp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;

import com.codika.androidmvp.presenter.BasePresenter;
import com.codika.androidmvp.view.BaseView;

/**
 * Created by ignacio on 09/06/16.
 */
public abstract class BaseMvpActivity<V extends BaseView, P extends BasePresenter<V>> extends AppCompatActivity
        implements LoaderManager.LoaderCallbacks<P>  {

    static final int PRESENTER_LOADER_ID = 1;

    private P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportLoaderManager().initLoader(PRESENTER_LOADER_ID, null, this);
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
