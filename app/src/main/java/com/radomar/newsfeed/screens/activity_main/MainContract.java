package com.radomar.newsfeed.screens.activity_main;

import com.radomar.newsfeed.screens.base.BaseContract;

/**
 * Created by Село on 15.05.2017.
 */

public interface MainContract {
    interface View<P extends Presenter> extends BaseContract.View<P> {
        void showBbcNews();

        void showBbsSport();

        void showArcTechnica();

        void showFavorite();
    }

    abstract class Presenter<V extends View> extends BaseContract.Presenter<V> {
        abstract void onBbcNewsSelected();

        abstract void onBbcSportSelected();

        abstract void onArcTechnicaSelected();

        abstract void onFavoriteSelected();
    }
}
