package com.example.rahul1993.restaurantsearch2.ui;

import android.util.Log;

import com.example.rahul1993.restaurantsearch2.data.DataHandler;
import com.example.rahul1993.restaurantsearch2.data.DataHandlerImpl;
import com.example.rahul1993.restaurantsearch2.data.Model.Restaurant;
import com.example.rahul1993.restaurantsearch2.data.Model.Restaurant_;

import java.util.List;

/**
 * Created by rahul1993 on 6/22/2018.
 */

public class HomePresenter implements HomeContract.Presenter {
  private static final String TAG = HomePresenter.class.getSimpleName();
  private HomeContract.SearchFragmentView mSearchFragmentView;
  private DataHandler mDataHandler;

  public HomePresenter(HomeContract.SearchFragmentView searchFragmentView){
    this.mSearchFragmentView = searchFragmentView;
    mSearchFragmentView.setPresenter(this);
    mDataHandler = DataHandlerImpl.getInstance();
  }

  @Override
  public void fetchRestaurant(String query) {
    mDataHandler.fetchRestaurantData(query, new DataHandler.Callback<List<Restaurant>>() {
      @Override
      public void onResponse(List<Restaurant> result) {
        mSearchFragmentView.onSearchButtonClick(result);
      }

      @Override
      public void onError() {
        Log.d(TAG, "onError");
//        TODO Handle error
      }
    });
  }
}
