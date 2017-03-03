package com.abangfadli.monic.framework.view.viewgroup;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * Created by ahmadfadli on 12/18/16.
 */

public class MonicFrameLayout extends FrameLayout {

    public MonicFrameLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MonicFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        onSetupView();
        onSetupState(attrs);
        onSetupListener();
    }

    protected void onSetupView() {}

    protected void onSetupState(AttributeSet attrs) {}

    protected void onSetupListener() {}
}
