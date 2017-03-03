package com.abangfadli.monic.order.fill;

import com.abangfadli.monic.framework.view.MonicActivity;
import com.abangfadli.monic.order.fill.contract.IFillOrderPresenter;
import com.abangfadli.monic.order.fill.contract.IFillOrderView;

/**
 * Created by ahmadfadli on 9/11/16.
 */

public class FillOrderActivity
        extends MonicActivity<IFillOrderPresenter, FillOrderViewState>
        implements IFillOrderView {

    @Override
    public IFillOrderPresenter createPresenter() {
        return new FillOrderPresenter();
    }


}
