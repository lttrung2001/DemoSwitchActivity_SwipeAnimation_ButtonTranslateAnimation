package com.ltbth.demo

import androidx.room.*

@Dao
interface StudentDAO {
    @Insert
    fun insert(student: Student2)

    @Update
    fun update(student: Student2)
    @Delete
    fun delete(student: Student2)

    @Query("SELECT * FROM students")
    fun getAllStudent(): List<Student2>
}