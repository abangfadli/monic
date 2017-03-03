package com.abangfadli.monic.home.contract;

import com.abangfadli.monic.framework.presenter.IMonicPresenter;
import com.abangfadli.monic.home.HomeViewState;

/**
 * Created by ahmadfadli on 9/11/16.
 */
public interface IHomePresenter extends IMonicPresenter<IHomeView, HomeViewState> {
    void requestPromo();

    void requestCategory();

    void requestLocal();

    void requestLocalMenu();
}
