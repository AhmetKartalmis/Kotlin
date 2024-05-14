package com.ahmetkartal.dene.retrofit

import com.ahmetkartal.dene.data.entity.ArticleModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticleAPI {
    // https://newsapi.org/v2/everything?q=page=2&apiKey=0a55fe607c5f4d72ad63413ca61c50af
    // everything?q=page=2&apiKey=0a55fe607c5f4d72ad63413ca61c50af
    @GET("everything?q=page=1&apiKey=0a55fe607c5f4d72ad63413ca61c50af")
    fun getData():Call<ArticleModel>

    @GET("everything")
    fun getSearchData(
        @Query("q") query: String,
        @Query("page") page: Int,
        @Query("apiKey") apiKey: String
    ): Call<ArticleModel>

}