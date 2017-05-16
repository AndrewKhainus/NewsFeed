package com.radomar.newsfeed.adapters;

/**
 * Created by Село on 16.05.2017.
 */

public interface NewsEventListener {
    void onLinkClick(String link);

    void onLikeClick(int newsId);

    void onItemDelete(int newsId);

}
