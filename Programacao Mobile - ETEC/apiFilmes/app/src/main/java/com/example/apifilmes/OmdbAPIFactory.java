package com.example.apifilmes;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OmdbAPIFactory {
    static Retrofit getInstance(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.omdbapi.com//")

                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
