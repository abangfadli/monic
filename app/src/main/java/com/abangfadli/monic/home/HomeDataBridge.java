package com.abangfadli.monic.home;

import com.abangfadli.monic.common.widget.SearchItem;
import com.abangfadli.monic.repository.vendor.VendorModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ahmadfadli on 2/21/17.
 */

public class HomeDataBridge {
    public static HomeViewState injectViewState(HomeViewState viewState, List<VendorModel> result) {
        List<SearchItem> searchItemList = new ArrayList<>();
        for (VendorModel vendorModel : result) {
            SearchItem searchItem = new SearchItem();
            searchItem.setId(vendorModel.getVendorID());
            searchItem.setTitle(vendorModel.getVendorName());
            searchItem.setImageUrl(vendorModel.getVendorImage());
            searchItem.setDescription(vendorModel.getVendorType());

            searchItemList.add(searchItem);
        }

        viewState.setLocalItems(searchItemList);

        return viewState;
    };
}
