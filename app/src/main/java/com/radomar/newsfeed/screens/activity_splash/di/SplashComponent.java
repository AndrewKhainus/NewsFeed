package com.radomar.newsfeed.screens.activity_splash.di;

import com.radomar.newsfeed.di.ActivityScope;
import com.radomar.newsfeed.di.AppComponent;
import com.radomar.newsfeed.screens.activity_splash.SplashActivity;

import dagger.Component;

/**
 * Created by Radomar on 15.05.2017.
 */

@ActivityScope
@Component(dependencies = {AppComponent.class}, modules = {SplashModule.class})
public interface SplashComponent {
    void inject(SplashActivity activity);
}
