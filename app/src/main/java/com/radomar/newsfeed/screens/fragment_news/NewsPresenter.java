package com.radomar.newsfeed.screens.fragment_news;

import com.radomar.newsfeed.data.database.DataProvider;
import com.radomar.newsfeed.data.database.RealmDataProvider;
import com.radomar.newsfeed.data.model.NewsModel;
import com.radomar.newsfeed.network.RestApiClient;
import com.radomar.newsfeed.network.responses.NewsResponse;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Andrew on 16.05.2017.
 */

public class NewsPresenter extends NewsContract.Presenter<NewsContract.View> {

    private RestApiClient restApiClient;
    private DataProvider mProvider;
    private List<NewsModel> data;

    @Inject
    public NewsPresenter(RestApiClient restApiClient) {
        this.restApiClient = restApiClient;
        mProvider = new RealmDataProvider();
    }

    @Override
    public void onViewCreated() {
        super.onViewCreated();
        initDataStorage();
        String source = view.getSource();

        if (source != null) {
            switch (source) {
                case "favorite":
                    downloadFavoriteNews();
                    break;
                default:
                    downloadNewsFromNetwork(source);
            }
        }
    }

    private void downloadNewsFromNetwork(String source) {
        view.showProgress();
        addSubscription(restApiClient.newsRestService()
                .getLatestNews(source)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(newsResponse -> {
                    view.hideProgress();
                    //save to DB
                    mProvider.saveNews(newsResponse.getRModels(), source);

                    //read from DB
                    data = mProvider.getNews(source);

                    //show items
                    showData();
                }, throwable -> {
//                        TODO create normal ErrorHandler
                    view.hideProgress();
                    view.showError();
                    data = mProvider.getNews(source);
                    showData();
                }));
    }

    private void downloadFavoriteNews() {
        data = mProvider.getFavorites();
        showData();
    }

    private void showData() {
        if (data.size() > 0) {
            view.showNews(data);
        } else {
            view.showEmptyList();
        }
    }

    @Override
    void onItemLiked(int newsId) {
        mProvider.saveToFavorites(newsId);
    }

    @Override
    void onItemDelete(int newsId) {
        mProvider.deleteFromFavorites(newsId);
        if (data.size() == 1) {
            view.showEmptyList();
        }
    }

    private void initDataStorage() {
        mProvider.open();
    }

    private void deinitDataStorage() {
        if (mProvider != null) {
            mProvider.close();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        deinitDataStorage();
    }

}
