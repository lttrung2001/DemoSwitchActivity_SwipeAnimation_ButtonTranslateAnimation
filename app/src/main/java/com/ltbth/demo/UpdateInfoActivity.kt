package com.ltbth.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.widget.Button
import android.widget.EditText
import java.io.Serializable

class UpdateInfoActivity : AppCompatActivity(), Serializable {
    private lateinit var edtId: EditText
    private lateinit var edtName: EditText
    private lateinit var edtAddress: EditText
    private lateinit var btnShowAll: Button
    private lateinit var btnBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_info)
        edtId = findViewById(R.id.edt_id)
        edtName = findViewById(R.id.edt_name)
        edtAddress = findViewById(R.id.edt_address)
        btnShowAll = findViewById(R.id.btn_show_all)
        btnBack = findViewById(R.id.btn_back)

        val student = intent.getSerializableExtra("student") as Student
        edtId.setText(student.id.toString())
        edtName.setText(student.fullName)
        edtAddress.setText(student.address)

        btnShowAll.setOnClickListener {
            showAll()
        }

        btnBack.setOnClickListener {
            this.finish()
        }
    }

    private fun showAll() {
        for (item: Student in StudentList.students) {
            Log.d(item.id.toString(),"${item.fullName.toString()} - ${item.address.toString()}")
        }

    }

    override fun onBackPressed() {
        Log.d("message","Finish this activity")
        this.finish()
        super.onBackPressed()
    }
}