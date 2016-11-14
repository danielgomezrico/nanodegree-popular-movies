package com.makingiants.api.repositories;

import com.makingiants.api.PaginatedAnswer;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface MovieService {

  @GET("movie/top_rated")
  Observable<PaginatedAnswer<Movie>> getTopRated(@Query("api_key") String apiKey);
}
