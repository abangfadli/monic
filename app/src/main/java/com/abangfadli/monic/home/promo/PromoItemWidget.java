package com.abangfadli.monic.home.promo;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import com.abangfadli.monic.R;
import com.abangfadli.monic.databinding.PromoItemWidgetBinding;
import com.abangfadli.monic.framework.view.viewgroup.MonicFrameLayout;

/**
 * Created by ahmadfadli on 12/18/16.
 */

public class PromoItemWidget extends MonicFrameLayout {

    private PromoItemWidgetBinding mBinding;

    public static PromoItemWidget create(Context context, PromoItem promoItem) {
        PromoItemWidget promoItemWidget = new PromoItemWidget(context);
        promoItemWidget.setViewState(promoItem);

        return promoItemWidget;
    }

    public PromoItemWidget(Context context) {
        this(context, null);
    }

    public PromoItemWidget(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onSetupView() {
        super.onSetupView();
        View view = LayoutInflater.from(getContext()).inflate(R.layout.promo_item_widget, this, false);
        if (!isInEditMode()) {
            mBinding = DataBindingUtil.bind(view);
        }

        addView(view);

    }


    public void setViewState(PromoItem promoItem) {
        mBinding.setViewState(promoItem);
        mBinding.executePendingBindings();
    }
}
