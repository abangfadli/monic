package com.abangfadli.monic.search.result;

import android.content.Context;
import android.content.Intent;

import com.abangfadli.monic.framework.MonicNavigator;

/**
 * Created by ahmadfadli on 9/11/16.
 */

public class SearchResultNavigator extends MonicNavigator {

    public SearchResultNavigator(Context context) {
        super(context);
    }

    @Override
    protected Intent createIntent() {
        return new Intent(getContext(), SearchResultActivity.class);
    }
}
