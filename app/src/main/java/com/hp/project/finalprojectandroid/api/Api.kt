package com.hp.project.finalprojectandroid.api

import com.hp.project.finalprojectandroid.models.LoginRequest
import com.hp.project.finalprojectandroid.models.LucaoResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {

    @GET("apiLucao")
    fun buscarApiLucao(): Call<LucaoResponse>

    @POST("login")
    fun login(@Body request: LoginRequest): Call<LoginRequest>

}