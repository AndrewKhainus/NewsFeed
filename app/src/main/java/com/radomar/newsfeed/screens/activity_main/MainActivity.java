package com.radomar.newsfeed.screens.activity_main;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.radomar.newsfeed.R;
import com.radomar.newsfeed.di.AppComponent;
import com.radomar.newsfeed.screens.base.BaseActivity;
import com.radomar.newsfeed.screens.activity_main.di.DaggerMainComponent;
import com.radomar.newsfeed.screens.fragment_news.NewsFragment;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainContract.Presenter> implements MainContract.View<MainContract.Presenter>,
                                                                                  NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar_main)
    Toolbar toolbar;

    @BindView(R.id.drawer_layout_AM)
    DrawerLayout drawer;

    @BindView(R.id.nav_view_AM)
    NavigationView navigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_bbc_news:
                if (!item.isChecked()) {
                    presenter.onBbcNewsSelected();
                }
                break;
            case R.id.nav_bbc_sport:
                if (!item.isChecked()) {
                    presenter.onBbcSportSelected();
                }
                break;
            case R.id.nav_ars_technica:
                if (!item.isChecked()) {
                    presenter.onArcTechnicaSelected();
                }
                break;
            case R.id.nav_favorite:
                if (!item.isChecked()) {
                    presenter.onFavoriteSelected();
                }
                break;
        }

        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void showBbcNews() {
        pushFragment(R.id.content_main,new NewsFragment());
    }

    @Override
    public void showBbsSport() {
        pushFragment(R.id.content_main,new NewsFragment());
    }

    @Override
    public void showArcTechnica() {
        pushFragment(R.id.content_main,new NewsFragment());
    }

    @Override
    public void showFavorite() {
        pushFragment(R.id.content_main,new NewsFragment());
    }
}
