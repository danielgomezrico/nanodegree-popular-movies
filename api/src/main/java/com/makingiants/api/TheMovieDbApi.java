package com.makingiants.api;

import android.util.Log;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * TheMovieDbApi for https://www.themoviedb.org service
 */

public class TheMovieDbApi {
  public static final String LOG_TAG = "TheMovieDbApi";
  private static Retrofit retrofit;

  public static void init() {
    HttpLoggingInterceptor logger = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
      @Override
      public void log(String message) {
        Log.d(LOG_TAG, message);
      }
    });
    logger.setLevel(HttpLoggingInterceptor.Level.BODY);

    OkHttpClient okHttp = new OkHttpClient.Builder().addNetworkInterceptor(logger).build();

    retrofit = new Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .client(okHttp)
        .addConverterFactory(GsonConverterFactory.create(buildGson()))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build();
  }

  static Gson buildGson() {
    return new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .create();
  }

  public static <S> S buildService(Class<S> service) {
    return retrofit.create(service);
  }
}
