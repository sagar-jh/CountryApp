package com.kodeco.android.countryinfo.networking

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getSystemService
import com.kodeco.android.countryinfo.model.Country
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://restcountries.com/v3.1/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create().asLenient())
    .baseUrl(BASE_URL)
    .build()

interface CountryAPI {
    @GET("all")
    suspend fun getCountries(): Response<List<Country>>
}

object CountryApiObject {
    val retrofitService : CountryAPI by lazy {
        retrofit.create(CountryAPI::class.java)
    }


}





