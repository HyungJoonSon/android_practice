package com.example.myapplication.mvp.repository

interface ImageRepository {
    fun getRandomImageUrl(callBack : CallBack)

    interface CallBack {
        fun loadImage(url: String, color: String)
    }
}