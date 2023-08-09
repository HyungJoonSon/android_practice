package com.example.myapplication.mvp.repository

import com.example.myapplication.BuildConfig
import com.example.myapplication.common.ImageResponse
import com.example.myapplication.common.RetrofitManager
import retrofit2.Call
import retrofit2.Response

class ImageRepositoryImpl : ImageRepository {
    private val API_KEY = BuildConfig.API_KEY

    override fun getRandomImageUrl(callBack: ImageRepository.CallBack) {
        RetrofitManager.imageService.getRandomImage(API_KEY)
            .enqueue(object : retrofit2.Callback<ImageResponse> {
                override fun onResponse(
                    call: Call<ImageResponse>,
                    response: Response<ImageResponse>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.let {
                            callBack.loadImage(it.urls.regular, it.color)
                        }
                    }
                }

                override fun onFailure(call: Call<ImageResponse>, t: Throwable) {
                }
            })
    }
}