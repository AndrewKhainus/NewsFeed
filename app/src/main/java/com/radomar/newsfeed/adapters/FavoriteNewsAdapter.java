package com.radomar.newsfeed.adapters;

import android.view.View;
import android.view.ViewGroup;

import com.radomar.newsfeed.data.model.NewsModel;
import com.radomar.newsfeed.view_holders.FavoriteNewsViewHolder;

/**
 * Created by Село on 16.05.2017.
 */

public class FavoriteNewsAdapter extends BaseAdapter<NewsModel, FavoriteNewsViewHolder> {

    @Override
    public FavoriteNewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FavoriteNewsViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(FavoriteNewsViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);

        final NewsModel newsModel = mData.get(position);
        holder.ivDelete.setOnClickListener(v -> {
            if (mListener != null) {
                mListener.onItemDelete(newsModel.getId());
                mData.remove(newsModel);
                notifyItemRemoved(holder.getAdapterPosition());
            }
        });

        holder.tvLink.setOnClickListener(v -> {
            if (mListener != null) {
                mListener.onLinkClick(newsModel.getLinkUrl());
            }
        });
    }
}
