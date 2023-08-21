package com.example.myapplication.mvvm.repository

import com.example.myapplication.mvvm.model.Image
import io.reactivex.Single

interface ImageRepository {
    fun getRandomImage() : Single<Image>
}