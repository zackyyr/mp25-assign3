package com.example.studentprofile.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val fullName: String,
    val nim: String,
    val studyProgram: String,
    val gender: String,
    val hobbies: List<String>
) : Parcelable