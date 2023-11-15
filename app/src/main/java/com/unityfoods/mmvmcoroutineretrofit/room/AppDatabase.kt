package com.unityfoods.mmvmcoroutineretrofit.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.unityfoods.mmvmcoroutineretrofit.model.ApiUser
import com.unityfoods.mmvmcoroutineretrofit.model.User

@Database(entities = [User::class,ApiUser::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

}