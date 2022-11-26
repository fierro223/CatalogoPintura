package com.example.catalogopintura

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApliService {

    @GET("public/collection/v1/objects/{objectID}")
    fun getPostByid(@Path("objectID")id:Int):Call<Data>
}