package com.abangfadli.monic.framework.adapter.adapterdelegate;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by ahmadfadli on 8/5/16.
 */
public interface VHDelegate<T> {
    RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent);

    boolean isEligible(List<T> list, int position);

    void bindViewHolder(RecyclerView.ViewHolder viewHolder, List<T> list, int position);
}
