package com.abangfadli.monic.home.category;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.abangfadli.monic.framework.adapter.adapterdelegate.AbsVHDelegate;
import com.abangfadli.monic.framework.adapter.adapterdelegate.DelegationAdapter;

import java.util.List;

/**
 * Created by ahmadfadli on 9/11/16.
 */

public class CategoryItemAdapter extends DelegationAdapter<CategoryItem> {

    public CategoryItemAdapter(Context context, List<CategoryItem> items) {
        super(items);
        addDelegate(new ViewHolderDelegate(context));
    }

    public void updateList(List<CategoryItem> items) {
        setitemList(items);
        notifyDataSetChanged();
    }

    public static class ViewHolderDelegate extends AbsVHDelegate<CategoryItem, ViewHolder> {

        public ViewHolderDelegate(Context context) {
            super(context);
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
            return new ViewHolder(getContext());
        }

        @Override
        public boolean isEligible(List<CategoryItem> list, int position) {
            return true;
        }

        @Override
        protected void onBindViewHolder(ViewHolder viewHolder, List<CategoryItem> list, int position) {
            viewHolder.bind(list.get(position), null);
        }
    }

    interface Listener {
        void onClick(int position, CategoryItem item);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private Listener mListener;
        private CategoryItemWidget mItemLayout;

        public ViewHolder(Context context) {
            this(new CategoryItemWidget(context));
        }

        ViewHolder(CategoryItemWidget categoryItemWidget) {
            super(categoryItemWidget);
            mItemLayout = categoryItemWidget;

            mItemLayout.setOnClickListener(v -> {
                if (mListener != null) {
                    mListener.onClick(getAdapterPosition(), mItemLayout.getViewState());
                }
            });
        }

        void bind(CategoryItem item, Listener listener) {
            mItemLayout.setViewState(item);
            mListener = listener;
        }

    }
}
