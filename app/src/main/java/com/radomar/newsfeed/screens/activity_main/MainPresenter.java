package com.radomar.newsfeed.screens.activity_main;

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
        view.showBbcNews();
    }

    @Override
    void onBbcNewsSelected() {
        view.showBbcNews();
    }

    @Override
    void onBbcSportSelected() {
        view.showBbsSport();
    }

    @Override
    void onArcTechnicaSelected() {
        view.showArcTechnica();
    }

    @Override
    void onFavoriteSelected() {
        view.showFavorite();
    }
}
