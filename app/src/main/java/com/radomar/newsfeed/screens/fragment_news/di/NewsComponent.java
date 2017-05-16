package com.radomar.newsfeed.screens.fragment_news.di;

import com.radomar.newsfeed.di.AppComponent;
import com.radomar.newsfeed.di.FragmentScope;
import com.radomar.newsfeed.screens.activity_main.di.MainModule;
import com.radomar.newsfeed.screens.fragment_news.NewsFragment;

import dagger.Component;

/**
 * Created by Andrew on 16.05.2017.
 */

@FragmentScope
@Component(dependencies = {AppComponent.class}, modules = {NewsModule.class})
public interface NewsComponent {
    void inject(NewsFragment newsFragment);
}
