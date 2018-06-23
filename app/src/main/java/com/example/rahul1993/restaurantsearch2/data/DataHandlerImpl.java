package com.example.rahul1993.restaurantsearch2.data;


import android.util.Log;

import com.example.rahul1993.restaurantsearch2.data.Model.Restaurant;
import com.example.rahul1993.restaurantsearch2.data.Model.ZomatoResponse;
import com.example.rahul1993.restaurantsearch2.data.remote.RetrofitBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * This is the implementation of {@link DataHandler} interface.
 *
 * Created by rahul1993 on 6/22/2018.
 */

public class DataHandlerImpl implements DataHandler {
  private static final String TAG = DataHandlerImpl.class.getSimpleName();
    private static DataHandler mDataHandler;

  public static DataHandler getInstance(){
    if(mDataHandler == null){
      mDataHandler = new DataHandlerImpl();
    }
    return mDataHandler;
  }

  @Override
  public void fetchRestaurantData(String query, final Callback<List<Restaurant>> callback) {
    RetrofitBuilder.getAuthApi()
        .getRestaurantResponse(query)
        .enqueue(new retrofit2.Callback<ZomatoResponse>() {
          @Override
          public void onResponse(Call<ZomatoResponse> call, Response<ZomatoResponse> response) {
            ZomatoResponse body = response.body();
            callback.onResponse(response.body().getRestaurants());
          }

          @Override
          public void onFailure(Call<ZomatoResponse> call, Throwable t) {
//              TODO show error message
            Log.d(TAG, "onFailure");
            callback.onError();
          }
        });
  }
}
