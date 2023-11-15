package com.unityfoods.mmvmcoroutineretrofit.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.unityfoods.mmvmcoroutineretrofit.api_helper.ApiHelperImpl
import com.unityfoods.mmvmcoroutineretrofit.room.DatabaseHelper

class ViewModelFactory(private val apiHelper: ApiHelperImpl, private val dbHelper: DatabaseHelper) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SingleNetworkCallViewModel::class.java)) {
            return SingleNetworkCallViewModel(apiHelper, dbHelper) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}