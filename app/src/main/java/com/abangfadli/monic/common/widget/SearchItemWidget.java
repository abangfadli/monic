package com.abangfadli.monic.common.widget;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import com.abangfadli.monic.R;
import com.abangfadli.monic.databinding.SearchItemWidgetBinding;
import com.abangfadli.monic.framework.view.viewgroup.MonicFrameLayout;
import com.squareup.picasso.Picasso;

/**
 * Created by ahmadfadli on 12/28/16.
 */

public class SearchItemWidget extends MonicFrameLayout {

    private SearchItemWidgetBinding mBinding;

    public static SearchItemWidget create(Context context, SearchItem searchItem) {
        SearchItemWidget widget = new SearchItemWidget(context);
        widget.setViewState(searchItem);

        return widget;
    }


    public SearchItemWidget(Context context) {
        this(context, null);
    }

    public SearchItemWidget(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onSetupView() {
        super.onSetupView();
        View view = LayoutInflater.from(getContext()).inflate(R.layout.search_item_widget, this, false);
        if (!isInEditMode()) {
            mBinding = DataBindingUtil.bind(view);
        }

        addView(view);

    }

    public void setViewState(SearchItem item) {
        mBinding.setViewState(item);
        mBinding.executePendingBindings();

        Picasso.with(getContext())
                .load(item.getImageUrl())
                .fit()
                .centerCrop()
                .into(mBinding.imageSearchItem);
    }

    public SearchItem getViewState() {
        return mBinding.getViewState();
    }
}
