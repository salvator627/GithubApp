package com.example.githubsearchapp.Api

import com.example.githubsearchapp.Data.Model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface Api {
    @GET("search/users")
    @Headers("Autorization: token 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")
    fun getSearchUsers(
        @Query("q") query: String
    ):Call<UserResponse>
}