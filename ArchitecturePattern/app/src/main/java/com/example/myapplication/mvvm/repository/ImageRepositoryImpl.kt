package com.example.myapplication.mvvm.repository

import com.example.myapplication.BuildConfig
import com.example.myapplication.common.RetrofitManager
import com.example.myapplication.mvvm.model.Image
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ImageRepositoryImpl: ImageRepository {
    private val API_KEY = BuildConfig.API_KEY


    override fun getRandomImage() = RetrofitManager.imageService.getRandomImageRx(API_KEY)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .flatMap { item ->
            Single.just(Image(item.urls.regular, item.color))
        }
}