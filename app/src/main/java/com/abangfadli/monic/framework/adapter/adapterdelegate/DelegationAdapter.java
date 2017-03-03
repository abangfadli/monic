package com.abangfadli.monic.framework.adapter.adapterdelegate;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ahmadfadli on 8/5/16.
 */
public abstract class DelegationAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private VHDelegateManager<T> vhManager;
    private List<T> items;

    public DelegationAdapter(List<T> items) {
        this.items = new ArrayList<>(items);
        vhManager = new VHDelegateManager<>();
    }

    @Override
    public int getItemViewType(int position) {
        return vhManager.getItemViewType(items, position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return vhManager.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        vhManager.onBindViewHolder(holder, items, position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    protected void addDelegate(VHDelegate<T> delegate) {
        vhManager.addDelegate(delegate);
    }

    protected void removeDelegate(VHDelegate<T> delegate) {
        vhManager.removeDelegate(delegate);
    }

    protected List<T> getItemList() {
        return items;
    }

    protected void setitemList(List<T> itemList) {
        items = itemList;
    }
}
