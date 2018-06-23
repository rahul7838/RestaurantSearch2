package com.example.rahul1993.restaurantsearch2.ui;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.rahul1993.restaurantsearch2.R;
import com.example.rahul1993.restaurantsearch2.data.Model.Restaurant_;
import com.example.rahul1993.restaurantsearch2.utils.ConstantUtil;


import java.io.Serializable;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements SearchFragment.onSearchClickListener{
private static final String TAG = HomeActivity.class.getSimpleName();
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    FragmentManager manager = getSupportFragmentManager();
    FragmentTransaction transaction = manager.beginTransaction();
    SearchFragment searchFragment1 = new SearchFragment();
    transaction.add(R.id.fragment_container, searchFragment1);
    transaction.commit();
  }

  @Override
  public void onSearchClick(List<Restaurant_> restaurant1List) {
    Log.d(TAG, "onSearchClick");
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    ListRestaurantFragment listBookFragment = new ListRestaurantFragment();
    Bundle bundle = new Bundle();
    bundle.putSerializable(ConstantUtil.RESTAURANT_LIST_KEY, (Serializable) restaurant1List);
    listBookFragment.setArguments(bundle);
    fragmentTransaction.replace(R.id.fragment_container,listBookFragment);
    fragmentTransaction.addToBackStack(null);
    fragmentTransaction.commit();
  }
}

