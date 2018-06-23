package com.example.rahul1993.restaurantsearch2.data.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by rahul1993 on 6/23/2018.
 */

public class Restaurant {

  @SerializedName("restaurant")
  @Expose
  private Restaurant_ restaurant;

  public Restaurant_ getRestaurant() {
    return restaurant;
  }

  public void setRestaurant(Restaurant_ restaurant) {
    this.restaurant = restaurant;
  }
}
