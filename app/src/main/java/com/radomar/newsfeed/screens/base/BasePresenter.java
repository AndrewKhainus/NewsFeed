package com.radomar.newsfeed.screens.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by Andrew on 15.05.2017.
 */

public interface BasePresenter<V> {

    void onViewCreated();
    void onDestroyView();
    void bindView(V view);
}
