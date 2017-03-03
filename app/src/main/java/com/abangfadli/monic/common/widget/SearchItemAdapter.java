package com.abangfadli.monic.common.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.abangfadli.monic.framework.adapter.adapterdelegate.AbsVHDelegate;
import com.abangfadli.monic.framework.adapter.adapterdelegate.DelegationAdapter;

import java.util.List;

/**
 * Created by ahmadfadli on 12/28/16.
 */

public class SearchItemAdapter extends DelegationAdapter<SearchItem> {

    public SearchItemAdapter(Context context, List<SearchItem> items) {
        super(items);
        addDelegate(new ViewHolderDelegate(context));
    }

    public void updateList(List<SearchItem> items) {
        setitemList(items);
        notifyDataSetChanged();
    }


    private class ViewHolderDelegate extends AbsVHDelegate<SearchItem, ViewHolder> {

        public ViewHolderDelegate(Context context) {
            super(context);
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
            return new ViewHolder(getContext());
        }

        @Override
        public boolean isEligible(List<SearchItem> list, int position) {
            return true;
        }

        @Override
        protected void onBindViewHolder(ViewHolder viewHolder, List<SearchItem> list, int position) {
            viewHolder.bind(list.get(position), null);
        }
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        private Listener mListener;
        private SearchItemWidget mItemLayout;

        public ViewHolder(Context context) {
            this(new SearchItemWidget(context));
        }

        ViewHolder(SearchItemWidget categoryItemWidget) {
            super(categoryItemWidget);
            mItemLayout = categoryItemWidget;

            mItemLayout.setOnClickListener(v -> {
                if (mListener != null) {
                    mListener.onClick(getAdapterPosition(), mItemLayout.getViewState());
                }
            });
        }

        void bind(SearchItem item, Listener listener) {
            mItemLayout.setViewState(item);
            mListener = listener;
        }
    }

    interface Listener {
        void onClick(int position, SearchItem item);
    }
}
