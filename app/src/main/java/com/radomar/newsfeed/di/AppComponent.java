package com.radomar.newsfeed.di;

import com.radomar.newsfeed.App;
import com.radomar.newsfeed.data.shared_Preferences.PreferenceController;
import com.radomar.newsfeed.network.RestApiClient;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Andrew on 15.05.2017.
 */

@Singleton
@Component(modules = {AppModule.class, AndroidModule.class})
public interface AppComponent {

    void inject(App application);

    RestApiClient getRestClient();

    PreferenceController getPreferenceController();
}
