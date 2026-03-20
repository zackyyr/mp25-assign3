package com.example.studentprofile

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.studentprofile.databinding.ActivityProfileBinding
import com.example.studentprofile.model.User

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    companion object {
        const val EXTRA_USER = "extra_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(EXTRA_USER, User::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_USER)
        }

        user?.let { displayProfile(it) } ?: finish()

        binding.btnBack.setOnClickListener {
            finish()
        }
    }

    private fun displayProfile(user: User) {
        binding.tvNameValue.text = user.fullName
        binding.tvNimValue.text = user.nim
        binding.tvNimLabel.text = "NIM • ${user.nim}"
        binding.tvProgramValue.text = user.studyProgram
        binding.tvGenderValue.text = user.gender
        binding.tvHobbiesValue.text = if (user.hobbies.isEmpty()) {
            "No hobbies selected"
        } else {
            user.hobbies.joinToString(", ")
        }
        binding.tvAvatarEmoji.text = if (user.gender == "Male") "👨‍💻" else "👩‍💻"
    }
}