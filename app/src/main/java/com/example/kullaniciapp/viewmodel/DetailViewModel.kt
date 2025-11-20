package com.example.kullaniciapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.kullaniciapp.model.User
import com.example.kullaniciapp.service.UseraAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailViewModel : ViewModel(){

    private val BASE_URL = "https://raw.githubusercontent.com/"

    val retrofit =  Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(UseraAPI::class.java)


    suspend fun getSingleUser(id : Int): User {
        val user = retrofit.getSingleUser()[id]
        return user
    }
}