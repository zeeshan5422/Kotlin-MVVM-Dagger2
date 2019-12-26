package com.zues.mvvm_dagger2_sample.data.repository

import com.zues.mvvm_dagger2_sample.data.network.MyApi
import com.zues.mvvm_dagger2_sample.data.network.responses.AuthResponse
import com.zues.mvvm_dagger2_sample.db.AppDatabase
import com.zues.mvvm_dagger2_sample.db.UserDao
import com.zues.mvvm_dagger2_sample.db.entities.User
import com.zues.mvvm_dagger2_sample.utils.ApiException
import org.json.JSONException
import org.json.JSONObject
import java.lang.StringBuilder
import javax.inject.Inject

/* ---  Created by akhtarz on 12/17/2019. ---*/
class UserRepository @Inject constructor(val myApi: MyApi, val db: AppDatabase){
    suspend fun userLogin(email: String, password: String) : AuthResponse {


        val response = myApi.userLogin(email = email, password = password)

        if (response.isSuccessful){
            return response.body()!!
        }else{
            val error = response.errorBody()?.string()

            val message = StringBuilder()
            error?.let {
                try {
                    message.append(JSONObject(it).getString("message"))
                } catch (e: JSONException){ }
                message.append("\n")
            }
            message.append("Error Code: ${response.code()}")
            throw ApiException(message.toString())
        }
    }

    suspend fun saveUser(user: User){
        db.getUserDao().upsert(user)
    }

    fun getUser() = db.getUserDao().getUser()
}