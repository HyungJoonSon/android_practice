package com.example.myapplication.mvc

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.example.myapplication.common.ImageProvider
import com.example.myapplication.databinding.ActivityMvcBinding

class MvcActivity : AppCompatActivity(), ImageProvider.Callback {
    private lateinit var binding: ActivityMvcBinding

    private val model = ImageCountModel()
    private val imageProvider = ImageProvider(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMvcBinding.inflate(layoutInflater).also {
            setContentView(it.root)
            it.view = this
        }
    }

    fun loadImage() {
        imageProvider.getRandomImage()
    }

    @SuppressLint("SetTextI18n")
    override fun loadImage(url: String, color: String) {
        model.increment()
        with(binding) {
            imageView.run {
                setBackgroundColor(Color.parseColor(color))
                load(url)
            }
            imageCountTextView.text = "불러온 이미지 수 : ${model.count}"
        }
    }
}