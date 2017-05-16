package com.radomar.newsfeed.screens.splash.di;

import com.radomar.newsfeed.di.ActivityScope;
import com.radomar.newsfeed.screens.splash.SplashContract;
import com.radomar.newsfeed.screens.splash.SplashPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Radomar on 15.05.2017.
 */

@Module
public class SplashModule {

    @Provides
    @ActivityScope
    public SplashContract.Presenter injectSplashPresenter() {
        return new SplashPresenter();
    }
}
