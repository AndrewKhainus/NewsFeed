package com.radomar.newsfeed.screens.main;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.radomar.newsfeed.R;
import com.radomar.newsfeed.di.AppComponent;
import com.radomar.newsfeed.screens.base.BaseActivity;
import com.radomar.newsfeed.screens.main.di.DaggerMainComponent;
import com.radomar.newsfeed.screens.splash.SplashContract;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainContract.Presenter> implements MainContract.View<MainContract.Presenter> {

    @BindView(R.id.toolbar_main)
    Toolbar toolbar;

    @BindView(R.id.rvNews)
    RecyclerView rvNews;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(toolbar);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    public void setupComponent(AppComponent appComponent) {
        DaggerMainComponent.builder().appComponent(appComponent)
                .build()
                .inject(this);
    }
}
