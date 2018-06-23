package com.example.rahul1993.restaurantsearch2.ui;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rahul1993.restaurantsearch2.R;
import com.example.rahul1993.restaurantsearch2.data.Model.Restaurant;
import com.example.rahul1993.restaurantsearch2.data.Model.Restaurant_;
import com.example.rahul1993.restaurantsearch2.utils.ConstantUtil;

import java.util.List;

/**
 * This fragment shows the list of cuisine
 *
 * Created by rahul1993 on 6/22/2018.
 */

public class ListRestaurantFragment extends Fragment{
  private RecyclerView mRecyclerView;
  private static final String TAG = ListRestaurantFragment.class.getSimpleName();

  public ListRestaurantFragment(){

  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
    super.onCreateView(inflater, container, savedInstanceState);
    View view = inflater.inflate(R.layout.restaurant_list, container, false);
    Bundle bundle = getArguments();
    List<Restaurant> restaurant1List =(List<Restaurant>) bundle.get(ConstantUtil.RESTAURANT_LIST_KEY);
//    Log.d(TAG, list.get(0).getName());
    mRecyclerView = view.findViewById(R.id.recycler_view);

    setLayout(restaurant1List);
    bundle.remove(ConstantUtil.RESTAURANT_LIST_KEY);

    return view;
  }

  private void setLayout(List<Restaurant> restaurant1List) {
    Log.d(TAG, "setLayout");
    mRecyclerView.setHasFixedSize(true);
    LinearLayoutManager llm = new LinearLayoutManager(getActivity());
    llm.setOrientation(LinearLayoutManager.VERTICAL);
    mRecyclerView.setLayoutManager(llm);
    RestaurantListAdapter adapter = new RestaurantListAdapter(restaurant1List, getContext());
    mRecyclerView.setAdapter(adapter);
  }
}
