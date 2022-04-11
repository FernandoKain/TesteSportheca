package br.com.dio.testesportheca.util

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkUtils2 {
    companion object{
        fun getRetrofitInstance2(path: String) : Retrofit {
            return Retrofit.Builder()
                .baseUrl(path)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}