package com.radomar.newsfeed.view_holders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.radomar.newsfeed.R;
import com.radomar.newsfeed.data.model.NewsModel;
import com.squareup.picasso.Picasso;

import butterknife.BindView;

/**
 * Created by Radomar on 16.05.2017.
 */

public class NewsViewHolder extends BaseViewHolder<NewsModel> {

    @BindView(R.id.ivImage_IN)
    public ImageView ivImage;

    @BindView(R.id.tvTitle_IN)
    public TextView tvTitle;

    @BindView(R.id.tvDescription_IN)
    public TextView tvDescription;

    @BindView(R.id.tvAuthor_IN)
    public TextView tvAuthor;

    @BindView(R.id.tvLink_IN)
    public TextView tvLink;

    @BindView(R.id.ivLike_IN)
    public ImageView ivLike;

    public NewsViewHolder(ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false));
    }

    @Override
    public void bind(NewsModel dataObject) {
        Picasso.with(itemView.getContext()).load(dataObject.getUrlToImage()).into(ivImage);

        tvAuthor.setText(dataObject.getAuthor());
        tvTitle.setText(dataObject.getTitle());
        tvDescription.setText(dataObject.getDescription());
        tvLink.setText(dataObject.getLinkUrl());
    }
}
