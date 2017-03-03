package com.abangfadli.monic.framework.view;

import android.databinding.Observable;

import com.abangfadli.simplemvp.view.IView;

/**
 * Created by ahmadfadli on 9/5/16.
 */

public interface IMonicView extends IView {
    void onViewStateChanged(Observable observable, int property);
}
