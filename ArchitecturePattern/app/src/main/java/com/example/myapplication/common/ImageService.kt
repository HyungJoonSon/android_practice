package com.example.myapplication.common

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface ImageService {
    @GET("/photos/random")
    fun getRandomImage(
        @Header("Authorization") key : String
    ) : Call<ImageResponse>
 }