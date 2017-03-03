package com.abangfadli.monic.search.result;

import android.databinding.Bindable;

import com.abangfadli.monic.BR;
import com.abangfadli.monic.common.widget.SearchItem;
import com.abangfadli.monic.framework.MonicViewState;

import org.parceler.Parcel;

import java.util.List;

/**
 * Created by ahmadfadli on 12/18/16.
 */

@Parcel
public class SearchResultViewState extends MonicViewState {
    protected List<SearchItem> searchItemList;

    @Bindable
    public List<SearchItem> getSearchItemList() {
        return searchItemList;
    }

    public SearchResultViewState setSearchItemList(List<SearchItem> searchItemList) {
        this.searchItemList = searchItemList;
        notifyPropertyChanged(BR.searchItemList);
        return this;
    }
}
