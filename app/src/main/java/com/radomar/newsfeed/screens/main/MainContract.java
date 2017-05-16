package com.radomar.newsfeed.screens.main;

import com.radomar.newsfeed.screens.base.BaseActivityContract;

/**
 * Created by Село on 15.05.2017.
 */

public interface MainContract {
    interface View<P extends Presenter> extends BaseActivityContract.View<P>{

    }

    abstract class Presenter<V extends View> extends BaseActivityContract.Presenter<V> {

    }
}
