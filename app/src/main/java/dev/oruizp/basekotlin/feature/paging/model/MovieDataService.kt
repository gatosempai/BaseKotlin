package dev.oruizp.basekotlin.feature.paging.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieDataService {

    @GET("movies/popular")
    fun getPopularMovies(@Query("api_key") apiKey: String): Call<MovieDBResponse>

    @GET("movie/popular")
    fun getPopularMoviesWithPagging(@Query("api_key") apiKey: String, @Query("page") page: Long):
            Call<MovieDBResponse>
}