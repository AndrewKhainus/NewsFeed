package com.radomar.newsfeed.di;

import android.content.Context;

import com.radomar.newsfeed.App;
import com.radomar.newsfeed.network.RestApiClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Andrew on 15.05.2017.
 */

@Module
public class AppModule {

    private App application;

    public AppModule(App application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideContext(){
        return application.getApplicationContext();
    }

    @Provides
    public RestApiClient provideRestClient() {
        return RestApiClient.getInstance();
    }
}
