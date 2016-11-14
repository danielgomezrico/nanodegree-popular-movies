package com.makingiants.popularmovies.screens;

import com.makingiants.api.repositories.Movie;
import java.util.List;

/**
 * Created by danielgomez on 11/14/16.
 */

interface TopMoviesView {
  void showItems(List<Movie> items);
}
