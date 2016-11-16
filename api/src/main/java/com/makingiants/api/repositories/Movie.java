package com.makingiants.api.repositories;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
  private String posterPath;
  private String title;

  public String getPosterImageUrl(String size) {
    return String.format("http://image.tmdb.org/t/p/%s/%s", size, posterPath);
  }

  public String getTitle() {
    return title;
  }

  //<editor-fold desc="Parcelable">

  @Override
  public int describeContents() { return 0; }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(this.posterPath);
    dest.writeString(this.title);
  }

  public Movie() {}

  protected Movie(Parcel in) {
    this.posterPath = in.readString();
    this.title = in.readString();
  }

  public static final Creator<Movie> CREATOR = new Creator<Movie>() {
    @Override
    public Movie createFromParcel(Parcel source) {return new Movie(source);}

    @Override
    public Movie[] newArray(int size) {return new Movie[size];}
  };

  //</editor-fold>
}
