package com.example.json_fromurl.common

import com.example.json_fromurl.`interface`.RetrofitService
import com.example.json_fromurl.retrofit.RetrofitClient

object Common {
    private val BASE_URL = "https://www.simplifiedcoding.net/demos/"
    val retrofitService:RetrofitService
    get() = RetrofitClient.getClient(BASE_URL).create(RetrofitService::class.java)
}