package com.abangfadli.monic.framework.view.dialog;

import android.content.Context;
import android.databinding.Observable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.WindowManager;

import com.abangfadli.monic.framework.presenter.IMonicPresenter;
import com.abangfadli.monic.framework.view.IMonicView;
import com.abangfadli.simplemvp.view.dialog.SimpleDialog;

/**
 * Created by ahmadfadli on 9/11/16.
 */

public abstract class MonicDialog<P extends IMonicPresenter, L extends DialogListener>
        extends SimpleDialog<P>
        implements IMonicView, View.OnClickListener {

    protected L mListener;

    protected final float DEFAULT_DIM = 0.75f;

    public MonicDialog(Context context, @NonNull L listener) {
        super(context);
        mListener = listener;
        setCancelable(true);
        setCanceledOnTouchOutside(true);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onSetupView();
        onSetupState(savedInstanceState);
        onSetupListener();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    protected void onSetupView() {

    }

    protected void onSetupState(Bundle savedInstanceState) {
        setDim();
    }

    protected void onSetupListener() {
        setOnShowListener(dialog -> onShow());
        setOnCancelListener(dialog -> onCancel());
        setOnDismissListener(dialog -> onDismiss());
    }

    protected void onShow() {
        mListener.onStart(this);
    }

    protected void onCancel() {
        mListener.onCancel(this);
    }

    protected void onDismiss() {
        mListener.onDismiss(this);
    }

    protected void complete() {
        mListener.onComplete(this);
        this.dismiss();
    }

    protected void setFullScreen() {
        if(getWindow() != null) {
            getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        }
    }

    protected void setDim(float dimAmount) {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        getWindow().setDimAmount(dimAmount);
    }

    protected void setDim() {
        setDim(DEFAULT_DIM);
    }

    // region Factory
    @Override
    public abstract P createPresenter();

    // endregion

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onViewStateChanged(Observable observable, int property) {

    }
}
