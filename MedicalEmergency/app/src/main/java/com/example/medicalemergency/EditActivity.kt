package com.example.medicalemergency

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.os.Bundle
import android.telephony.PhoneNumberFormattingTextWatcher
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.medicalemergency.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    private lateinit var binding : ActivityEditBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bloodTypeSpinner.adapter = ArrayAdapter.createFromResource(
            this,
            R.array.blood_types,
            android.R.layout.simple_list_item_1
        )

        binding.brithDateLayer.setOnClickListener {
            val listener = OnDateSetListener { _, year, month, dayOfMonth ->
                binding.brithDateValueTextView.text = "$year-${month.inc()}-$dayOfMonth"
            }
            DatePickerDialog(
                this,
                listener,
                2000,
                1,
                1
            ).show()
        }

        // Check에 따라 Visible 설정
        binding.waringEditView.isVisible = binding.waringCheckBox.isChecked
        binding.waringCheckBox.setOnCheckedChangeListener { _, isChecked ->
            binding.waringEditView.isVisible = isChecked
        }

        binding.contactEditView.addTextChangedListener(PhoneNumberFormattingTextWatcher())

        // 저장 버튼 시 Data 저장 및 Activity 종료
        binding.SaveButton.setOnClickListener {
            saveData()
            finish()
        }
    }

    private fun saveData() {
        with(getSharedPreferences(USER_INFORMATION, MODE_PRIVATE).edit()) {
            this.putString(NAME, binding.nameEditView.text.toString())
            this.putString(BLOOD_TYPE, getBloodType())
            this.putString(EMERGENCY_CONTACT, binding.contactEditView.text.toString())
            Log.d("phone", binding.contactEditView.text.toString())
            this.putString(BIRTHDATE, binding.brithDateValueTextView.text.toString())
            this.putString(WARNING, getWarning())
            this.apply()
        }
        // apply는 쓰레드를 비동기적으로 작동(권장)
        // commit는 쓰레드를 동기적으로 작동
        Toast.makeText(this, "저장 완료", Toast.LENGTH_SHORT).show()
    }

    private fun getBloodType() : String {
        val bloodAlphabet = binding.bloodTypeSpinner.selectedItem.toString()
        val bloodSign = if (binding.bloodTypePlus.isChecked) "+" else "-"
        return "$bloodSign $bloodAlphabet"
    }

    private fun getWarning() : String{
        return if (binding.waringCheckBox.isChecked) binding.waringEditView.text.toString() else ""
    }
}