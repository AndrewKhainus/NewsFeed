package com.radomar.newsfeed.di;

import android.content.Context;

import com.radomar.newsfeed.data.shared_Preferences.PreferenceController;
import com.radomar.newsfeed.data.shared_Preferences.SharedPreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Andrew on 15.05.2017.
 */


@Module
public class AndroidModule {

    @Provides
    @Singleton
    public PreferenceController providePreferenceController(Context appContext) {
        return new SharedPreferenceManager(appContext);
    }
}
