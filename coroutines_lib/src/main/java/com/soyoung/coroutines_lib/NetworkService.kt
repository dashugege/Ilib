package com.soyoung.coroutines_lib

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class NetworkService {


    companion object {
        val instance = SingletonHolder.holder
    }

    private object SingletonHolder {
        val holder= NetworkService()
    }

    var retrofit = Retrofit.Builder()
        .baseUrl("https://")
        .client(OkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    private val service = retrofit.create(RequestServices::class.java)





    suspend fun allPlants(): Plant = withContext(Dispatchers.Default) {
         service.getAllPlants()
    }


}