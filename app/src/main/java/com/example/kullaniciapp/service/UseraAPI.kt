package com.example.kullaniciapp.service

import com.example.kullaniciapp.model.User
import retrofit2.http.GET


interface UseraAPI {

    @GET("atilsamancioglu/UsersJSONPlaceHolder/refs/heads/main/users.json")
    suspend fun getData() : List<User>

    @GET("atilsamancioglu/UsersJSONPlaceHolder/refs/heads/main/users.json")
    suspend fun getSingleUser() : List<User>
}