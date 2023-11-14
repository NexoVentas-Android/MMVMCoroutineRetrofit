package com.unityfoods.mmvmcoroutineretrofit


interface DatabaseHelper {

    suspend fun getUsers(): List<User>

    suspend fun insertAll(users: List<User>)

}