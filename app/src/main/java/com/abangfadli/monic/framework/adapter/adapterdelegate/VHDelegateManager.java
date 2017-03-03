package com.abangfadli.monic.framework.adapter.adapterdelegate;

import android.support.v4.util.ArrayMap;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;
import java.util.Map;

/**
 * Created by ahmadfadli on 8/5/16.
 */
public class VHDelegateManager<T> {

    private Map<Integer, VHDelegate<T>> delegates;

    public VHDelegateManager(){
        delegates = new ArrayMap<>();
    }

    public void addDelegate(VHDelegate<T> delegate) {
        int size = delegates.size();
        delegates.put(size + 1, delegate);
    }

    public void removeDelegate(VHDelegate<T> delegate) {
        delegates.values().remove(delegate);
    }

    public int getItemViewType(List<T> list, int position) {
        for (Map.Entry<Integer, VHDelegate<T>> entry : delegates.entrySet()) {
            if(entry.getValue().isEligible(list, position)) {
                return entry.getKey();
            }
        }

        throw new IllegalArgumentException("No delegate can handle given item: " + list.get(position).toString());
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return getDelegateForType(viewType).onCreateViewHolder(parent);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, List<T> list, int position) {
        getDelegateForType(viewHolder.getItemViewType()).bindViewHolder(viewHolder, list, position);
    }

    private VHDelegate<T> getDelegateForType(int type) {
        return delegates.get(type);
    }
}
