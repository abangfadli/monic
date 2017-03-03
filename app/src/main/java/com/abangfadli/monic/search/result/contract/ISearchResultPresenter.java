package com.abangfadli.monic.search.result.contract;

import com.abangfadli.monic.framework.presenter.IMonicPresenter;
import com.abangfadli.monic.search.result.SearchResultViewState;

/**
 * Created by ahmadfadli on 9/11/16.
 */
public interface ISearchResultPresenter extends IMonicPresenter<ISearchResultView, SearchResultViewState> {

    void search();
}
