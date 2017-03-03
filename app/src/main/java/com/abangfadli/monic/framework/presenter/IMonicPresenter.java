package com.abangfadli.monic.framework.presenter;

import com.abangfadli.monic.framework.MonicViewState;
import com.abangfadli.monic.framework.view.IMonicView;
import com.abangfadli.simplemvp.presenter.IPresenter;

/**
 * Created by ahmadfadli on 9/5/16.
 */

public interface IMonicPresenter<V extends IMonicView, VS extends MonicViewState> extends IPresenter<V> {
    VS getViewState();
}
