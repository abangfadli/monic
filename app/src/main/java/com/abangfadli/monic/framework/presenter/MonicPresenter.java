package com.abangfadli.monic.framework.presenter;

import android.databinding.Observable;

import com.abangfadli.monic.BR;
import com.abangfadli.monic.framework.MonicViewState;
import com.abangfadli.monic.framework.view.IMonicView;
import com.abangfadli.simplemvp.presenter.SimplePresenter;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by ahmadfadli on 9/5/16.
 */

public abstract class MonicPresenter<V extends IMonicView, VS extends MonicViewState>
        extends SimplePresenter<V>
        implements IMonicPresenter<V, VS> {

    private VS viewState;
    private Observable.OnPropertyChangedCallback mPropertyChangedCallback;
    private CompositeSubscription mCompositeSubscription;

    public MonicPresenter() {
        viewState = createViewState();
        mPropertyChangedCallback = new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                getView().onViewStateChanged(observable, i);
            }
        };

        mCompositeSubscription = new CompositeSubscription();
    }

    @Override
    protected void onViewAttached() {
        super.onViewAttached();
        viewState.addOnStateChangeListener(mPropertyChangedCallback);
        viewState.notifyPropertyChanged(BR._all);
    }

    @Override
    protected void onViewDetached() {
        super.onViewDetached();
        viewState.removeStateChangeListener(mPropertyChangedCallback);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCompositeSubscription.clear();
    }

    protected abstract VS createViewState();

    public VS getViewState() {
        return viewState;
    }

    protected Subscription addSubscription(Subscription subscription) {
        mCompositeSubscription.add(subscription);
        return subscription;
    }
}
