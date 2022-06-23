package com.ltbth.demo

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "students")
data class Student2(@PrimaryKey
                    @ColumnInfo(name = "id") val id: Int,
                    @ColumnInfo(name = "name") val fullName: String?,
                    @ColumnInfo(name = "address") val address: String?)
    : Serializable
