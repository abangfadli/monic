package com.abangfadli.monic.search.filter;

import com.abangfadli.monic.framework.view.dialog.DialogListener;
import com.abangfadli.monic.framework.view.dialog.EmptyDialogListener;

/**
 * Created by ahmadfadli on 9/11/16.
 */

public interface SearchFilterDialogListener extends DialogListener {


    class EmptyImpl extends EmptyDialogListener implements SearchFilterDialogListener {

    }
}
