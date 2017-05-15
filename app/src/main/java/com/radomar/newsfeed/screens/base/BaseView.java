package com.radomar.newsfeed.screens.base;

import android.support.annotation.CheckResult;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;

/**
 * Created by Andrew on 15.05.2017.
 */

public interface BaseView<P> {
    @CheckResult
    String getStringValue(@StringRes int id);
    @LayoutRes
    int getLayoutRes();
}
