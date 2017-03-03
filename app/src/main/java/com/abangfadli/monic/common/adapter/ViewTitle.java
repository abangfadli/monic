package com.abangfadli.monic.common.adapter;

import android.view.View;

/**
 * Created by ahmadfadli on 3/26/16.
 */
public class ViewTitle {
    private View view;
    private String title;

    public ViewTitle(View view, String title) {
        this.view = view;
        this.title = title;
    }

    public View getView() {
        return view;
    }

    public String getTitle() {
        return title;
    }
}
