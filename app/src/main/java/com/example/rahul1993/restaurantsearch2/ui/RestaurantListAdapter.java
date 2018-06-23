package com.example.rahul1993.restaurantsearch2.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rahul1993.restaurantsearch2.R;
import com.example.rahul1993.restaurantsearch2.data.Model.Restaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by rahul1993 on 6/22/2018.
 */

public class RestaurantListAdapter extends RecyclerView.Adapter<RestaurantListAdapter.RestaurantViewHolder> {
  private HashSet<String> cuisineSet = new HashSet<>();
  private HashMap<String, String> mappedRestaurant = new HashMap<>();
  private List<String> cuisineList = new ArrayList<>();
  private List<Restaurant> restaurant1List = new ArrayList<>();
  private Context context;

  RestaurantListAdapter(List<Restaurant> restaurant1List, Context context) {
//    this.cuisine = cuisine.getCuisine();
//    this.mappedRestaurant = cuisine.getMappedRestaurant();
    this.restaurant1List = restaurant1List;
    this.context = context;
//    TODO Group list by cuisine type
    groupByCuisine();
//    Restaurant_ restaurant = restaurant1List.get(0).getRestaurant();
//    Iterator iterator = this.cuisine.iterator();
  }

  private void groupByCuisine() {
    int size = restaurant1List.size();
    for(int i=0; i<size; i++){
      String cuisine = restaurant1List.get(i).getRestaurant().getCuisines();
      String restaurantName = restaurant1List.get(i).getRestaurant().getName();
      String[] list = cuisine.split(",");
//      cuisineList.add(restaurantName);
//      int listLength = list.length;
//      for (String aList : list) {
        mappedRestaurant.put(list[0], restaurantName);
        cuisineSet.add(list[0]);
    }
    cuisineList.addAll(cuisineSet);
  }

  @Override
  public RestaurantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View viewHolder = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_list_item, parent, false);
    return new RestaurantViewHolder(viewHolder);
  }

  @Override
  public void onBindViewHolder(RestaurantViewHolder holder, int position) {
    holder.setCuisineHeading((cuisineList.get(position)));
    holder.setRestaurantOption1(mappedRestaurant.get(cuisineList.get(position)));
//    holder.setRestuarantOption2(mappedRestaurant.get(listCuisine.get(position)).getPrice());
//    holder.setCuisineHeading(restaurant1List.get(position).getRestaurant().getCuisines());
//    holder.setRestaurantOption1(restaurant1List.get(position).getRestaurant().getName());
//    holder.setRestuarantOption2(restaurant1List.get(position).getRestaurant().getAverageCostForTwo().toString());
  }

  @Override
  public int getItemCount() {
    return cuisineList.size();
  }


  class RestaurantViewHolder extends RecyclerView.ViewHolder {
    View view;
    TextView cuisineHeading, restaurantOption1, restaurantOption2;

    RestaurantViewHolder(View itemView) {
      super(itemView);
      view = itemView;
      cuisineHeading = view.findViewById(R.id.cuisine_heading);
      restaurantOption1 = view.findViewById(R.id.restaurant_option_1);
      restaurantOption2 = view.findViewById(R.id.restaurant_option_2);
    }

    void setCuisineHeading(String cuisine) {
      cuisineHeading.setText(cuisine);
    }

    void setRestaurantOption1(String restaurant) {
      restaurantOption1.setText(restaurant);
    }

    void setRestuarantOption2(String restaurant) {
      String avgCost = context.getString(R.string.approx_cost) + restaurant +
          context.getString(R.string.number_of_person);
      restaurantOption2.setText(avgCost);
    }
  }
}