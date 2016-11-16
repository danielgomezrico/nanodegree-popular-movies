package com.makingiants.popularmovies.screens.top_movies;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.makingiants.api.repositories.Movie;
import com.makingiants.popularmovies.screens.movie_detail.MovieDetailActivity;
import java.lang.ref.WeakReference;

public class TopMoviesCoordinator {
  private WeakReference<FragmentActivity> mWeakActivity;

  public TopMoviesCoordinator(FragmentActivity activity) {
    mWeakActivity = new WeakReference<>(activity);
  }

  public void startMovieDetailView(Movie movie) {
    FragmentActivity activity = mWeakActivity.get();
    if (activity != null) {
      Intent intent = MovieDetailActivity.getInstance(activity, movie);
      activity.startActivity(intent);
    }
  }
}
