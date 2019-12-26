package com.zues.mvvm_dagger2_sample.di.modules

import com.zues.mvvm_dagger2_sample.data.network.MyApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/* ---  Created by akhtarz on 12/19/2019. ---*/
@Module
class NetworkModule {

    @Provides
    fun provideOkHTTP () = OkHttpClient.Builder()
        .build()

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient) : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.simplifiedcoding.in/course-apis/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Provides
    fun provideMyApi(retrofit: Retrofit) : MyApi {
        return retrofit.create(MyApi::class.java)
    }

}