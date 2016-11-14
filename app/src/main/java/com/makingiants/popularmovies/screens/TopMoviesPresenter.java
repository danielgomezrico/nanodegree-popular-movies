package com.makingiants.popularmovies.screens;

import com.makingiants.api.PaginatedAnswer;
import com.makingiants.api.repositories.Movie;
import com.makingiants.api.repositories.MovieRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

class TopMoviesPresenter {
  TopMoviesView mView;

  void onAttach(TopMoviesView view, MovieRepository movieRepository) {
    mView = view;

    movieRepository.getTopRated()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeWith(new DisposableObserver<PaginatedAnswer<Movie>>() {
          @Override
          public void onNext(PaginatedAnswer<Movie> paginatedAnswer) {
              mView.showItems(paginatedAnswer.getResults());
          }

          @Override
          public void onError(Throwable e) {

          }

          @Override
          public void onComplete() {

          }
        });
  }

  void deAttach() {
    mView = null;
  }
}
