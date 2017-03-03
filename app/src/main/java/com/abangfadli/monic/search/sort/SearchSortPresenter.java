package com.abangfadli.monic.search.sort;

import com.abangfadli.monic.framework.presenter.MonicPresenter;
import com.abangfadli.monic.search.sort.contract.ISearchSortPresenter;
import com.abangfadli.monic.search.sort.contract.ISearchSortView;

/**
 * Created by ahmadfadli on 9/11/16.
 */

public class SearchSortPresenter
        extends MonicPresenter<ISearchSortView, SearchSortViewState>
        implements ISearchSortPresenter {

    @Override
    protected SearchSortViewState createViewState() {
        return new SearchSortViewState();
    }
}
