package com.makingiants.popularmovies.screens.top_movies;

import android.util.Log;
import com.makingiants.api.PaginatedAnswer;
import com.makingiants.api.repositories.Movie;
import com.makingiants.api.repositories.MovieRepository;
import com.makingiants.popularmovies.SettingsHandler;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

class TopMoviesPresenter {
  private TopMoviesView mView;
  private MovieRepository mMovieRepository;
  private TopMoviesCoordinator mCoordinator;
  private SettingsHandler mSettingsHandler;

  void onAttach(TopMoviesView view, MovieRepository movieRepository,
      TopMoviesCoordinator coordinator, SettingsHandler settingsHandler) {
    mView = view;
    mMovieRepository = movieRepository;
    mCoordinator = coordinator;
    mSettingsHandler = settingsHandler;

    loadMovies();
  }

  void deAttach() {
    mView = null;
  }

  public void onItemClick(Movie movie) {
    mCoordinator.startMovieDetailView(movie);
  }

  private void loadMovies() {
    Observable<PaginatedAnswer<Movie>> loadMoviesObservable;
    if (SettingsHandler.MOVIE_ORDER_HIGHEST_RATED.equals(mSettingsHandler.getMovieOrder())) {
      loadMoviesObservable = mMovieRepository.getTopRated();
    } else {
      loadMoviesObservable = mMovieRepository.getPopular();
    }

    loadMoviesObservable.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeWith(new DisposableObserver<PaginatedAnswer<Movie>>() {
          @Override
          public void onNext(PaginatedAnswer<Movie> paginatedAnswer) {
            mView.showItems(paginatedAnswer.getResults());
          }

          @Override
          public void onError(Throwable e) {
            Log.e("Error", "Loading movies", e);
          }

          @Override
          public void onComplete() {

          }
        });
  }
}
