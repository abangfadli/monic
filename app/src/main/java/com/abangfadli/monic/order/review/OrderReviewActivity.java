package com.abangfadli.monic.order.review;

import com.abangfadli.monic.framework.view.MonicActivity;
import com.abangfadli.monic.order.review.contract.IOrderReviewPresenter;
import com.abangfadli.monic.order.review.contract.IOrderReviewView;

/**
 * Created by ahmadfadli on 9/11/16.
 */

public class OrderReviewActivity
        extends MonicActivity<IOrderReviewPresenter, OrderReviewViewState>
        implements IOrderReviewView {

    @Override
    public IOrderReviewPresenter createPresenter() {
        return new OrderReviewPresenter();
    }
}
