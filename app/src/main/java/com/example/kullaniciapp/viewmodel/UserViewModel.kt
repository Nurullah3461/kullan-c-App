package com.example.kullaniciapp.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kullaniciapp.model.User
import com.example.kullaniciapp.service.UseraAPI
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class UserViewModel: ViewModel() {

    private val BASE_URL = "https://raw.githubusercontent.com/"

    val retrofit =  Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(UseraAPI::class.java)

    val userList = mutableStateOf<List<User>>(listOf())

    fun getUsers(){
        viewModelScope.launch {
            userList.value = retrofit.getData()
        }
    }


}