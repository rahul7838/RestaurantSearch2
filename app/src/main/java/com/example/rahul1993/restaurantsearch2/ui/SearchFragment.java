package com.example.rahul1993.restaurantsearch2.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.rahul1993.restaurantsearch2.PresenterInjector;
import com.example.rahul1993.restaurantsearch2.R;
import com.example.rahul1993.restaurantsearch2.data.Model.Restaurant_;

import java.util.List;

/**
 * Created by rahul1993 on 22/6/2018.
 */

public class SearchFragment extends Fragment implements View.OnClickListener,
    HomeContract.SearchFragmentView{

  private static final String TAG = SearchFragment.class.getSimpleName();
  String queryText;
  EditText editText;
  Button searchButton;
  View view;
  onSearchClickListener listener;
  HomeContract.Presenter mPresenter;
  ProgressBar progressBar;

  String urlString = "https://developers.zomato.com/api/v2.1/search?q=";
  //"https://www.googleapis.com/apiName/version/entity?maxResults=7&q="


  public SearchFragment(){
      // empty constructor is required.

  }

  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
    PresenterInjector.injectHomePresenter(this);
    try {
      listener = (onSearchClickListener) context;
    } catch (ClassCastException e){
        throw new ClassCastException(context.toString() + " must implement onSearchClickListener");
    }
  }

  @Override
  public void setPresenter(Object presenter) {
    mPresenter = (HomeContract.Presenter)presenter;
  }

  @Override
  public void onSearchButtonClick(List list) {
    listener.onSearchClick(list);
    editText.setText("");
    progressBar.setVisibility(View.GONE);
  }

  public interface onSearchClickListener{
    void onSearchClick(List<Restaurant_> restaurant1List);
  }

  public static SearchFragment newInstance() {
    return new SearchFragment();
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

    view = inflater.inflate(R.layout.home_search_fragment,container,false);
    searchButton = (Button) view.findViewById(R.id.search_button_home_fragment);
    editText = (EditText) view.findViewById(R.id.search_text_home_fragment);
    progressBar = (ProgressBar) view.findViewById(R.id.progress_bar_id);
    searchButton.setOnClickListener(this);
    return view;
  }

  @Override
  public void onClick(View v) {
    queryText = editText.getText().toString();
    Log.i(TAG, queryText);
//    urlString = "https://developers.zomato.com/api/v2.1/search?q=" + queryText;
    progressBar.setVisibility(View.VISIBLE);
//    listener.onSearchClick(queryText);
    mPresenter.fetchRestaurant(queryText);
    queryText = "";
  }
}

