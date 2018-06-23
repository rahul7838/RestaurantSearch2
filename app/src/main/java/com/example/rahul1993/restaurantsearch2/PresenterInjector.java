package com.example.rahul1993.restaurantsearch2;


import com.example.rahul1993.restaurantsearch2.ui.HomeContract;
import com.example.rahul1993.restaurantsearch2.ui.HomePresenter;

/**
 * Created by rahul1993 on 6/22/2018.
 */

public class PresenterInjector {

  public static void injectHomePresenter(HomeContract.SearchFragmentView view){
    new HomePresenter(view);
  }
}
