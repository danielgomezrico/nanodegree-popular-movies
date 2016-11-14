package com.makingiants.popularmovies.screens;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.makingiants.api.repositories.Movie;
import com.makingiants.api.repositories.MovieRepository;
import com.makingiants.popularmovies.BuildConfig;
import com.makingiants.popularmovies.R;
import java.util.List;

public class TopMoviesActivity extends AppCompatActivity implements TopMoviesView {

  private TopMoviesPresenter mPresenter;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.top_movies_activity);

    mPresenter = new TopMoviesPresenter();
  }

  @Override
  protected void onResume() {
    super.onResume();
    mPresenter.onAttach(this, new MovieRepository(BuildConfig.POPULAR_THE_MOVIE_API_KEY));
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    mPresenter.deAttach();
  }

  @Override
  public void showItems(List<Movie> items) {

  }
}
