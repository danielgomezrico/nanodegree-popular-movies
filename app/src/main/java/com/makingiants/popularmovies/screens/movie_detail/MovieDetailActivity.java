package com.makingiants.popularmovies.screens.movie_detail;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.makingiants.api.repositories.Movie;
import com.makingiants.popularmovies.R;
import com.squareup.picasso.Picasso;

public class MovieDetailActivity extends AppCompatActivity {

  @BindView(R.id.title_text_view) TextView mTitleTextView;
  @BindView(R.id.release_date_text_view) TextView mReleaseDateTextView;
  @BindView(R.id.vote_average_text_view) TextView mVoteAverageTextView;
  @BindView(R.id.synopsis_text_view) TextView mSynopsisTextView;
  @BindView(R.id.thumb_image_view) ImageView mThumbImageView;

  public static final String EXTRA_MOVIE = "detail.movie";

  public static Intent getInstance(Activity activity, Movie movie) {
    Intent intent = new Intent(activity, MovieDetailActivity.class);
    intent.putExtra(EXTRA_MOVIE, movie);
    return intent;
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.movie_detail_activity);
    ButterKnife.bind(this);

    Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);

    mTitleTextView.setText(movie.getTitle());
    mReleaseDateTextView.setText(movie.getReleaseDate());
    mVoteAverageTextView.setText(movie.getVoteAverage());
    mSynopsisTextView.setText(movie.getOverview());

    Picasso.with(this).load(movie.getPosterImageUrl("w154")).into(mThumbImageView);
  }
}
