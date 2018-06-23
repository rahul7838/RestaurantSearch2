package com.example.rahul1993.restaurantsearch2.data.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by rahul1993 on 6/23/2018.
 */

public class Restaurant_ {

  @SerializedName("name")
  @Expose
  private String name;

  @SerializedName("cuisines")
  @Expose
  private String cuisines;

  @SerializedName("average_cost_for_two")
  @Expose
  private Integer averageCostForTwo;



  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCuisines() {
    return cuisines;
  }

  public void setCuisines(String cuisines) {
    this.cuisines = cuisines;
  }

  public Integer getAverageCostForTwo() {
    return averageCostForTwo;
  }

  public void setAverageCostForTwo(Integer averageCostForTwo) {
    this.averageCostForTwo = averageCostForTwo;
  }
}
