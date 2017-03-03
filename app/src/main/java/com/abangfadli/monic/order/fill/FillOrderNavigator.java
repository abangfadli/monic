package com.abangfadli.monic.order.fill;

import android.content.Context;
import android.content.Intent;

import com.abangfadli.monic.framework.MonicNavigator;

/**
 * Created by ahmadfadli on 9/11/16.
 */

public class FillOrderNavigator extends MonicNavigator {

    public FillOrderNavigator(Context context) {
        super(context);
    }

    @Override
    protected Intent createIntent() {
        return new Intent(getContext(), FillOrderActivity.class);
    }
}
