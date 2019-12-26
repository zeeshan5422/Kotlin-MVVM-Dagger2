package com.zues.mvvm_dagger2_sample.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.zues.mvvm_dagger2_sample.db.entities.User

/* ---  Created by akhtarz on 12/17/2019. ---*/
@Database(entities = [User::class], version = 1,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getUserDao() : UserDao
}