package com.unityfoods.mmvmcoroutineretrofit.repository

import com.unityfoods.mmvmcoroutineretrofit.retrofit.ApiService

class MainClassRepository(private val apiService: ApiService) {

    suspend fun getUsers() = apiService.getUsers()

    suspend fun getMoreUsers() = apiService.getMoreUsers()

    suspend fun getUsersWithError() = apiService.getUsersWithError()

}