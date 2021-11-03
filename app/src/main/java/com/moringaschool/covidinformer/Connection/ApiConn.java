package com.moringaschool.covidinformer.Connection;

import com.moringaschool.covidinformer.model.CovidSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiConn {
    @GET("statistics")
    Call<CovidSearchResponse> getStats(
      @Query("country") String country
    );
}
