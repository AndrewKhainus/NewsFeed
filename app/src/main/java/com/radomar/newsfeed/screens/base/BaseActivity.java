package com.radomar.newsfeed.screens.base;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.radomar.newsfeed.App;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by Andrew on 15.05.2017.
 */

public abstract class BaseActivity<P extends BaseContract.Presenter>
                                extends AppCompatActivity
                                implements BaseContract.View<P> {

    @Inject
    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupComponent(((App)getApplication()).getAppComponent());

        if (getLayoutRes() != 0) {
            setContentView(getLayoutRes());
        }

        presenter.bindView(this);
        ButterKnife.bind(this);
        presenter.onViewCreated();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public String getStringValue(@StringRes int id) {
        return getString(id);
    }

    protected void pushFragment(@IdRes int container, Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(container, fragment)
                .commit();
    }

}
