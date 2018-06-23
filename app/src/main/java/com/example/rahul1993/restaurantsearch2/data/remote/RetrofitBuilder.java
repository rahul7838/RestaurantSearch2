package com.example.rahul1993.restaurantsearch2.data.remote;

import java.io.IOException;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rahul1993 on 6/23/2018.
 */

public class RetrofitBuilder {

  public static ApiCalls.ZomatoService getAuthApi(){

    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
      @Override
      public okhttp3.Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();

        Request.Builder builder = originalRequest.newBuilder()
            .addHeader("Accept", " application/json")
            .addHeader("user-key", " 078ecd36882244af98732ace380767ac");

        Request newRequest = builder.build();
        return chain.proceed(newRequest);
      }
    }).build();


    return new Retrofit.Builder()
        .baseUrl("https://developers.zomato.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiCalls.ZomatoService.class);
  }
}
