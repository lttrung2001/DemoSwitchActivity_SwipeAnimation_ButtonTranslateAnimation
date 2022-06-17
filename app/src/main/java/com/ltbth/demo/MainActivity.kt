package com.ltbth.demo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var edtName: EditText
    private lateinit var edtAddress: EditText
    private lateinit var btnSend: Button
    private lateinit var btn2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edtName = findViewById(R.id.edt_fullname)
        edtAddress = findViewById(R.id.edt_address)
        btnSend = findViewById(R.id.btn_send)
        btnSend.setOnClickListener {
            sendInfo()
        }

        // Slide button animation
        btn2 = findViewById(R.id.btn2)
        var isClicked = false
        btn2.setOnClickListener {
            if (!isClicked) {
                it.animate().translationX(300F).withLayer().duration = 400
                isClicked = true
            } else {
                it.animate().translationX(0F).withLayer().duration = 400
                isClicked = false
            }
        }
    }

    private fun sendInfo() {
        val student = Student(edtName.text.toString(), edtAddress.text.toString())
        StudentList.students.add(student)
        var intent = Intent(this,UpdateInfoActivity::class.java)
        intent.putExtra("student", student)
        startActivity(intent)
        this@MainActivity.overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right)
    }
}