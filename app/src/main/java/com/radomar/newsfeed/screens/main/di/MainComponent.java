package com.radomar.newsfeed.screens.main.di;

import com.radomar.newsfeed.di.ActivityScope;
import com.radomar.newsfeed.di.AppComponent;
import com.radomar.newsfeed.screens.main.MainActivity;
import com.radomar.newsfeed.screens.main.MainPresenter;

import dagger.Component;

/**
 * Created by Radomar on 15.05.2017.
 */

@ActivityScope
@Component(dependencies = {AppComponent.class}, modules = {MainModule.class})
public interface MainComponent {
    void inject(MainActivity mainActivity);
}
