package com.unityfoods.mmvmcoroutineretrofit.room

import com.unityfoods.mmvmcoroutineretrofit.model.ApiUser


interface DatabaseHelper {

/*
    suspend fun getUsers(): List<User>

    suspend fun insertAll(users: List<User>)
*/

    suspend fun getApiUsers(): List<ApiUser>

    suspend fun insertAllApiUser(users: ArrayList<ApiUser>)

}