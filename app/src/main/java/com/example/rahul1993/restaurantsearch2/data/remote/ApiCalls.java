package com.example.rahul1993.restaurantsearch2.data.remote;

import com.example.rahul1993.restaurantsearch2.data.Model.ZomatoResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by rahul1993 on 6/23/2018.
 */

public interface ApiCalls {

  public interface ZomatoService{
    @Headers({"Accept: application/json", "user-key: 078ecd36882244af98732ace380767ac"})
    @GET("api/v2.1/search")
    Call<ZomatoResponse> getRestaurantResponse(@Query("q") String query);
  }
}
