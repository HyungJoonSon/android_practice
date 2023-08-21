package com.example.myapplication.mvvm.bindingadapter

import android.graphics.Color
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import com.example.myapplication.mvvm.model.Image

@BindingAdapter("image")
fun ImageView.setImage(image: Image?) {
    if (image == null) {
        return
    }

    setBackgroundColor(Color.parseColor(image.color))

    load(image.urls) {
        crossfade(300)
    }
}