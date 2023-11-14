package com.unityfoods.mmvmcoroutineretrofit.room

import com.unityfoods.mmvmcoroutineretrofit.model.User


interface DatabaseHelper {

    suspend fun getUsers(): List<User>

    suspend fun insertAll(users: List<User>)

}