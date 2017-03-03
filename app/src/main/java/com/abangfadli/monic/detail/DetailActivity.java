package com.abangfadli.monic.detail;

import com.abangfadli.monic.framework.view.MonicActivity;
import com.abangfadli.monic.detail.contract.IDetailPresenter;
import com.abangfadli.monic.detail.contract.IDetailView;

/**
 * Created by ahmadfadli on 9/11/16.
 */

public class DetailActivity
        extends MonicActivity<IDetailPresenter, DetailViewState>
        implements IDetailView {


    @Override
    public IDetailPresenter createPresenter() {
        return new DetailPresenter();
    }
}
