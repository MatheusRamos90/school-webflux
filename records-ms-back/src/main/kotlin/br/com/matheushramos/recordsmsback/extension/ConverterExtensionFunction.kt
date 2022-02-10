package br.com.matheushramos.recordsmsback.extension

import br.com.matheushramos.recordsmsback.dtos.CoursePostRequest
import br.com.matheushramos.recordsmsback.dtos.CourseResponse
import br.com.matheushramos.recordsmsback.dtos.StudentPostRequest
import br.com.matheushramos.recordsmsback.dtos.StudentResponse
import br.com.matheushramos.recordsmsback.enums.EnumStatus
import br.com.matheushramos.recordsmsback.models.Course
import br.com.matheushramos.recordsmsback.models.Student

fun Student.toResponse(): StudentResponse {
    return StudentResponse(
        id = this.id,
        name = this.name,
        email = this.email,
        numberDocument = this.numberDocument,
        status = this.status,
        createAt = this.createAt.toString(),
        updateAt = this.updateAt.toString()
    )
}

fun StudentPostRequest.toModel(): Student {
    return Student(
        name = this.name,
        email = this.email,
        password = this.password,
        numberDocument = this.numberDocument,
        status = EnumStatus.ACTIVE
    )
}

fun Course.toResponse(): CourseResponse {
    return CourseResponse(
        id = this.id,
        name = this.name,
        price = this.price,
        status = this.status,
        createAt = this.createAt.toString(),
        updateAt = this.updateAt.toString()
    )
}

fun CoursePostRequest.toModel(): Course {
    return Course(
        name = this.name,
        price = this.price,
        status = EnumStatus.ACTIVE
    )
}