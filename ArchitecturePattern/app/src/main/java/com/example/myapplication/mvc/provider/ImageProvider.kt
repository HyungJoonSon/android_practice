package com.example.myapplication.mvc.provider

import com.example.myapplication.BuildConfig
import com.example.myapplication.common.ImageResponse
import com.example.myapplication.common.RetrofitManager
import retrofit2.Call
import retrofit2.Response

class ImageProvider(private val callback: Callback) {
    private val API_KEY = BuildConfig.API_KEY
    fun getRandomImage() {
        RetrofitManager.imageService.getRandomImage(API_KEY)
            .enqueue(object : retrofit2.Callback<ImageResponse> {
                override fun onResponse(
                    call: Call<ImageResponse>,
                    response: Response<ImageResponse>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.let {
                            callback.loadImage(it.urls.regular, it.color)
                        }
                    }
                }

                override fun onFailure(call: Call<ImageResponse>, t: Throwable) {
                }

            })
    }
    interface Callback {
        fun loadImage(url: String, color: String)
    }
}