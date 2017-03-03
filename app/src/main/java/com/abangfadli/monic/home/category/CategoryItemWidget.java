package com.abangfadli.monic.home.category;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import com.abangfadli.monic.R;
import com.abangfadli.monic.databinding.CategoryItemWidgetBinding;
import com.abangfadli.monic.framework.view.viewgroup.MonicRelativeLayout;

/**
 * Created by ahmadfadli on 9/11/16.
 */

public class CategoryItemWidget extends MonicRelativeLayout {

    private CategoryItemWidgetBinding mBinding;

    public static CategoryItemWidget create(Context context, CategoryItem categoryItem) {
        CategoryItemWidget categoryItemWidget = new CategoryItemWidget(context);
        categoryItemWidget.setViewState(categoryItem);

        return categoryItemWidget;
    }


    public CategoryItemWidget(Context context) {
        this(context, null);
    }

    public CategoryItemWidget(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onSetupView() {
        super.onSetupView();
        View view = LayoutInflater.from(getContext()).inflate(R.layout.category_item_widget, this, false);
        if (!isInEditMode()) {
            mBinding = DataBindingUtil.bind(view);
        }

        addView(view);

    }

    public void setViewState(CategoryItem item) {
        mBinding.setViewState(item);
        mBinding.executePendingBindings();
    }

    public CategoryItem getViewState() {
        return mBinding.getViewState();
    }
}
