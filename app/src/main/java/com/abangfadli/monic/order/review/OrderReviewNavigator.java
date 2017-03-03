package com.abangfadli.monic.order.review;

import android.content.Context;
import android.content.Intent;

import com.abangfadli.monic.framework.MonicNavigator;

/**
 * Created by ahmadfadli on 9/11/16.
 */

public class OrderReviewNavigator extends MonicNavigator {

    public OrderReviewNavigator(Context context) {
        super(context);
    }

    @Override
    protected Intent createIntent() {
        return new Intent(getContext(), OrderReviewActivity.class);
    }
}
