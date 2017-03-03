package com.abangfadli.monic.framework.view.viewgroup;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by ahmadfadli on 9/11/16.
 */

public class MonicRelativeLayout
        extends RelativeLayout {

    protected Context mContext;

    public MonicRelativeLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MonicRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;

        onSetupView();
        onSetupState(attrs);
        onSetupListener();
    }

    protected void onSetupView() {}

    protected void onSetupState(AttributeSet attrs) {}

    protected void onSetupListener() {}

    protected void setContentView(@LayoutRes int layoutRes) {
        removeAllViews();
        LayoutInflater.from(mContext).inflate(layoutRes, this, true);
    }

    protected void setContentView(View view) {
        removeAllViews();
        addView(view);
    }
}

