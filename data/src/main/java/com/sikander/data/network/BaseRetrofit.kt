package com.sikander.data.network

import com.google.gson.Gson
import com.sikander.data.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BaseRetrofit @Inject constructor(
    okHttpClient: OkHttpClient,
    gson: Gson,
) {
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        //.addCallAdapterFactory(RxJavaCustomCallAdapterFactory.create()) //Has to be on top of the other adapters
        .addConverterFactory(GsonConverterFactory.create(gson))
        //.addCallAdapterFactory(RxJava3CallAdapterFactory.createWithScheduler(Schedulers.io()))
        .client(okHttpClient)
        .build()
}