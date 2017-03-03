package com.abangfadli.monic.example;

import com.abangfadli.monic.framework.view.MonicActivity;
import com.abangfadli.monic.example.contract.IExamplePresenter;
import com.abangfadli.monic.example.contract.IExampleView;

/**
 * Created by ahmadfadli on 9/11/16.
 */

public class ExampleActivity
        extends MonicActivity<IExamplePresenter, ExampleViewState>
        implements IExampleView {

    @Override
    public IExamplePresenter createPresenter() {
        return new ExamplePresenter();
    }


}
