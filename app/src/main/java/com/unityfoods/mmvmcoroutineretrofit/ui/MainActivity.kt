package com.unityfoods.mmvmcoroutineretrofit.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.unityfoods.mmvmcoroutineretrofit.R
import com.unityfoods.mmvmcoroutineretrofit.viewmodel.SingleNetworkCallViewModel
import com.unityfoods.mmvmcoroutineretrofit.utils.UiState
import com.unityfoods.mmvmcoroutineretrofit.viewmodel.ViewModelFactory
import com.unityfoods.mmvmcoroutineretrofit.repository.MainClassRepository
import com.unityfoods.mmvmcoroutineretrofit.model.ApiUser
import com.unityfoods.mmvmcoroutineretrofit.adapter.ApiUserAdapter
import com.unityfoods.mmvmcoroutineretrofit.databinding.ActivityMainBinding
import com.unityfoods.mmvmcoroutineretrofit.retrofit.RetrofitBuilder
import com.unityfoods.mmvmcoroutineretrofit.room.DatabaseBuilder
import com.unityfoods.mmvmcoroutineretrofit.room.DatabaseHelperImpl

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: SingleNetworkCallViewModel
    private lateinit var adapter: ApiUserAdapter
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupUI()
        setupViewModel()
        setupObserver()
    }

    private fun setupUI() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter =
            ApiUserAdapter(
                arrayListOf()
            )
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                binding.recyclerView.context,
                (binding.recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        binding.recyclerView.adapter = adapter
    }

    private fun setupObserver() {
        viewModel.getUiState().observe(this) {
            when (it) {
                is UiState.Success -> {
                    binding.progressBar.visibility = View.GONE
                    renderList(it.data)
                    binding.recyclerView.visibility = View.VISIBLE
                }
                is UiState.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.recyclerView.visibility = View.GONE
                }
                is UiState.Error -> {
                    //Handle Error
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun renderList(users: List<ApiUser>) {
        adapter.addData(users)
        adapter.notifyDataSetChanged()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(
                MainClassRepository(RetrofitBuilder.apiService),
                DatabaseHelperImpl(DatabaseBuilder.getInstance(applicationContext))
            )
        )[SingleNetworkCallViewModel::class.java]
    }
}
