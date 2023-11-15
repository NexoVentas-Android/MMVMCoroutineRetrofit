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

//@Entity
//data class User(
//    @PrimaryKey val id: Int,
//    @ColumnInfo(name = "name") val name: String?,
//    @ColumnInfo(name = "email") val email: String?,
//    @ColumnInfo(name = "avatar") val avatar: String?
//)