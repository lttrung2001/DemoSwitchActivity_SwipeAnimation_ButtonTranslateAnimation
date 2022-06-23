package com.ltbth.demo

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.P)
class DatabaseHandler(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {
    companion object {
        val DATABASE_NAME = "studentManager"
        val DATABASE_VERSION = 1
        val TABLE_NAME = "students"
        val KEY_ID = "id"
        val KEY_NAME = "name"
        val KEY_ADDRESS = "address"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE $TABLE_NAME($KEY_ID INTEGER PRIMARY KEY, $KEY_NAME TEXT, $KEY_ADDRESS TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addStudent(student: Student) {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(KEY_ID, student.id)
        contentValues.put(KEY_NAME, student.fullName)
        contentValues.put(KEY_ADDRESS, student.address)

        db.insert(TABLE_NAME,null,contentValues)
        db.close()
    }

    fun getAllStudent(): List<Student> {
        val students = arrayListOf<Student>()
        val query = "SELECT * FROM $TABLE_NAME"
        val db = this.readableDatabase
        val cursor = db.rawQuery(query,null)
        cursor.moveToFirst()
        var student: Student?
        while (!cursor.isAfterLast) {
            student = Student(cursor.getInt(0),cursor.getString(1),cursor.getString(2))
            students.add(student)
            cursor.moveToNext()
        }
        return students
    }
}