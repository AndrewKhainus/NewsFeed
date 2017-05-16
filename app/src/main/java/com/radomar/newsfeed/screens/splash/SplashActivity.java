package com.radomar.newsfeed.screens.splash;


import android.content.Intent;
import android.os.Handler;

import com.radomar.newsfeed.R;
import com.radomar.newsfeed.screens.main.MainActivity;
import com.radomar.newsfeed.di.AppComponent;
import com.radomar.newsfeed.screens.base.BaseActivity;
import com.radomar.newsfeed.screens.splash.di.DaggerSplashComponent;

/**
 * Created by Andrew on 15.05.2017.
 */

public class SplashActivity extends BaseActivity<SplashContract.Presenter>
        implements SplashContract.View<SplashContract.Presenter> {

    private Handler handler;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_splash;
    }

    @Override
    public void setupComponent(AppComponent appComponent) {
        DaggerSplashComponent.builder()
                .appComponent(appComponent)
                .build()
                .inject(this);
    }

    @Override
    public void startActivityWithDelay(long delay) {
        handler = new Handler();
        handler.postDelayed(() -> startActivity(new Intent(SplashActivity.this, MainActivity.class)), delay);
        finish();
    }

}
