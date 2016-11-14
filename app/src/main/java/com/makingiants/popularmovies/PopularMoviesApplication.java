package com.makingiants.popularmovies;

import android.app.Application;
import com.makingiants.api.TheMovieDbApi;

/**
 * Created by danielgomez on 11/14/16.
 */

public class PopularMoviesApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    TheMovieDbApi.init();
  }
}
