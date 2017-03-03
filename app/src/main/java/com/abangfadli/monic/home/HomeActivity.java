package com.abangfadli.monic.home;

import android.databinding.Observable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.abangfadli.commonutils.converter.UnitConverter;
import com.abangfadli.commonutils.recyclerview.RecyclerViewDecoration;
import com.abangfadli.monic.BR;
import com.abangfadli.monic.R;
import com.abangfadli.monic.common.adapter.BasicPagerAdapter;
import com.abangfadli.monic.common.adapter.ViewTitle;
import com.abangfadli.monic.common.widget.SearchItem;
import com.abangfadli.monic.common.widget.SearchItemAdapter;
import com.abangfadli.monic.databinding.HomeActivityBinding;
import com.abangfadli.monic.framework.view.MonicActivity;
import com.abangfadli.monic.home.category.CategoryItem;
import com.abangfadli.monic.home.category.CategoryItemAdapter;
import com.abangfadli.monic.home.contract.IHomePresenter;
import com.abangfadli.monic.home.contract.IHomeView;
import com.abangfadli.monic.home.promo.PromoItem;
import com.abangfadli.monic.home.promo.PromoItemWidget;
import com.abangfadli.monic.search.result.SearchResultNavigator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ahmadfadli on 9/11/16.
 */

public class HomeActivity
        extends MonicActivity<IHomePresenter, HomeViewState>
        implements IHomeView {

    HomeActivityBinding mBinding;

    BasicPagerAdapter mPromoAdapter;
    CategoryItemAdapter mCategoryAdapter;
    SearchItemAdapter mLocalVendorItemAdapter;
    SearchItemAdapter mLocalMenuItemAdapter;

    @Override
    public IHomePresenter createPresenter() {
        return new HomePresenter();
    }

    @Override
    protected void onSetupView() {
        super.onSetupView();
        mBinding = setBindView(R.layout.home_activity);
    }

    @Override
    protected void onSetupState(Bundle savedInstanceState) {
        super.onSetupState(savedInstanceState);

        final int HORIZONTAL_ITEM_SPACING = (int)UnitConverter.dp_px(this, 8);

        mCategoryAdapter = new CategoryItemAdapter(this, new ArrayList<>());
        mBinding.recyclerViewCategory.setAdapter(mCategoryAdapter);
        mBinding.recyclerViewCategory.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mBinding.recyclerViewCategory.setHasFixedSize(true);
        mBinding.recyclerViewCategory.addItemDecoration(new RecyclerViewDecoration.HorizontalSpaceItemDecoration(HORIZONTAL_ITEM_SPACING));

        mLocalVendorItemAdapter = new SearchItemAdapter(this, new ArrayList<>());
        mBinding.recyclerViewLocal.setAdapter(mLocalVendorItemAdapter);
        mBinding.recyclerViewLocal.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mBinding.recyclerViewLocal.setHasFixedSize(true);
        mBinding.recyclerViewLocal.addItemDecoration(new RecyclerViewDecoration.HorizontalSpaceItemDecoration(HORIZONTAL_ITEM_SPACING));

        mLocalMenuItemAdapter = new SearchItemAdapter(this, new ArrayList<>());
        mBinding.recyclerViewLocalMenu.setAdapter(mLocalMenuItemAdapter);
        mBinding.recyclerViewLocalMenu.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mBinding.recyclerViewLocalMenu.setHasFixedSize(true);
        mBinding.recyclerViewLocalMenu.addItemDecoration(new RecyclerViewDecoration.HorizontalSpaceItemDecoration(HORIZONTAL_ITEM_SPACING));

        mPromoAdapter = new BasicPagerAdapter();
        mBinding.viewPagerPromo.setAdapter(mPromoAdapter);

        registerOnClickListener(mBinding.textSeeMore, mBinding.textSeeMoreLocalMenu);
    }

    @Override
    protected void onStart() {
        super.onStart();
        getPresenter().requestPromo();
        getPresenter().requestCategory();
        getPresenter().requestLocal();
        getPresenter().requestLocalMenu();
    }

    @Override
    public void onViewStateChanged(Observable observable, int property) {
        super.onViewStateChanged(observable, property);
        if (property == BR.promoItems || property == BR._all) {
            loadPromoItems(getViewState().getPromoItems());
        }

        if (property == BR.categoryItems || property == BR._all) {
            loadCategoryItems(getViewState().getCategoryItems());
        }

        if (property == BR.localItems || property == BR._all) {
            loadLocalItems(getViewState().getLocalItems());
        }

        if (property == BR.localMenuItems || property == BR._all) {
            loadLocalMenuItems(getViewState().getLocalMenuItems());
        }
    }

    private void loadPromoItems(List<PromoItem> promoItems) {
        mPromoAdapter.removeAllView(mBinding.viewPagerPromo);
        for (PromoItem promoItem : promoItems) {
            mPromoAdapter.addView(new ViewTitle(PromoItemWidget.create(this, promoItem), promoItem.getText()));
        }

        mPromoAdapter.notifyDataSetChanged();
    }

    private void loadCategoryItems(List<CategoryItem> categoryItems) {
        mCategoryAdapter.updateList(categoryItems);
    }

    private void loadLocalItems(List<SearchItem> localItems) {
        mLocalVendorItemAdapter.updateList(localItems);
    }

    private void loadLocalMenuItems(List<SearchItem> localMenuItems) {
        mLocalMenuItemAdapter.updateList(localMenuItems);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        if (v.equals(mBinding.textSeeMore)) {
            new SearchResultNavigator(this).navigate(this);
        } else if (v.equals(mBinding.textSeeMoreLocalMenu)) {
            new SearchResultNavigator(this).navigate(this);
        }
    }
}
