package com.example.medicalemergency

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.medicalemergency.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goEditActivityButton.setOnClickListener {
            var intent = Intent(this, EditActivity::class.java)
            intent.putExtra("intentMessage", "응급의료정보")
            startActivity(intent)
        }

        binding.DeleteButton.setOnClickListener {
            deleteData()
        }

        binding.contactLayer.setOnClickListener {
            with(Intent(Intent.ACTION_VIEW)) {
                var phoneNumber = binding.contactValueTextView.text.toString().replace("-", "")
                data = Uri.parse("tel:$phoneNumber")
                startActivity(this)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        getDataAndUpdateUi()
    }

    private fun getDataAndUpdateUi() {
        with(getSharedPreferences("userInformation", MODE_PRIVATE)) {
            binding.nameValueTextView.text = getString(NAME, "미정")
            binding.brithDateValueTextView.text = getString(BIRTHDATE, "미정")
            binding.bloodTypeValueTextView.text = getString(BLOOD_TYPE, "미정")
            binding.contactValueTextView.text = getString(EMERGENCY_CONTACT, "미정")
            var str = getString(EMERGENCY_CONTACT, "미정")

            Log.d("main_phone", str ?: "없음")
            val warning = getString(WARNING, "")

            binding.warningTextView.isVisible = !warning.isNullOrEmpty()
            binding.warningValueTextView.isVisible = !warning.isNullOrEmpty()

            if (!warning.isNullOrEmpty()) {
                binding.warningValueTextView.text = warning
            }
        }
    }

    private fun deleteData() {
        with(getSharedPreferences(USER_INFORMATION, MODE_PRIVATE).edit()) {
            clear()
            apply()
            getDataAndUpdateUi()
        }
        Toast.makeText(this, "초기화 완료", Toast.LENGTH_SHORT).show()
    }
}