package com.radomar.newsfeed.network;

import com.radomar.newsfeed.network.responses.NewsResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.radomar.newsfeed.network.Config.GET_NEWS;

/**
 * Created by Andrew on 15.05.2017.
 */

public interface NewsRestService {

    @GET(GET_NEWS)
    Observable<NewsResponse> getLatestNews(@Query("source") String source);

}
