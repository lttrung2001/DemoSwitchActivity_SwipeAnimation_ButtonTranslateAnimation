package com.ltbth.demo

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
@RequiresApi(Build.VERSION_CODES.P)
class ShowAllActivity : AppCompatActivity() {
    private lateinit var studentAdapter: StudentAdapter
    private lateinit var studentRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_all)

//        val db = DatabaseHandler(this,DatabaseHandler.DATABASE_NAME,null,DatabaseHandler.DATABASE_VERSION)
        val room = Room.databaseBuilder(applicationContext,AppDatabase::class.java,"studentManager")
            .allowMainThreadQueries()
            .build()
        val dao = room.getStudentDAO()
        studentRecyclerView = findViewById(R.id.rcv_student)
//        studentAdapter = StudentAdapter(db.getAllStudent())
        studentAdapter = StudentAdapter(dao.getAllStudent())
        studentRecyclerView.adapter = studentAdapter
        studentRecyclerView.layoutManager = LinearLayoutManager(this)
    }
}