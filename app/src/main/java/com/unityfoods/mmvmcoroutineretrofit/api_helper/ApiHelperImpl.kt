package com.unityfoods.mmvmcoroutineretrofit.api_helper

import com.unityfoods.mmvmcoroutineretrofit.retrofit.ApiService

class ApiHelperImpl(private val apiService: ApiService) {

    suspend fun getUsers() = apiService.getUsers()

    suspend fun getMoreUsers() = apiService.getMoreUsers()

    suspend fun getUsersWithError() = apiService.getUsersWithError()

}