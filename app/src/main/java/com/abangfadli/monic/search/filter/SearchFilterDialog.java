package com.abangfadli.monic.search.filter;

import android.content.Context;
import android.os.Bundle;

import com.abangfadli.monic.R;
import com.abangfadli.monic.framework.view.dialog.MonicDialog;
import com.abangfadli.monic.search.filter.contract.ISearchFilterPresenter;
import com.abangfadli.monic.search.filter.contract.ISearchFilterView;

/**
 * Created by ahmadfadli on 9/11/16.
 */

public class SearchFilterDialog
        extends MonicDialog<ISearchFilterPresenter, SearchFilterDialogListener>
        implements ISearchFilterView {

    public SearchFilterDialog(Context context, SearchFilterDialogListener listener) {
        super(context, listener);
    }

    @Override
    public ISearchFilterPresenter createPresenter() {
        return new SearchFilterPresenter();
    }

    @Override
    protected void onSetupView() {
        super.onSetupView();
        setContentView(R.layout.dialog_filter);
    }

    @Override
    protected void onSetupState(Bundle savedInstanceState) {
        super.onSetupState(savedInstanceState);
        setFullScreen();
    }
}
