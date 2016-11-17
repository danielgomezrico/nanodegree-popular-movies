package com.makingiants.api.repositories;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Movie details layout contains title, release date, movie poster, vote average, and plot synopsis.
 */
public class Movie implements Parcelable {
  private String posterPath;
  private String title;
  private String releaseDate;
  private String voteAverage;
  private String overview;

  public String getPosterImageUrl(String size) {
    return String.format("http://image.tmdb.org/t/p/%s/%s", size, posterPath);
  }

  public String getTitle() {
    return title;
  }

  public String getPosterPath() {
    return posterPath;
  }

  public String getReleaseDate() {
    return releaseDate;
  }

  public String getVoteAverage() {
    return voteAverage;
  }

  public String getOverview() {
    return overview;
  }

  //<editor-fold desc="Parcelable">

  @Override
  public int describeContents() { return 0; }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(this.posterPath);
    dest.writeString(this.title);
    dest.writeString(this.releaseDate);
    dest.writeString(this.voteAverage);
    dest.writeString(this.overview);
  }

  public Movie() {}

  protected Movie(Parcel in) {
    this.posterPath = in.readString();
    this.title = in.readString();
    this.releaseDate = in.readString();
    this.voteAverage = in.readString();
    this.overview = in.readString();
  }

  public static final Creator<Movie> CREATOR = new Creator<Movie>() {
    @Override
    public Movie createFromParcel(Parcel source) {return new Movie(source);}

    @Override
    public Movie[] newArray(int size) {return new Movie[size];}
  };

  //</editor-fold>

}
