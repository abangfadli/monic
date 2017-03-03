package com.abangfadli.monic.repository.vendor;

import android.content.Context;

import com.abangfadli.monic.common.Constant;
import com.abangfadli.monic.repository.common.BaseStore;
import com.abangfadli.monic.repository.common.MainStore;

import java.util.List;

import retrofit2.Retrofit;
import rx.Observable;

/**
 * Created by ahmadfadli on 2/21/17.
 */

public class VendorStore extends BaseStore {

    private final String PREF_FILE = Constant.APP_PACKAGE + "-" + "vendor";
    private final VendorAPIService mAPIService;

    public VendorStore(MainStore mainStore, Context context, Retrofit retrofit) {
        super(mainStore, context, retrofit);
        mAPIService = mRetrofit.create(VendorAPIService.class);
    }

    public Observable<List<VendorModel>> getVendorList() {
        return mAPIService.getVendorList();
    }
}
