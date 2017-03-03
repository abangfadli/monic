package com.abangfadli.monic.home;

import android.content.Context;
import android.content.Intent;

import com.abangfadli.monic.framework.MonicNavigator;

/**
 * Created by ahmadfadli on 9/11/16.
 */

public class HomeNavigator extends MonicNavigator {

    public HomeNavigator(Context context) {
        super(context);
    }

    @Override
    protected Intent createIntent() {
        return new Intent(getContext(), HomeActivity.class);
    }
}
