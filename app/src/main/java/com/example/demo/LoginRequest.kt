package com.example.demo

data class LoginRequest (var username: String, var password: String, var grant_type:String, var device_token:String, var device_type: String)