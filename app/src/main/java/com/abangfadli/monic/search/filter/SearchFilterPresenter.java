package com.abangfadli.monic.search.filter;

import com.abangfadli.monic.framework.presenter.MonicPresenter;
import com.abangfadli.monic.search.filter.contract.ISearchFilterPresenter;
import com.abangfadli.monic.search.filter.contract.ISearchFilterView;

/**
 * Created by ahmadfadli on 9/11/16.
 */

public class SearchFilterPresenter
        extends MonicPresenter<ISearchFilterView, SearchFilterViewState>
        implements ISearchFilterPresenter {

    @Override
    protected SearchFilterViewState createViewState() {
        return new SearchFilterViewState();
    }
}
