package com.abangfadli.monic.repository.common;

import android.content.Context;

import com.abangfadli.monic.common.Constant;

import retrofit2.Retrofit;

/**
 * Created by ahmadfadli on 2/21/17.
 */

public abstract class BaseStore {

    protected final String TAG = Constant.APP_TAG + " " + this.getClass().getSimpleName();

    protected final Context mContext;
    protected final Retrofit mRetrofit;
    protected final MainStore mMainStore;

    public BaseStore(MainStore mainStore, Context context, Retrofit retrofit) {
        mContext = context;
        mRetrofit = retrofit;
        mMainStore = mainStore;
    }
}
