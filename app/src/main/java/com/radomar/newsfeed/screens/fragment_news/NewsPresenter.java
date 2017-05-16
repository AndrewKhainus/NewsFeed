package com.radomar.newsfeed.screens.fragment_news;

import android.content.Intent;
import android.net.Uri;

import com.radomar.newsfeed.adapters.NewsAdapter;
import com.radomar.newsfeed.data.database.DataProvider;
import com.radomar.newsfeed.data.database.RealmDataProvider;
import com.radomar.newsfeed.data.model.NewsModel;
import com.radomar.newsfeed.network.RestApiClient;
import com.radomar.newsfeed.network.responses.NewsResponse;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Andrew on 16.05.2017.
 */

public class NewsPresenter extends NewsContract.Presenter<NewsContract.View> {

    private RestApiClient restApiClient;
    private DataProvider mProvider;

    @Inject
    public NewsPresenter(RestApiClient restApiClient) {
        this.restApiClient = restApiClient;
        mProvider = new RealmDataProvider();
    }

    @Override
    public void onViewCreated() {
        super.onViewCreated();

        initDataStorage();

        view.showProgress();
        addSubscription(restApiClient.newsRestService()
                .getLatestNews("ars-technica")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<NewsResponse>() {
                    @Override
                    public void accept(@NonNull NewsResponse newsResponse) throws Exception {
                        view.hideProgress();
                        //save to DB
                        mProvider.saveNews(newsResponse.getRModels(), "ars-technica");

                        //read from DB
                        List<NewsModel> newsModels =  mProvider.getNews(newsResponse.getSource());

                        //show items
                        view.showNews(newsModels);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
//                        TODO create normal ErrorHandler
                        view.hideProgress();
                        view.showError();
                        List<NewsModel> news = mProvider.getNews("ars-technica");
                        view.showNews(news);
                    }
                }));
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
