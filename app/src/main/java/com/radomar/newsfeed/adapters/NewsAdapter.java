package com.radomar.newsfeed.adapters;

import android.view.ViewGroup;

import com.radomar.newsfeed.data.model.NewsModel;
import com.radomar.newsfeed.view_holders.NewsViewHolder;

/**
 * Created by Radomar on 16.05.2017.
 */

public class NewsAdapter extends BaseAdapter<NewsModel, NewsViewHolder> {

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NewsViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);

        final NewsModel newsModel = mData.get(position);
        holder.ivLike.setOnClickListener(v -> {
            if (mListener != null) {
                mListener.onLikeClick(newsModel.getId());
            }
        });
        holder.tvLink.setOnClickListener(v -> {
            if (mListener != null) {
                mListener.onLinkClick(newsModel.getLinkUrl());
            }
        });
    }
}
