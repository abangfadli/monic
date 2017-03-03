package com.abangfadli.monic.detail;

import android.content.Context;
import android.content.Intent;

import com.abangfadli.monic.framework.MonicNavigator;

/**
 * Created by ahmadfadli on 9/11/16.
 */

public class DetailNavigator extends MonicNavigator {

    public DetailNavigator(Context context) {
        super(context);
    }

    @Override
    protected Intent createIntent() {
        return new Intent(getContext(), DetailActivity.class);
    }
}
