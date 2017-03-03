package com.abangfadli.monic.order.fill;

import com.abangfadli.monic.framework.presenter.MonicPresenter;
import com.abangfadli.monic.order.fill.contract.IFillOrderPresenter;
import com.abangfadli.monic.order.fill.contract.IFillOrderView;

/**
 * Created by ahmadfadli on 9/11/16.
 */

public class FillOrderPresenter
        extends MonicPresenter<IFillOrderView, FillOrderViewState>
        implements IFillOrderPresenter {

    @Override
    protected FillOrderViewState createViewState() {
        return new FillOrderViewState();
    }
}
