package com.example.minitwitter.utils

import android.content.Context
import com.example.minitwitter.realm.RealmUtils
import okhttp3.Interceptor
import okhttp3.Response

class AuthIntercpetor(val context: Context): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val token = RealmUtils.realmData(context).obtenerToken()!!.token
        val request = chain.request().newBuilder().addHeader("Authorization","Bearer $token").build()
        return chain.proceed(request)
    }
}