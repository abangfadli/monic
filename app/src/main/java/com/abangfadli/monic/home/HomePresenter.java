package com.abangfadli.monic.home;

import com.abangfadli.monic.common.CommonTransformer;
import com.abangfadli.monic.common.widget.SearchItem;
import com.abangfadli.monic.framework.presenter.MonicPresenter;
import com.abangfadli.monic.home.category.CategoryItem;
import com.abangfadli.monic.home.contract.IHomePresenter;
import com.abangfadli.monic.home.contract.IHomeView;
import com.abangfadli.monic.home.promo.PromoItem;
import com.abangfadli.monic.repository.common.MainStore;

import java.util.ArrayList;
import java.util.List;

import rx.Subscription;

/**
 * Created by ahmadfadli on 9/11/16.
 */

public class HomePresenter
        extends MonicPresenter<IHomeView, HomeViewState>
        implements IHomePresenter {

    @Override
    protected HomeViewState createViewState() {
        return new HomeViewState();
    }

    @Override
    public void requestPromo() {
        List<PromoItem> promoItems = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            promoItems.add(new PromoItem().setText("Item " + (i + 1)));
        }

        getViewState().setPromoItems(promoItems);
    }

    @Override
    public void requestCategory() {
        List<CategoryItem> categoryItems = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            categoryItems.add(new CategoryItem().setName("Category " + (i + 1)));
        }

        getViewState().setCategoryItems(categoryItems);
    }

    @Override
    public void requestLocal() {
        Subscription subscription =
                MainStore.getInstance()
                        .getVendorStore()
                        .getVendorList()
                        .compose(CommonTransformer.applyStandardSchedulers())
                        .subscribe(result -> HomeDataBridge.injectViewState(getViewState(), result), Throwable::printStackTrace);

        addSubscription(subscription);
    }

    @Override
    public void requestLocalMenu() {
        List<SearchItem> localMenuItems = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            SearchItem searchItem = new SearchItem();
            searchItem.setTitle("Menu " + (i + 1));
            searchItem.setScore(i + ".0");
            searchItem.setDescription(((i + 1) * 10000) + " IDR");
            localMenuItems.add(searchItem);
        }

        getViewState().setLocalMenuItems(localMenuItems);
    }
}
