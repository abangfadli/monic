package com.abangfadli.monic.detail;

import com.abangfadli.monic.framework.presenter.MonicPresenter;
import com.abangfadli.monic.detail.contract.IDetailPresenter;
import com.abangfadli.monic.detail.contract.IDetailView;

/**
 * Created by ahmadfadli on 9/11/16.
 */

public class DetailPresenter
        extends MonicPresenter<IDetailView, DetailViewState>
        implements IDetailPresenter {

    @Override
    protected DetailViewState createViewState() {
        return new DetailViewState();
    }
}
