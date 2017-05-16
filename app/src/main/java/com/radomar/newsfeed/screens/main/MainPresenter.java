package com.radomar.newsfeed.screens.main;

import android.util.Log;
import android.widget.Toast;

import com.radomar.newsfeed.network.RestApiClient;
import com.radomar.newsfeed.network.responses.NewsResponse;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Село on 15.05.2017.
 */

public class MainPresenter extends MainContract.Presenter<MainContract.View> {

    private RestApiClient restApiClient;

    @Inject
    public MainPresenter(RestApiClient restApiClient) {
        this.restApiClient = restApiClient;
    }

    @Override
    public void onViewCreated() {
        super.onViewCreated();
        addSubscription(restApiClient.newsRestService()
                .getLatestNews("abc-news-au")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<NewsResponse>() {
                    @Override
                    public void accept(@NonNull NewsResponse newsResponse) throws Exception {

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {

                    }
                }));
    }
}
