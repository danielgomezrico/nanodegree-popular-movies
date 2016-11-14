package com.makingiants.api;

import java.util.List;

/**
 * Created by danielgomez on 11/14/16.
 */

public class PaginatedAnswer<T> {
  private int page;
  private int totalPages;
  private List<T> results;

  public int getPage() {
    return page;
  }

  public int getTotalPages() {
    return totalPages;
  }

  public List<T> getResults() {
    return results;
  }
}
