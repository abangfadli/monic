package com.abangfadli.monic.repository.vendor;

import com.abangfadli.monic.api.APIRoutes;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by ahmadfadli on 2/21/17.
 */

public interface VendorAPIService {
    @GET(APIRoutes.VENDOR)
    Observable<List<VendorModel>> getVendorList();
}
