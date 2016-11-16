package com.makingiants.popularmovies.screens.top_movies;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.makingiants.api.repositories.Movie;
import com.makingiants.popularmovies.R;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

  private List<Movie> mItems;

  public MoviesAdapter() {
    mItems = new ArrayList<>();
  }

  @Override
  public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    View view = inflater.inflate(R.layout.movie_item, parent, false);
    return new MovieViewHolder(view);
  }

  @Override
  public void onBindViewHolder(MovieViewHolder holder, int position) {
    Movie movie = mItems.get(position);

    Picasso.with(holder.thumbImageView.getContext())
        .load(movie.getPosterImageUrl("w780"))
        .into(holder.thumbImageView);
  }

  @Override
  public int getItemCount() {
    return mItems.size();
  }

  public void addItems(List<Movie> items) {
    mItems.addAll(items);
    notifyDataSetChanged();
  }

  class MovieViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.thumb_image_view) ImageView thumbImageView;

    MovieViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
