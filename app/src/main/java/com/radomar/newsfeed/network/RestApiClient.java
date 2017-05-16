package com.radomar.newsfeed.network;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Andrew on 15.05.2017.
 */

public class RestApiClient {

    static final int CONNECTION_TIMEOUT = 20;

    private static RestApiClient INSTANCE;
    private Retrofit retrofit;
    private Gson gson;

    private RestApiClient() {}

    public static synchronized RestApiClient getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new RestApiClient();
            INSTANCE.build();
        }
        return INSTANCE;
    }


    private void build() {
        final OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();

        clientBuilder.readTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS);
        clientBuilder.connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS);
        clientBuilder.addInterceptor(new HeaderInterceptor());
        clientBuilder.addNetworkInterceptor(new StethoInterceptor());

        final OkHttpClient client = clientBuilder.build();

        retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Config.BASE_URL)
                .client(client)
                .build();

        gson = new GsonBuilder().create();
    }

    public Gson getGson() {
        return gson;
    }

    public NewsRestService newsRestService() {
        return retrofit.create(NewsRestService.class);
    }

    private class HeaderInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request original = chain.request();

            Request.Builder requestBuilder = original.newBuilder();
            requestBuilder.header("Content-Type", "application/json");

//            hardcoded apikey
            requestBuilder.addHeader("x-api-key", "18afdcdbddc540acb804a6df8a5182dd");

            Request request = requestBuilder.build();

            return chain.proceed(request);
        }
    }
}
