package com.radomar.newsfeed.screens.splash;

import com.radomar.newsfeed.screens.base.BaseActivityContract;

/**
 * Created by Andrew on 15.05.2017.
 */

public interface SplashContract {

    interface View<P extends Presenter> extends BaseActivityContract.View<P> {
        void startActivityWithDelay(long delay);
    }

    abstract class Presenter<V extends View> extends BaseActivityContract.Presenter<V> {

    }
}
