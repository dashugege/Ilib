package com.soyoung.coroutines_lib

import retrofit2.http.GET

interface RequestServices {

    @GET("")
    suspend fun getAllPlants() : Plant
}