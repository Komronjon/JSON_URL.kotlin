package com.example.json_fromurl.`interface`

import com.example.json_fromurl.model.Movie_book
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("marvel")
    fun getMovieist():Call<MutableList<Movie_book>>
}