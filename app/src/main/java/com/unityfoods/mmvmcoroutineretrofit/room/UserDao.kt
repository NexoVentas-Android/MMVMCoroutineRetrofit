package com.unityfoods.mmvmcoroutineretrofit.room

import androidx.room.*
import com.unityfoods.mmvmcoroutineretrofit.model.ApiUser
import com.unityfoods.mmvmcoroutineretrofit.model.User

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    suspend fun getAll(): List<User>

    @Insert
    suspend fun insertAll(users: List<User>)

    @Delete
    suspend fun delete(user: User)

    @Query("SELECT * FROM ApiUser")
    suspend fun getAllApiUser(): List<ApiUser>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAllApiUser(users: ArrayList<ApiUser>)

    @Delete
    suspend fun deleteApiUser(user: ApiUser)

}