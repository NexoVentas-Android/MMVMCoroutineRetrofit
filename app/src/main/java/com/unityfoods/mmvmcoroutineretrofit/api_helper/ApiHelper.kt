package com.unityfoods.mmvmcoroutineretrofit.api_helper

import com.unityfoods.mmvmcoroutineretrofit.model.ApiUser


interface ApiHelper {

    suspend fun getUsers(): List<ApiUser>

    suspend fun getMoreUsers(): List<ApiUser>

    suspend fun getUsersWithError(): List<ApiUser>

}