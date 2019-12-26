package com.zues.mvvm_dagger2_sample.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.zues.mvvm_dagger2_sample.db.entities.CURRENT_USER_ID
import com.zues.mvvm_dagger2_sample.db.entities.User

/* ---  Created by akhtarz on 12/4/2019. ---*/
@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(user: User)  :Long

    @Query("SELECT * FROM user WHERE uid = $CURRENT_USER_ID")
    fun getUser()  : LiveData<User>
}