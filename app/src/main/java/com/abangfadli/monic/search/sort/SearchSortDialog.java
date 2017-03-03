package com.abangfadli.monic.search.sort;

import android.content.Context;
import android.os.Bundle;

import com.abangfadli.monic.R;
import com.abangfadli.monic.framework.view.dialog.MonicDialog;
import com.abangfadli.monic.search.sort.contract.ISearchSortPresenter;
import com.abangfadli.monic.search.sort.contract.ISearchSortView;

/**
 * Created by ahmadfadli on 9/11/16.
 */

public class SearchSortDialog
        extends MonicDialog<ISearchSortPresenter, SearchSortDialogListener>
        implements ISearchSortView {

    public SearchSortDialog(Context context, SearchSortDialogListener listener) {
        super(context, listener);
    }

    @Override
    public ISearchSortPresenter createPresenter() {
        return new SearchSortPresenter();
    }


    @Override
    protected void onSetupView() {
        super.onSetupView();
        setContentView(R.layout.dialog_sort);
    }

    @Override
    protected void onSetupState(Bundle savedInstanceState) {
        super.onSetupState(savedInstanceState);
        setFullScreen();
    }
}
