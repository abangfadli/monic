package com.abangfadli.monic.example;

import android.content.Context;
import android.content.Intent;

import com.abangfadli.monic.framework.MonicNavigator;

/**
 * Created by ahmadfadli on 9/11/16.
 */

public class ExampleNavigator extends MonicNavigator {

    public ExampleNavigator(Context context) {
        super(context);
    }

    @Override
    protected Intent createIntent() {
        return new Intent(getContext(), ExampleActivity.class);
    }
}
