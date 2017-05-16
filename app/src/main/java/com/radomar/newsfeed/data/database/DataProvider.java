package com.radomar.newsfeed.data.database;

import com.radomar.newsfeed.data.database.model.RNewsModel;
import com.radomar.newsfeed.data.model.NewsModel;

import java.util.List;

/**
 * Created by Andrew on 16.05.2017.
 */

public interface DataProvider {

    void open();

    void close();

    void clear();

    void saveNews(List<RNewsModel> news, String source);

    List<NewsModel> getNews(String newsName);

    void saveToFavorites(int newsId);

    void deleteFromFavorites(int newsId);

    List<NewsModel> getFavorites();
}
