package com.abangfadli.monic.framework.view;

import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.View;

import com.abangfadli.monic.framework.MonicViewState;
import com.abangfadli.monic.framework.presenter.IMonicPresenter;
import com.abangfadli.simplemvp.view.activity.SimpleActivity;

/**
 * Created by ahmadfadli on 9/5/16.
 */

public abstract class MonicActivity<P extends IMonicPresenter<?, VS>, VS extends MonicViewState>
        extends SimpleActivity<P>
        implements IMonicView, View.OnClickListener {
    //================================================================================
    // LIFE CYCLE
    //================================================================================

    @Override
    public abstract P createPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onSetupView();
        onSetupState(savedInstanceState);
    }

    //================================================================================
    // SETUP
    //================================================================================
    protected void onSetupView() {}

    protected <T extends ViewDataBinding> T setBindView(@LayoutRes int layoutRes) {
        return DataBindingUtil.setContentView(this, layoutRes, DataBindingUtil.getDefaultComponent());
    }

    protected void onSetupState(Bundle savedInstanceState) {}

    //================================================================================
    // LISTENER
    //================================================================================

    protected void registerOnClickListener(View... views) {
        for (View view : views) {
            view.setOnClickListener(this);
        }
    }
    @Override
    public void onClick(View v) {

    }

    @Override
    public void onViewStateChanged(Observable observable, int property) {
    }

    public VS getViewState() {
        return getPresenter().getViewState();
    }
}
