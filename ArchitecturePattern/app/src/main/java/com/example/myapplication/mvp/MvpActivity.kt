package com.example.myapplication.mvp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.example.myapplication.mvp.model.ImageCountModel
import com.example.myapplication.mvp.repository.ImageRepositoryImpl
import com.example.myapplication.databinding.ActivityMvpBinding

class MvpActivity : AppCompatActivity(), MvpContractor.View {
    private lateinit var binding: ActivityMvpBinding
    private lateinit var presenter: MvpContractor.Presenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMvpBinding.inflate(layoutInflater).also {
            setContentView(it.root)
            it.view = this
        }

        presenter = MvpPresenter(ImageCountModel(), ImageRepositoryImpl())
        presenter.attachView(this)
    }

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }

    fun loadImage() {
        presenter.loadRandomImage()
    }

    override fun showImage(url: String, color: String) {
        binding.imageView.run {
            setBackgroundColor(Color.parseColor(color))
            load(url) {
                crossfade(300)
            }
        }
    }

    override fun showImageCountText(count: Int) {
        binding.imageCountTextView.text = "불러온 이미지 수 : $count"
    }
}