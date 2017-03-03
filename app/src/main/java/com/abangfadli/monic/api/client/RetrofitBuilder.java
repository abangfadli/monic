package com.abangfadli.monic.api.client;

import com.abangfadli.commonutils.StringUtil;
import com.abangfadli.monic.api.APIRoutes;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;

/**
 * Created by ahmadfadli on 2/21/17.
 */

public class RetrofitBuilder {

    private static final int DEFAULT_TIMEOUT = 60 * 1000;

    public static Retrofit getRawBuilder() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(loggingInterceptor);

        httpClient.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS);
        httpClient.readTimeout(DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS);
        httpClient.writeTimeout(DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS);

        return new Retrofit.Builder()
                .baseUrl(APIRoutes.BASE_URL)
                .client(httpClient.build())
                .build();
    }

    public static Retrofit getDefaultBuilder() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(loggingInterceptor);

        httpClient.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS);
        httpClient.readTimeout(DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS);
        httpClient.writeTimeout(DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS);

        return new Retrofit.Builder()
                .baseUrl(APIRoutes.BASE_URL)
                .client(httpClient.build())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}