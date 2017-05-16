package com.radomar.newsfeed.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.radomar.newsfeed.R;
import com.radomar.newsfeed.data.model.NewsModel;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Andrew on 16.05.2017.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private List<NewsModel> news = new ArrayList<>();
    private ActionCallback actionCallback;

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public void setData(List<NewsModel> news) {
        this.news = news;
        notifyDataSetChanged();
    }

    public void setActionCallback(ActionCallback actionCallback) {
        this.actionCallback = actionCallback;
    }

    class NewsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ivImage_IN)
        ImageView ivImage;

        @BindView(R.id.tvTitle_IN)
        TextView tvTitle;

        @BindView(R.id.tvDescription_IN)
        TextView tvDescription;

        @BindView(R.id.tvAuthor_IN)
        TextView tvAuthor;

        @BindView(R.id.tvLink_IN)
        TextView tvLink;

        public NewsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(int position) {
            NewsModel newsModel = news.get(position);

            Picasso.with(itemView.getContext()).load(newsModel.getUrlToImage()).into(ivImage);
            tvAuthor.setText(newsModel.getAuthor());
            tvTitle.setText(newsModel.getTitle());
            tvDescription.setText(newsModel.getDescription());
            tvLink.setText(newsModel.getLinkUrl());
        }

        @OnClick(R.id.tvLink_IN)
        void onLinkClick() {
            if (actionCallback != null) {
                actionCallback.onLinkClick(tvLink.getText().toString());
            }
        }

        @OnClick(R.id.ivLike_IN)
        void onLikeClick() {
            if (actionCallback != null) {
                actionCallback.onLikeClick(news.get(getAdapterPosition()).getAuthor());
            }
        }
    }

    public interface ActionCallback {
        void onLinkClick(String link);

        void onLikeClick(int newsId);
    }
}
