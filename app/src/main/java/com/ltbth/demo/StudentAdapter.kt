package com.ltbth.demo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(private val students: List<Student2>) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {
    class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val id = itemView.findViewById<TextView>(R.id.student_id)
        val name = itemView.findViewById<TextView>(R.id.student_name)
        val address = itemView.findViewById<TextView>(R.id.student_address)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.let {
            val student = students[position]
            it.id.text = student.id.toString()
            it.name.text = student.fullName
            it.address.text = student.address
        }
    }

    override fun getItemCount(): Int {
        return students.size
    }
}