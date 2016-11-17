package com.makingiants.popularmovies;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.lang.ref.WeakReference;

public class SettingsHandler {
  public static final String MOVIE_ORDER_POPULAR = "popular";
  public static final String MOVIE_ORDER_HIGHEST_RATED = "rate";

  private WeakReference<Context> mWeakContext;

  public SettingsHandler(Context context) {
    mWeakContext = new WeakReference<>(context);
  }

  public String getMovieOrder() {
    Context context = mWeakContext.get();

    if (context != null) {
      SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
      return prefs.getString(context.getString(R.string.pref_movie_order_key), MOVIE_ORDER_POPULAR);
    }

    return MOVIE_ORDER_POPULAR;
  }
}
