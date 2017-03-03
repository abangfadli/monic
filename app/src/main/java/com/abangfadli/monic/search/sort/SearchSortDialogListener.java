package com.abangfadli.monic.search.sort;

import com.abangfadli.monic.framework.view.dialog.DialogListener;
import com.abangfadli.monic.framework.view.dialog.EmptyDialogListener;

/**
 * Created by ahmadfadli on 9/11/16.
 */

public interface SearchSortDialogListener extends DialogListener {

    class EmptyImpl extends EmptyDialogListener implements SearchSortDialogListener {

    }
}
