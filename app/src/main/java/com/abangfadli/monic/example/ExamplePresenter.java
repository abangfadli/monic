package com.abangfadli.monic.example;

import com.abangfadli.monic.framework.presenter.MonicPresenter;
import com.abangfadli.monic.example.contract.IExamplePresenter;
import com.abangfadli.monic.example.contract.IExampleView;

/**
 * Created by ahmadfadli on 9/11/16.
 */

public class ExamplePresenter
        extends MonicPresenter<IExampleView, ExampleViewState>
        implements IExamplePresenter {

    @Override
    protected ExampleViewState createViewState() {
        return new ExampleViewState();
    }
}
