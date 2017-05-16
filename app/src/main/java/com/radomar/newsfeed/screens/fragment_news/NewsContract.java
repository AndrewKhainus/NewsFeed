package com.radomar.newsfeed.screens.fragment_news;

import com.radomar.newsfeed.data.model.NewsModel;
import com.radomar.newsfeed.screens.base.BaseContract;

import java.util.List;

/**
 * Created by Andrew on 16.05.2017.
 */

public interface NewsContract {
    interface View<P extends Presenter> extends BaseContract.View<P>{
        void showError();

        void showNews(List<NewsModel> news);

        void showProgress();

        void hideProgress();

        String getSource();

        void showEmptyList();
    }

    abstract class Presenter<V extends View> extends BaseContract.Presenter<V> {
        abstract void onItemLiked(int newsId);

        abstract void onItemDelete(int newsId);
    }
}
