package com.unityfoods.mmvmcoroutineretrofit.room

import com.unityfoods.mmvmcoroutineretrofit.model.ApiUser
import com.unityfoods.mmvmcoroutineretrofit.model.User


class DatabaseHelperImpl(private val appDatabase: AppDatabase) : DatabaseHelper {

    override suspend fun getUsers(): List<User> = appDatabase.userDao().getAll()

    override suspend fun insertAll(users: List<User>) = appDatabase.userDao().insertAll(users)
    override suspend fun insertAllApiUser(users: ArrayList<ApiUser>) =
        appDatabase.userDao().insertAllApiUser(users)

    override suspend fun getApiUsers() = appDatabase.userDao().getAllApiUser()

}