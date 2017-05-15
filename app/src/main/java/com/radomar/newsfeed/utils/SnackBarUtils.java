package com.radomar.newsfeed.utils;

import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by Andrew on 10.05.2017.
 */

public class SnackBarUtils {
    public void showError(@NonNull View view, @NonNull CharSequence text) {
        Snackbar snackbar = Snackbar.make(view, text, Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    public void showError(@NonNull View view, @StringRes int textResId) {
        Snackbar snackbar = Snackbar.make(view, textResId, Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    public void showError(@NonNull View view, @StringRes int textResId, Snackbar.Callback callback) {
        Snackbar snackbar = Snackbar.make(view, textResId, Snackbar.LENGTH_LONG);
        snackbar.addCallback(callback);

        snackbar.show();
    }
}
