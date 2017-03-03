package com.abangfadli.monic.common;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ahmadfadli on 2/21/17.
 */

public class CommonTransformer {

    private final static Observable.Transformer<Object, Object> scheduleTransformer = observable -> observable
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread());

    @SuppressWarnings("unchecked")
    public static <T> Observable.Transformer<T, T> applyStandardSchedulers() {
        return (Observable.Transformer<T, T>) scheduleTransformer;
    }

}
