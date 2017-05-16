package com.radomar.newsfeed.screens.fragment_news.di;

import com.radomar.newsfeed.di.FragmentScope;
import com.radomar.newsfeed.network.RestApiClient;
import com.radomar.newsfeed.screens.fragment_news.NewsContract;
import com.radomar.newsfeed.screens.fragment_news.NewsPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Andrew on 16.05.2017.
 */

@Module
public class NewsModule {

    @Provides
    @FragmentScope
    public NewsContract.Presenter provideNewsPresenter(RestApiClient restApiClient) {
        return new NewsPresenter(restApiClient);
    }
}
