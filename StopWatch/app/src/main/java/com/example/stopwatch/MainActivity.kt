package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.stopwatch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startButton.setOnClickListener {
            start()
        }

        binding.stopButton.setOnClickListener {
            stop()
        }

        binding.pauseButton.setOnClickListener {
            pause()
        }

        binding.lapButton.setOnClickListener {
            lap()
        }
    }

    private fun start() {
        TODO("Not yet implemented")
    }

    private fun lap() {
        TODO("Not yet implemented")
    }

    private fun pause() {
        TODO("Not yet implemented")
    }

    private fun stop() {
        TODO("Not yet implemented")
    }

}