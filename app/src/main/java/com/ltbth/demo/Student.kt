package com.ltbth.demo

import java.io.Serializable

class Student (fullName: String, address: String) : Serializable {
    public val id: Int
    public var fullName: String
    public var address: String
    init {
        this.id = Student.MAX_ID
        this.fullName = fullName
        this.address = address
    }
    companion object {
        private var START_ID = 0
        val MAX_ID get() = ++START_ID
    }
}