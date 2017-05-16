package com.radomar.newsfeed.screens.fragment_news;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.radomar.newsfeed.R;
import com.radomar.newsfeed.adapters.BaseAdapter;
import com.radomar.newsfeed.adapters.FavoriteNewsAdapter;
import com.radomar.newsfeed.adapters.NewsAdapter;
import com.radomar.newsfeed.adapters.NewsEventListener;
import com.radomar.newsfeed.data.model.NewsModel;
import com.radomar.newsfeed.di.AppComponent;
import com.radomar.newsfeed.screens.base.BaseFragment;
import com.radomar.newsfeed.screens.fragment_news.di.DaggerNewsComponent;
import com.radomar.newsfeed.utils.SnackBarUtils;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Andrew on 16.05.2017.
 */

public class NewsFragment extends BaseFragment<NewsContract.Presenter> implements NewsContract.View<NewsContract.Presenter>, NewsEventListener {

    @BindView(R.id.rvNews_FN)
    RecyclerView rvNews;

    @BindView(R.id.clRoot_FN)
    CoordinatorLayout rootView;

    @BindView(R.id.pbProgress_FN)
    ProgressBar progressBar;

    @BindView(R.id.tvEmptyList_FN)
    TextView tvEmptyList;

    private BaseAdapter newsAdapter;

    private String source;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        source = getArguments().getString("key");
        if (TextUtils.equals(source, "favorite")) {
            newsAdapter = new FavoriteNewsAdapter();
        } else {
            newsAdapter = new NewsAdapter();
        }
        newsAdapter.setListener(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvNews.setAdapter(newsAdapter);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_news;
    }

    @Override
    public void setupComponent(AppComponent appComponent) {
        DaggerNewsComponent.builder()
                .appComponent(appComponent)
                .build()
                .inject(this);
    }

    @Override
    public void showError() {
        SnackBarUtils.showError(rootView, R.string.error_connection);
    }

    @Override
    public void showNews(List<NewsModel> news) {
        newsAdapter.setData(news);
        tvEmptyList.setVisibility(View.GONE);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        tvEmptyList.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public String getSource() {
        return source;
    }

    @Override
    public void showEmptyList() {
        progressBar.setVisibility(View.GONE);
        tvEmptyList.setVisibility(View.VISIBLE);
    }

    @Override
    public void onLinkClick(String link) {
        Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse(link));
        startActivity(intent);
    }

    @Override
    public void onLikeClick(int newsId) {
        Toast.makeText(getContext(), "like id = " + newsId, Toast.LENGTH_SHORT).show();
        presenter.onItemLiked(newsId);
    }

    @Override
    public void onItemDelete(int newsId) {
        presenter.onItemDelete(newsId);
    }

}
