package com.abangfadli.monic.framework;

import android.content.Context;
import android.content.Intent;

/**
 * Created by ahmadfadli on 9/11/16.
 */

public abstract class MonicNavigator {
    private Intent mIntent;
    private Context mContext;

    public MonicNavigator(Context context) {
        mContext = context;
        mIntent = createIntent();
    }

    protected abstract Intent createIntent();

    public Intent getIntent() {
        return mIntent;
    }

    protected Context getContext() {
        return mContext;
    }

    public void navigate(Context context) {
        context.startActivity(mIntent);
    }
}
