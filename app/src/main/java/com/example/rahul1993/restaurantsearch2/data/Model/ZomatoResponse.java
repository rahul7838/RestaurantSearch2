package com.example.rahul1993.restaurantsearch2.data.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by rahul1993 on 6/23/2018.
 */

public class ZomatoResponse {

  @SerializedName("results_found")
  @Expose
  private Integer resultsFound;
  @SerializedName("results_start")
  @Expose
  private Integer resultsStart;
  @SerializedName("results_shown")
  @Expose
  private Integer resultsShown;
  @SerializedName("restaurants")
  @Expose
  private List<Restaurant> restaurants = null;

  public Integer getResultsFound() {
    return resultsFound;
  }

  public void setResultsFound(Integer resultsFound) {
    this.resultsFound = resultsFound;
  }

  public Integer getResultsStart() {
    return resultsStart;
  }

  public void setResultsStart(Integer resultsStart) {
    this.resultsStart = resultsStart;
  }

  public Integer getResultsShown() {
    return resultsShown;
  }

  public void setResultsShown(Integer resultsShown) {
    this.resultsShown = resultsShown;
  }

  public List<Restaurant> getRestaurants() {
    return restaurants;
  }

  public void setRestaurants(List<Restaurant> restaurants) {
    this.restaurants = restaurants;
  }

}
