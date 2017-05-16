package com.radomar.newsfeed.screens.activity_main.di;

import com.radomar.newsfeed.di.ActivityScope;
import com.radomar.newsfeed.network.RestApiClient;
import com.radomar.newsfeed.screens.activity_main.MainContract;
import com.radomar.newsfeed.screens.activity_main.MainPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Radomar on 15.05.2017.
 */


@Module
public class MainModule {

    @Provides
    @ActivityScope
    public MainContract.Presenter provideMainPresenter(RestApiClient restApiClient) {
        return new MainPresenter(restApiClient);
    }
}
