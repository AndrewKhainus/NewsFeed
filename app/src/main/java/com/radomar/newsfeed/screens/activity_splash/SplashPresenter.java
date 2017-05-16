package com.radomar.newsfeed.screens.activity_splash;

/**
 * Created by Andrew on 15.05.2017.
 */

public class SplashPresenter extends SplashContract.Presenter<SplashContract.View> {
    private static final long SPLASH_DELAY = 3000;

    @Override
    public void onViewCreated() {
        super.onViewCreated();

        view.startActivityWithDelay(SPLASH_DELAY);
    }
}
