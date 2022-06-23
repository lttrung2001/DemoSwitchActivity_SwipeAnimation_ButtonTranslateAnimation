package com.ltbth.demo

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Student2::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getStudentDAO(): StudentDAO
}