package com.example.rahul1993.restaurantsearch2.ui;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rahul1993.restaurantsearch2.R;
import com.example.rahul1993.restaurantsearch2.data.Model.Restaurant;
import com.example.rahul1993.restaurantsearch2.data.Model.Restaurant_;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rahul1993 on 6/22/2018.
 */

public class RestaurantListAdapter extends RecyclerView.Adapter<RestaurantListAdapter.RestaurantViewHolder> {
//  private HashSet<String> cuisine;
//  private HashMap<String, Restaurant_> mappedRestaurant;
private List<Restaurant> restaurant1List = new ArrayList<>();
  RestaurantListAdapter(List<Restaurant> restaurant1List) {
//    this.cuisine = cuisine.getCuisine();
//    this.mappedRestaurant = cuisine.getMappedRestaurant();
    this.restaurant1List = restaurant1List;
    Restaurant_ restaurant = restaurant1List.get(0).getRestaurant();
//    Iterator iterator = this.cuisine.iterator();
  }

  @Override
  public RestaurantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View viewHolder = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_list_item, parent, false);
    return new RestaurantViewHolder(viewHolder);
  }

  @Override
  public void onBindViewHolder(RestaurantViewHolder holder, int position) {
//    holder.setCuisineHeading(listCuisine.get(position));
//    holder.setRestaurantOption1(mappedRestaurant.get(listCuisine.get(position)).getName());
//    holder.setRestuarantOption2(mappedRestaurant.get(listCuisine.get(position)).getPrice());
    holder.setCuisineHeading(restaurant1List.get(position).getRestaurant().getCuisines());
    holder.setRestaurantOption1(restaurant1List.get(position).getRestaurant().getName());
    holder.setRestuarantOption2(restaurant1List.get(position).getRestaurant().getAverageCostForTwo().toString());
  }

  @Override
  public int getItemCount() {
    return restaurant1List.size();
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

    void setCuisineHeading(String cuisine){
      cuisineHeading.setText(cuisine);
    }

    void setRestaurantOption1(String restaurant){
      restaurantOption1.setText(restaurant);
    }

    void setRestuarantOption2(String restaurant){
      restaurantOption2.setText("Approx Rs" +restaurant+"/- for 2");
    }
  }
}