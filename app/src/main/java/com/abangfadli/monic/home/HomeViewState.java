package com.abangfadli.monic.home;

import android.databinding.Bindable;

import com.abangfadli.monic.BR;
import com.abangfadli.monic.common.widget.SearchItem;
import com.abangfadli.monic.framework.MonicViewState;
import com.abangfadli.monic.home.category.CategoryItem;
import com.abangfadli.monic.home.promo.PromoItem;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ahmadfadli on 12/18/16.
 */

@Parcel
public class HomeViewState extends MonicViewState {
    protected List<PromoItem> promoItems;
    protected List<CategoryItem> categoryItems;
    protected List<SearchItem> localItems;
    protected List<SearchItem> localMenuItems;

    public HomeViewState() {
        promoItems = new ArrayList<>();
        categoryItems = new ArrayList<>();
        localItems = new ArrayList<>();
        localMenuItems = new ArrayList<>();
    }

    @Bindable
    public List<PromoItem> getPromoItems() {
        return promoItems;
    }

    public HomeViewState setPromoItems(List<PromoItem> promoItems) {
        this.promoItems = promoItems;
        notifyPropertyChanged(BR.promoItems);
        return this;
    }

    @Bindable
    public List<CategoryItem> getCategoryItems() {
        return categoryItems;
    }

    public HomeViewState setCategoryItems(List<CategoryItem> categoryItems) {
        this.categoryItems = categoryItems;
        notifyPropertyChanged(BR.categoryItems);
        return this;
    }

    @Bindable
    public List<SearchItem> getLocalItems() {
        return localItems;
    }

    public HomeViewState setLocalItems(List<SearchItem> localItems) {
        this.localItems = localItems;
        notifyPropertyChanged(BR.localItems);
        return this;
    }

    @Bindable
    public List<SearchItem> getLocalMenuItems() {
        return localMenuItems;
    }

    public HomeViewState setLocalMenuItems(List<SearchItem> localMenuItems) {
        this.localMenuItems = localMenuItems;
        notifyPropertyChanged(BR.localMenuItems);
        return this;
    }
}
