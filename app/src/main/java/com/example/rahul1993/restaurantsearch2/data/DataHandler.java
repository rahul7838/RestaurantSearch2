package com.example.rahul1993.restaurantsearch2.data;

import com.example.rahul1993.restaurantsearch2.data.Model.Restaurant;

import java.util.List;

/**
 * Created by rahul1993 on 6/22/2018.
 */

public interface DataHandler {

//  void fetchData(String urlString, Callback<Cuisine> callback);

  interface Callback<T> {
    void onResponse(T result);

    void onError();
  }

  void fetchRestaurantData(String query, Callback<List<Restaurant>> callback);



}
