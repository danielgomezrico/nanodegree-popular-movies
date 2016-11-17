package com.makingiants.api.repositories;

import com.makingiants.api.PaginatedAnswer;
import com.makingiants.api.TheMovieDbApi;
import io.reactivex.Observable;

public class MovieRepository {

  private String mApiKey;
  private MovieService mService;

  public MovieRepository(String apiKey) {
    mApiKey = apiKey;
    mService = TheMovieDbApi.buildService(MovieService.class);
  }

  public Observable<PaginatedAnswer<Movie>> getTopRated() {
    return mService.getTopRated(mApiKey);
  }

  public Observable<PaginatedAnswer<Movie>> getPopular() {
    return mService.getPopular(mApiKey);
  }
}
