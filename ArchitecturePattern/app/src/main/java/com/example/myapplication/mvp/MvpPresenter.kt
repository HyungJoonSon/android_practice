package com.example.myapplication.mvp

import com.example.myapplication.mvp.model.ImageCountModel
import com.example.myapplication.mvp.repository.ImageRepository

class MvpPresenter(
    private val model : ImageCountModel,
    private val imageRepository: ImageRepository
    ) : MvpContractor.Presenter, ImageRepository.CallBack {

    private var view : MvpContractor.View? = null
    override fun attachView(view: MvpContractor.View) {
        this.view = view
    }

    override fun detachView() {
        view = null
    }

    override fun loadRandomImage() {
        imageRepository.getRandomImageUrl(this)
    }

    override fun loadImage(url: String, color: String) {
        model.increment()
        view?.showImage(url, color)
        view?.showImageCountText(model.count)
    }
}