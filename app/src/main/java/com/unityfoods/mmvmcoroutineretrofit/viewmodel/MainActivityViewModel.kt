package com.unityfoods.mmvmcoroutineretrofit.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.unityfoods.mmvmcoroutineretrofit.repository.MainClassRepository
import com.unityfoods.mmvmcoroutineretrofit.utils.UiState
import com.unityfoods.mmvmcoroutineretrofit.model.ApiUser
import com.unityfoods.mmvmcoroutineretrofit.room.DatabaseHelper
import kotlinx.coroutines.launch

class MainActivityViewModel(
    private val mainClassRepository: MainClassRepository,
    private val dbHelper: DatabaseHelper
) : ViewModel() {

    private val uiState = MutableLiveData<UiState<List<ApiUser>>>()

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            uiState.postValue(UiState.Loading)
            try {
                val usersFromApi = mainClassRepository.getUsers()
                dbHelper.insertAllApiUser(usersFromApi)
                uiState.postValue(UiState.Success(usersFromApi))
            } catch (e: Exception) {
                uiState.postValue(UiState.Error(e.toString()))
            }
        }
    }

    fun getUiState(): LiveData<UiState<List<ApiUser>>> {
        return uiState
    }

}