package com.abangfadli.monic.framework;

import android.databinding.BaseObservable;

/**
 * Created by ahmadfadli on 12/18/16.
 */

public abstract class MonicViewState extends BaseObservable {
    public void addOnStateChangeListener(OnPropertyChangedCallback onPropertyChangedCallback) {
        addOnPropertyChangedCallback(onPropertyChangedCallback);
    }

    public void removeStateChangeListener(OnPropertyChangedCallback onPropertyChangedCallback) {
        removeOnPropertyChangedCallback(onPropertyChangedCallback);
    }
}
