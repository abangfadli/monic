package com.abangfadli.monic.search.result;

import com.abangfadli.monic.common.widget.SearchItem;
import com.abangfadli.monic.framework.presenter.MonicPresenter;
import com.abangfadli.monic.search.result.contract.ISearchResultPresenter;
import com.abangfadli.monic.search.result.contract.ISearchResultView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ahmadfadli on 9/11/16.
 */

public class SearchResultPresenter
        extends MonicPresenter<ISearchResultView, SearchResultViewState>
        implements ISearchResultPresenter {

    @Override
    protected SearchResultViewState createViewState() {
        return new SearchResultViewState();
    }

    @Override
    public void search() {
        List<SearchItem> searchItems = new ArrayList<>();
        for(int i = 0; i < 30; i++) {
            SearchItem searchItem = new SearchItem();
            searchItem.setTitle("Place " + (i + 1));
            searchItem.setScore((i % 10 + 1) + ".0");
            searchItem.setDescription("AVG Cost " + ((i + 1) * 10000) + " IDR");
            searchItems.add(searchItem);
        }

        getViewState().setSearchItemList(searchItems);
    }
}
