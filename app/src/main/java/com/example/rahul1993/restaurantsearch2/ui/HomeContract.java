package com.example.rahul1993.restaurantsearch2.ui;

import com.example.rahul1993.restaurantsearch2.data.Model.Restaurant_;

import java.util.List;

/**
 * Created by rahul1993 on 6/22/2018.
 */

public class HomeContract {

  public interface SearchFragmentView<T> {

     void setPresenter(T presenter);

     void onSearchButtonClick(List<Restaurant_> restaurant1List);
  }

  public interface Presenter{

    void fetchRestaurant(String urlString);
  }
}
