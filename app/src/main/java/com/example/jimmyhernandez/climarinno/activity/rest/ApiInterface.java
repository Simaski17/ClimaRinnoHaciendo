package com.example.jimmyhernandez.climarinno.activity.rest;

/**
 * Created by Jimmy Hernandez on 27-10-2016.
 */


import com.example.jimmyhernandez.climarinno.activity.model.Example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiInterface {


    //http://api.apixu.com/v1/forecast.json?key=4c9c63494dcf49a18b0194907162710&q=Santiago&days=1

    @GET("forecast.json")
    Call<Example> getInfo(@Query("key") String apiKey, @Query("q") String q, @Query("days") String days);

    /*@GET("movie/{id}")
    Call<Example> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);*/
}