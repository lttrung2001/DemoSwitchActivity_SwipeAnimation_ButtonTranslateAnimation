package com.ltbth.demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.io.Serializable

class UpdateInfoActivity : AppCompatActivity(), Serializable {
    private lateinit var edtId: TextView
    private lateinit var edtName: TextView
    private lateinit var edtAddress: TextView
    private lateinit var btnBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_info)
        edtId = findViewById(R.id.edt_id)
        edtName = findViewById(R.id.edt_name)
        edtAddress = findViewById(R.id.edt_address)

        btnBack = findViewById(R.id.btn_back)

        val student = intent.getSerializableExtra("student") as Student
        edtId.setText(student.id.toString())
        edtName.setText(student.fullName)
        edtAddress.setText(student.address)

        btnBack.setOnClickListener {
            this.finish()
        }
    }

    override fun onBackPressed() {
        Log.d("message","Finish this activity")
        this.finish()
        super.onBackPressed()
    }
}