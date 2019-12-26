package com.zues.mvvm_dagger2_sample.data.network

import android.provider.ContactsContract
import com.zues.mvvm_dagger2_sample.data.network.responses.AuthResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import javax.inject.Inject

/* ---  Created by akhtarz on 12/17/2019. ---*/
interface MyApi{

    @FormUrlEncoded
    @POST("mvvm/login")
    suspend fun userLogin(@Field("email")email: String,
                  @Field("password") password: String):Response<AuthResponse>

}