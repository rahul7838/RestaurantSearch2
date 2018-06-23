package com.example.rahul1993.restaurantsearch2.data;

import com.example.rahul1993.restaurantsearch2.data.Model.Restaurant;

import java.util.List;

/**
 * Created by rahul1993 on 6/22/2018.
 */

public interface DataHandler {

  /**
   * Generic callback interface for passing response to caller.
   * <p>
   *
   * @param <T> Type of expected response
   */

  interface Callback<T> {
    /**
     * Gets invoked when call was successful
     *
     * @param result result of the operation
     */
    void onResponse(T result);

    /**
     * Gets invoked when there is an error in the operation
     */
    void onError();
  }

  /**
   * Fetch restaurant from Zomato api
   *
   * @param query user entered text
   * @param callback Callback for receiving result
   *
   */
  void fetchRestaurantData(String query, Callback<List<Restaurant>> callback);



}
