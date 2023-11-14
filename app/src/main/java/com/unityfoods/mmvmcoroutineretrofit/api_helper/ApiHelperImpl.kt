package com.unityfoods.mmvmcoroutineretrofit.api_helper

import com.unityfoods.mmvmcoroutineretrofit.retrofit.ApiService

class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {

    override suspend fun getUsers() = apiService.getUsers()

    override suspend fun getMoreUsers() = apiService.getMoreUsers()

    override suspend fun getUsersWithError() = apiService.getUsersWithError()

}