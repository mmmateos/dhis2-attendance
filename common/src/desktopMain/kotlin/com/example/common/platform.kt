package com.example.common

import com.example.common.model.StudentModel

actual fun getPlatformName(): String {
    return "Desktop"
}

actual fun getStudents(): List<StudentModel> {
    TODO("Not yet implemented")
}