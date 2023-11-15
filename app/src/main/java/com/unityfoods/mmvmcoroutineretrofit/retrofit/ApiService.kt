package com.unityfoods.mmvmcoroutineretrofit.retrofit

import com.unityfoods.mmvmcoroutineretrofit.model.ApiUser
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUsers(): ArrayList<ApiUser>

    @GET("more-users")
    suspend fun getMoreUsers(): List<ApiUser>

    @GET("error")
    suspend fun getUsersWithError(): List<ApiUser>

}