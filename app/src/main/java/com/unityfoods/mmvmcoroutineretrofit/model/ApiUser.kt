package com.unityfoods.mmvmcoroutineretrofit.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class ApiUser(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,

    @SerializedName("name")
    val name: String = "",

    @SerializedName("email")
    val email: String = "",

    @SerializedName("avatar")
    val avatar: String = ""
)