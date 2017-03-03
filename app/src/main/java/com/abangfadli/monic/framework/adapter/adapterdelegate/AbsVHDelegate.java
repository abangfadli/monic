package com.abangfadli.monic.framework.adapter.adapterdelegate;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by ahmadfadli on 8/5/16.
 */
public abstract class AbsVHDelegate<T, VH extends RecyclerView.ViewHolder> implements VHDelegate<T> {

    private Context mContext;

    public AbsVHDelegate(Context context) {
        mContext = context;
    }

    protected Context getContext() {
        return mContext;
    }

    @Override
    public void bindViewHolder(RecyclerView.ViewHolder viewHolder, List<T> list, int position) {
        onBindViewHolder((VH)viewHolder, list, position);
    }

    protected abstract void onBindViewHolder(VH viewHolder, List<T> list, int position);
}
