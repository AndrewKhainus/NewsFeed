package com.radomar.newsfeed.data.database;

import android.os.Handler;
import android.os.Looper;

import com.radomar.newsfeed.data.database.model.RNewsModel;
import com.radomar.newsfeed.data.model.NewsModel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

import static com.radomar.newsfeed.data.database.model.RNewsModel.FIELD_ID;
import static com.radomar.newsfeed.data.database.model.RNewsModel.FIELD_IS_FAVORITE;

/**
 * Created by Andrew on 16.05.2017.
 */

public class RealmDataProvider implements DataProvider {

    private static final String BASENAME = "com.radomar.newsfeed.data.database.RealmDataProvider";

    private Realm mInstance;
    private final Handler mHandler;

    public RealmDataProvider() {
        super();

        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        mHandler = new Handler();
        mHandler.getLooper();
    }

    @Override
    public void open() {
        mInstance = Realm.getInstance(
                new RealmConfiguration.Builder()
                        .name(BASENAME)
                        .deleteRealmIfMigrationNeeded()
                        .build());
    }

    @Override
    public void close() {
        if (mInstance != null && !mInstance.isClosed()) {
            mInstance.close();
        }
    }

    @Override
    public void clear() {
        if (mInstance != null && !mInstance.isClosed()) {
            mInstance.deleteAll();
        }
    }

    @Override
    public void saveNews(List<RNewsModel> news, String source) {
        mInstance.executeTransaction(realm -> {

            RealmResults<RNewsModel> rows = realm.where(RNewsModel.class)
                    .equalTo(RNewsModel.FIELD_SOURCE, source)
                    .equalTo(FIELD_IS_FAVORITE, false)
                    .findAll();
            rows.deleteAllFromRealm();

            for (int i = 0; i < news.size(); i++) {

                Number currentIdNum = realm.where(RNewsModel.class).max(FIELD_ID);
                int nextId;
                if(currentIdNum == null) {
                    nextId = 1;
                } else {
                    nextId = currentIdNum.intValue() + 1;
                }

                RNewsModel rNewsModel = news.get(i);
                rNewsModel.setId(nextId);
                mInstance.insertOrUpdate(rNewsModel);

            }
        });
    }

    @Override
    public List<NewsModel> getNews(String newsName) {
        RealmResults<RNewsModel> realmResults = mInstance
                .where(RNewsModel.class)
                .equalTo(RNewsModel.FIELD_SOURCE, newsName)
                .findAll();

        List<NewsModel> result = new ArrayList<>();
        Iterator<RNewsModel> iterator = realmResults.iterator();
        while (iterator.hasNext()) {
            RNewsModel item = iterator.next();
            result.add(item.getNewsModel());
        }

        return result;
    }


    @Override
    public void saveToFavorites(int newsId) {
        RNewsModel newsModel = mInstance
                .where(RNewsModel.class)
                .equalTo(FIELD_ID, newsId)
                .findFirst();

        mInstance.beginTransaction();
        newsModel.setFavorite(true);
        mInstance.commitTransaction();
    }

    @Override
    public void deleteFromFavorites(int newsId) {
        RNewsModel newsModel = mInstance
                .where(RNewsModel.class)
                .equalTo(FIELD_ID, newsId)
                .findFirst();

        mInstance.beginTransaction();
        newsModel.setFavorite(false);
        mInstance.commitTransaction();
    }

    @Override
    public List<NewsModel> getFavorites() {
        RealmResults<RNewsModel> realmResults = mInstance
                .where(RNewsModel.class)
                .equalTo(RNewsModel.FIELD_IS_FAVORITE, true)
                .findAll();

        List<NewsModel> result = new ArrayList<>();
        Iterator<RNewsModel> iterator = realmResults.iterator();
        while (iterator.hasNext()) {
            RNewsModel item = iterator.next();
            result.add(item.getNewsModel());
        }

        return result;
    }
}
