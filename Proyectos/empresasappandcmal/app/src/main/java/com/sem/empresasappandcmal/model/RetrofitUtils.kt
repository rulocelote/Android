package com.sem.empresasappandcmal.model

import com.sem.empresasappandcmal.utils.Constants.URL_BASE
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitUtils {
    private var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(URL_BASE)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getRetrofit():Retrofit{
        return retrofit
    }
}

fun<T> Call<T>.onEnqueue(success: (Response<T>) -> Unit, failure: (t: Throwable?) -> Unit)   {
    this.enqueue(object: Callback<T>    {
        override fun onFailure(call: Call<T>?, t: Throwable?) { failure(t) }
        override fun onResponse(call: Call<T>?, response: Response<T>) { success(response) }
    })
}