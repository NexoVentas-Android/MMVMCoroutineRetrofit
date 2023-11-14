package com.unityfoods.mmvmcoroutineretrofit.room

import com.unityfoods.mmvmcoroutineretrofit.model.User


class DatabaseHelperImpl(private val appDatabase: AppDatabase) : DatabaseHelper {

    override suspend fun getUsers(): List<User> = appDatabase.userDao().getAll()

    override suspend fun insertAll(users: List<User>) = appDatabase.userDao().insertAll(users)

}