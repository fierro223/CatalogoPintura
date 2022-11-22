package com.example.catalogopintura

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApliService {
    @GET("posts/")
    fun getAllPosts(): Call<List<Posts>>
    @GET("photos/{id}")
    fun getPostByid(@Path("id")id:Int):Call<Posts>
}