package com.example.apifilmes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface OmdbAPIService {
    String key = "8e8bd0de";

    @GET("?apikey=" + key)
    Call<List<Movie>> searchMovieByTitle(@Path("s") String title);

    //Call<List<Movie>> searchMovieByTitle(@Path("s") String title, @Path("y") String year);
}
