package com.abangfadli.monic.order.review;

import com.abangfadli.monic.framework.presenter.MonicPresenter;
import com.abangfadli.monic.order.review.contract.IOrderReviewPresenter;
import com.abangfadli.monic.order.review.contract.IOrderReviewView;

/**
 * Created by ahmadfadli on 9/11/16.
 */

public class OrderReviewPresenter
        extends MonicPresenter<IOrderReviewView, OrderReviewViewState>
        implements IOrderReviewPresenter {

    @Override
    protected OrderReviewViewState createViewState() {
        return new OrderReviewViewState();
    }
}
