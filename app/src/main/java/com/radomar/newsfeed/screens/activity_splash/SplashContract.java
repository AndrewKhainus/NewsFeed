package com.radomar.newsfeed.screens.activity_splash;

import com.radomar.newsfeed.screens.base.BaseContract;

/**
 * Created by Andrew on 15.05.2017.
 */

public interface SplashContract {

    interface View<P extends Presenter> extends BaseContract.View<P> {
        void startActivityWithDelay(long delay);
    }

    abstract class Presenter<V extends View> extends BaseContract.Presenter<V> {

    }
}
