package com.codika.androidmvprx.presenter;

import com.codika.androidmvp.presenter.BasePresenter;
import com.codika.androidmvp.view.BaseView;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by ignacio on 21/07/16.
 */
public abstract class BaseRxPresenter<V extends BaseView> extends BasePresenter<V> {

    private CompositeSubscription subscription;

    public BaseRxPresenter(){
        this.subscription = new CompositeSubscription();
    }

    @Override
    public void onDetachView() {
        super.onDetachView();
        subscription.clear();
    }

    public void addSubscription(Subscription subscription){
        this.subscription.add(subscription);
    }
}
