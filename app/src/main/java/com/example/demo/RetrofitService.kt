package com.example.demo

import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface RetrofitService {

    @POST("user-account/login")
    fun login(@Body loginRequest: LoginRequest): Call<LoginResponse>

    companion object {

        var retrofitService: RetrofitService? = null

        fun getInstance(): RetrofitService {
            var logging: HttpLoggingInterceptor = HttpLoggingInterceptor()

            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            var httpClient: OkHttpClient.Builder  =  OkHttpClient.Builder()

            httpClient.addInterceptor(logging);
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("http://192.99.18.90:8001/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}