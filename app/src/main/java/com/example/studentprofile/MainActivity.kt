package com.example.studentprofile

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.studentprofile.databinding.ActivityMainBinding
import com.example.studentprofile.model.User

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnShowProfile.setOnClickListener {
            if (validateInputs()) {
                navigateToProfile()
            }
        }
    }

    private fun validateInputs(): Boolean {
        val name = binding.etFullName.text.toString().trim()
        val nim = binding.etNim.text.toString().trim()

        if (name.isEmpty()) {
            binding.etFullName.error = "Full name is required"
            binding.etFullName.requestFocus()
            return false
        }

        if (nim.isEmpty()) {
            binding.etNim.error = "NIM is required"
            binding.etNim.requestFocus()
            return false
        }

        if (binding.rgGender.checkedRadioButtonId == -1) {
            Toast.makeText(this, "Please select your gender", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

    private fun navigateToProfile() {
        val name = binding.etFullName.text.toString().trim()
        val nim = binding.etNim.text.toString().trim()
        val studyProgram = binding.spinnerProgram.selectedItem.toString()

        val gender = when (binding.rgGender.checkedRadioButtonId) {
            R.id.rbMale -> "Male"
            R.id.rbFemale -> "Female"
            else -> ""
        }

        val hobbies = mutableListOf<String>().apply {
            if (binding.cbCoding.isChecked) add("Coding")
            if (binding.cbGaming.isChecked) add("Gaming")
            if (binding.cbReading.isChecked) add("Reading")
            if (binding.cbDesign.isChecked) add("Design")
            if (binding.cbMusic.isChecked) add("Music")
        }

        val user = User(
            fullName = name,
            nim = nim,
            studyProgram = studyProgram,
            gender = gender,
            hobbies = hobbies
        )

        val intent = Intent(this, ProfileActivity::class.java).apply {
            putExtra(ProfileActivity.EXTRA_USER, user)
        }
        startActivity(intent)
    }
}