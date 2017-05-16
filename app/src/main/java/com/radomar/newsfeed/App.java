package com.radomar.newsfeed;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.radomar.newsfeed.di.AndroidModule;
import com.radomar.newsfeed.di.AppComponent;
import com.radomar.newsfeed.di.AppModule;
import com.radomar.newsfeed.di.DaggerAppComponent;

import io.realm.Realm;

/**
 * Created by Andrew on 15.05.2017.
 */

public class App extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .androidModule(new AndroidModule())
                .appModule(new AppModule(this))
                .build();

        Stetho.initializeWithDefaults(this);
        Realm.init(this);
    }

    public AppComponent getAppComponent() {
        return this.appComponent;
    }
}
