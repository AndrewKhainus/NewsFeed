package com.radomar.newsfeed.screens.activity_main.di;

import com.radomar.newsfeed.di.ActivityScope;
import com.radomar.newsfeed.di.AppComponent;
import com.radomar.newsfeed.screens.activity_main.MainActivity;

import dagger.Component;

/**
 * Created by Radomar on 15.05.2017.
 */

@ActivityScope
@Component(dependencies = {AppComponent.class}, modules = {MainModule.class})
public interface MainComponent {
    void inject(MainActivity mainActivity);
}
