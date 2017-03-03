package com.abangfadli.monic;

import android.app.Application;

import com.abangfadli.monic.repository.common.MainStore;

/**
 * Created by ahmadfadli on 9/5/16.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        MainStore.init(this);
    }
}
