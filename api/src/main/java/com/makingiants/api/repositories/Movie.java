package com.makingiants.api.repositories;

public class Movie {
  String posterPath;

  public String getPosterImageUrl(String size) {
    return String.format("http://image.tmdb.org/t/p/%s/%s", size, posterPath);
  }
}
