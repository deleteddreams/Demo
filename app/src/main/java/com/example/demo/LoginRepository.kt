package com.example.demo

class LoginRepository constructor(private val retrofitService: RetrofitService?) {

    fun login(loginRequest: LoginRequest) = retrofitService?.login(loginRequest);
}