package com.ltbth.demo

import java.io.Serializable

class Student (fullName: String, address: String) : Serializable {
    var id: Int
    var fullName: String
    var address: String
    init {
        this.id = MAX_ID
        this.fullName = fullName
        this.address = address
    }
    constructor(id: Int, fullName: String, address: String) : this(fullName, address) {
        this.id = id
        this.fullName = fullName
        this.address = address
    }
    companion object {
        private var START_ID = 0
        val MAX_ID get() = ++START_ID
    }
}