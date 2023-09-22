package com.example.common

import com.example.common.model.StudentModel

expect fun getPlatformName(): String
expect fun getStudents(): List<StudentModel>