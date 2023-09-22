package com.example.common

import com.example.common.model.StudentModel
import com.example.common.repository.Repository

actual fun getPlatformName(): String {
    return "Android"
}

actual fun getStudents(): List<StudentModel> {
    val repository = Repository()

    return repository.getTeiByProgram().map {
        StudentModel(
            it.trackedEntityAttributeValues()?.get(0)?.value().toString(),
            it.trackedEntityAttributeValues()?.get(1)?.value().toString(),
            false
        )
    }
}