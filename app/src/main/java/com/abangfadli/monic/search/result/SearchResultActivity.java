package com.abangfadli.monic.search.result;

import android.databinding.Observable;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;

import com.abangfadli.monic.BR;
import com.abangfadli.monic.R;
import com.abangfadli.monic.common.widget.SearchItemAdapter;
import com.abangfadli.monic.databinding.SearchResultActivityBinding;
import com.abangfadli.monic.framework.view.MonicActivity;
import com.abangfadli.monic.search.filter.SearchFilterDialog;
import com.abangfadli.monic.search.filter.SearchFilterDialogListener;
import com.abangfadli.monic.search.result.contract.ISearchResultPresenter;
import com.abangfadli.monic.search.result.contract.ISearchResultView;
import com.abangfadli.monic.search.sort.SearchSortDialog;
import com.abangfadli.monic.search.sort.SearchSortDialogListener;

import java.util.ArrayList;

/**
 * Created by ahmadfadli on 9/11/16.
 */

public class SearchResultActivity
        extends MonicActivity<ISearchResultPresenter, SearchResultViewState>
        implements ISearchResultView {

    protected SearchResultActivityBinding mBinding;

    protected GridLayoutManager mLayoutManager;
    protected SearchItemAdapter mAdapter;

    private final static int COLUMN_SPAN = 3;

    @Override
    public ISearchResultPresenter createPresenter() {
        return new SearchResultPresenter();
    }

    @Override
    protected void onSetupView() {
        super.onSetupView();
        mBinding = setBindView(R.layout.search_result_activity);
    }

    @Override
    protected void onSetupState(Bundle savedInstanceState) {
        super.onSetupState(savedInstanceState);
        mAdapter = new SearchItemAdapter(this, new ArrayList<>());
        mLayoutManager = new GridLayoutManager(this, SearchResultActivity.COLUMN_SPAN);

        mBinding.recyclerViewSearchResult.setHasFixedSize(true);
        mBinding.recyclerViewSearchResult.setLayoutManager(mLayoutManager);
        mBinding.recyclerViewSearchResult.setAdapter(mAdapter);

        registerOnClickListener(mBinding.buttonFilter, mBinding.buttonSort);
    }

    @Override
    protected void onStart() {
        super.onStart();
        getPresenter().search();
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        if(v.equals(mBinding.buttonFilter)) {
            openFilterDialog();
        } else if(v.equals(mBinding.buttonSort)) {
            openSortDialog();
        }
    }

    @Override
    public void onViewStateChanged(Observable observable, int property) {
        super.onViewStateChanged(observable, property);
        if (property == BR.searchItemList || property == BR._all) {
            mAdapter.updateList(getViewState().getSearchItemList());
        }
    }

    void openFilterDialog() {
        SearchFilterDialog dialog = new SearchFilterDialog(this, new SearchFilterDialogListener.EmptyImpl());
        dialog.show();
    }

    void openSortDialog() {
        SearchSortDialog dialog = new SearchSortDialog(this, new SearchSortDialogListener.EmptyImpl());
        dialog.show();
    }
}
