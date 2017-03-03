package com.abangfadli.monic.repository.common;

import android.content.Context;

import com.abangfadli.monic.api.client.RetrofitBuilder;
import com.abangfadli.monic.repository.vendor.VendorStore;

/**
 * Created by ahmadfadli on 2/21/17.
 */

public class MainStore {
    private static MainStore sInstance;
    private static Context sContext;

    private final VendorStore mVendorStore;

    private MainStore(Context context) {
        sContext = context;
        mVendorStore = new VendorStore(this, context, RetrofitBuilder.getDefaultBuilder());
    }

    public static MainStore getInstance() {
        if(sInstance == null) {
            throw new IllegalStateException("MainStore is not initialized");
        }

        return sInstance;
    }

    public static void init(Context context) {
        sInstance = new MainStore(context.getApplicationContext());
    }

    // region Store's Getter

    public VendorStore getVendorStore() {
        return mVendorStore;
    }

    // endregion
}
