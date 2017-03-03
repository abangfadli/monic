package com.abangfadli.monic.framework.view.dialog;

/**
 * Created by ahmadfadli on 9/11/16.
 */

public interface DialogListener {
    void onStart(MonicDialog dialog);
    void onCancel(MonicDialog dialog);
    void onComplete(MonicDialog dialog);
    void onDismiss(MonicDialog dialog);
}
